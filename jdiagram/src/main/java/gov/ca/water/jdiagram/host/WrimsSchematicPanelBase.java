package gov.ca.water.jdiagram.host;

import java.time.Month;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.common.flogger.FluentLogger;
import gov.ca.water.hecdssvue.DssPluginCore;
import gov.ca.water.jdiagram.core.SchematicContext;
import gov.ca.water.jdiagram.core.SchematicPanelBase;
import gov.ca.water.wrims.gui.ide.debugger.core.DebugCorePlugin;

import hec.heclib.dss.HecDss;
import hec.hecmath.HecMath;

/**
 * {@link SchematicPanelBase} for the WRIMS-hosted SchematicView.
 * <ul>
 * <li>Before values are calculated, copies the display state that WRIMS/DSS Vue own (units, Base/Diff mode, selected
 * months and selected studies) into the {@link SchematicContext}.</li>
 * <li>Implements {@link #loadAllSchematicVariableData()} by reading every schematic variable from the selected
 * studies' DV/SV DSS files, as the legacy SchematicBase did. The data is kept in
 * {@link DssPluginCore#allSchematicVariableData} so DSS Vue sees the same series; {@link WrimsSchematicDataSource}
 * serves it to the core from there.</li>
 * </ul>
 */
public class WrimsSchematicPanelBase extends SchematicPanelBase
{
	private static final FluentLogger logger = FluentLogger.forEnclosingClass();

	private static final int STUDY_COUNT = 4;

	/** Last host data array seen; when DSS Vue replaces it, cached long-term averages are stale. */
	private Object lastHostData;

	public WrimsSchematicPanelBase(SchematicContext context) {
		super(context);
	}

	@Override
	public Map<String, String>[] retrieveUndebug(String date, Map<String, Object> names) {
		syncFromHost();
		return super.retrieveUndebug(date, names);
	}

	@Override
	public Map<String, String>[] retrieveDebug(String date, Map<String, Object> names) {
		syncFromHost();
		return super.retrieveDebug(date, names);
	}

	/**
	 * Copies host-owned display state into the context. Formerly the legacy code read these statics directly.
	 */
	public synchronized void syncFromHost() {
		SchematicContext context = getContext();
		if (DssPluginCore.units != null) {
			context.setUnits(DssPluginCore.units);
		}
		if (DssPluginCore.mode != null) {
			context.setMode(DssPluginCore.mode);
		}
		List<Integer> hostMonths = DssPluginCore.months;
		if (hostMonths != null) {
			Set<Month> selected = EnumSet.noneOf(Month.class);
			for (Integer m : hostMonths) {
				if (m != null && m >= 1 && m <= 12) {
					selected.add(Month.of(m));
				}
			}
			if (!selected.equals(context.months())) {
				context.months().clear();
				context.months().addAll(selected);
			}
		}
		boolean[] studies = DebugCorePlugin.selectedStudies;
		if (studies != null) {
			for (int i = 0; i < Math.min(studies.length, STUDY_COUNT); i++) {
				context.setSelectedStudy(i, studies[i]);
			}
		}
		if (lastHostData != DssPluginCore.allSchematicVariableData) {
			lastHostData = DssPluginCore.allSchematicVariableData;
			clearLongTermAverages();
		}
	}

	private void clearLongTermAverages() {
		getContext().getLongTermAverageDataCFS().clear();
		getContext().getLongTermAverageDataTAF().clear();
	}

	/**
	 * Reads every schematic variable (see {@link SchematicContext#getAllSchematicVariableNames()}) for each selected
	 * study. Ported from the legacy SchematicBase.loadAllSchematicVariableData().
	 */
	@Override
	@SuppressWarnings("unchecked")
	public synchronized void loadAllSchematicVariableData() {
		syncFromHost();
		SchematicContext context = getContext();

		DssPluginCore.allSchematicVariableUnitsCFS = new HashMap[STUDY_COUNT];
		DssPluginCore.allSchematicVariableUnitsTAF = new HashMap[STUDY_COUNT];
		DssPluginCore.longTermAverageDataCFS = new HashMap<>();
		DssPluginCore.longTermAverageDataTAF = new HashMap<>();
		DssPluginCore.allSchematicVariableData = new HashMap[STUDY_COUNT];
		lastHostData = DssPluginCore.allSchematicVariableData;
		clearLongTermAverages();

		for (int kk = 0; kk < STUDY_COUNT; kk++) {
			DssPluginCore.allSchematicVariableData[kk] = new HashMap<>();
			DssPluginCore.allSchematicVariableUnitsCFS[kk] = new HashMap<>();
			DssPluginCore.allSchematicVariableUnitsTAF[kk] = new HashMap<>();
			context.getAllSchematicVariableUnitsCFS(kk).clear();
			context.getAllSchematicVariableUnitsTAF(kk).clear();

			if (isSelected(kk)) {
				HecDss dv = dss(DebugCorePlugin.dvDss, kk);
				if (dv != null) {
					dv.setTimeWindow(DebugCorePlugin.timeWindow);
				}
				HecDss sv = dss(DebugCorePlugin.svDss, kk);
				if (sv != null) {
					sv.setTimeWindow(DebugCorePlugin.timeWindow);
				}
			}
		}

		List<String> names = new ArrayList<>(context.getAllSchematicVariableNames());
		DssPluginCore.allSchematicVariableNames = new ArrayList<>(names);

		for (String variable : names) {
			if (variable == null) {
				continue;
			}
			String name = variable.toLowerCase();
			String pathName = DssPluginCore.allPathName == null ? null : DssPluginCore.allPathName.get(name);
			for (int i = 0; i < STUDY_COUNT; i++) {
				if (!isSelected(i)) {
					continue;
				}
				HecDss dvFile = dss(DebugCorePlugin.dvDss, i);
				HecDss svFile = dss(DebugCorePlugin.svDss, i);
				if (pathName != null) {
					// Known pathname: DV first, falling back to SV
					if (!read(dvFile, pathName, name, i)) {
						read(svFile, pathName, name, i);
					}
				} else {
					// Look the B part up in each file's catalog; SV wins if both have it, as before
					read(dvFile, pathnameFor(DssPluginCore.dvPathnameMap, i, name), name, i);
					read(svFile, pathnameFor(DssPluginCore.svPathnameMap, i, name), name, i);
				}
			}
		}
	}

	/**
	 * @return true if the series was found and stored
	 */
	private boolean read(HecDss file, String pathName, String name, int study) {
		if (file == null || pathName == null) {
			return false;
		}
		try {
			HecMath dataSet = file.read(pathName);
			if (dataSet == null) {
				return false;
			}
			String units = dataSet.getUnits();
			DssPluginCore.allSchematicVariableData[study].put(name, dataSet);
			DssPluginCore.allSchematicVariableUnitsCFS[study].put(name, units);
			DssPluginCore.allSchematicVariableUnitsTAF[study].put(name, units);
			// The context maps are ConcurrentHashMaps, which reject null values. The NPE used to be swallowed
			// below, so the read was reported as failed even though the data had been stored.
			if (units != null) {
				getContext().getAllSchematicVariableUnitsCFS(study).put(name, units);
				getContext().getAllSchematicVariableUnitsTAF(study).put(name, units);
			}
			return true;
		} catch (Exception e) {
			logger.atFine().withCause(e).log("Unable to read %s for study %d", pathName, study);
			return false;
		}
	}

	private static boolean isSelected(int study) {
		boolean[] studies = DebugCorePlugin.selectedStudies;
		return studies != null && study < studies.length && studies[study];
	}

	private static HecDss dss(HecDss[] files, int study) {
		return files == null || study >= files.length ? null : files[study];
	}

	private static String pathnameFor(Map<String, String>[] maps, int study, String name) {
		if (maps == null || study >= maps.length || maps[study] == null) {
			return null;
		}
		return maps[study].get(name);
	}
}
