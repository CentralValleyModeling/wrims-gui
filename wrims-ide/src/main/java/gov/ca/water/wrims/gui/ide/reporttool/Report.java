/*
 * Enhanced Post Processing Tool (EPPT) Copyright (c) 2019.
 *
 * EPPT is copyrighted by the State of California, Department of Water Resources. It is licensed
 * under the GNU General Public License, version 2. This means it can be
 * copied, distributed, and modified freely, but you may not restrict others
 * in their ability to copy, distribute, and modify it. See the license below
 * for more details.
 *
 * GNU General Public License
 */

package gov.ca.water.wrims.gui.ide.reporttool;

import gov.ca.dsm2.input.parser.InputTable;
import gov.ca.dsm2.input.parser.Parser;
import gov.ca.dsm2.input.parser.Tables;
import gov.ca.water.wrims.gui.ide.debugger.exception.WPPException;
import hec.heclib.dss.DSSPathname;
import hec.heclib.dss.HecDSSUtilities;
import hec.heclib.dss.HecDss;
import hec.heclib.dss.HecTimeSeries;
import hec.io.TimeSeriesContainer;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Paths;
import java.time.Instant;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.StringJoiner;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.swt.program.Program;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;
import vista.time.SubTimeFormat;
import vista.time.Time;
import vista.time.TimeFactory;
import vista.time.TimeWindow;

/**
 * Generates a report based on the template file instructions.
 *
 * @author psandhu
 */
public final class Report implements IRunnableWithProgress {

    private static final Logger LOG = Logger.getLogger(Report.class.getName());
    private static final String TIME_SERIES = "timeseries";
    private static final String EXCEEDANCE = "exceedance";
    private static final String FILE_ALT = "FILE_ALT";
    private static final String FILE_BASE = "FILE_BASE";
    private static final String NAME_ALT = "NAME_ALT";
    private static final String NAME_BASE = "NAME_BASE";
    private static final String S_SEPT = "S_SEPT";
    private static final String IGNORE = "ignore";

    // 1 cfs sustained for 1 day = 1.9834710743801653 acre-feet.
    private static final double AC_FT_PER_DAY_PER_CFS = 1.9834710743801653;

    private final List<String> messages = new ArrayList<>();
    private final InputStream inputStream;
    private IProgressMonitor monitor;

    private final String outputFilename;
    private List<ArrayList<String>> twValues;
    private List<PathnameMap> pathnameMaps;
    private HashMap<String, String> scalars;
    private Writer writer;

    private Report(InputStream inputStream, String outputFilename) {
        this.inputStream = inputStream;
        this.outputFilename = outputFilename;
    }

    public static void generateReport(InputStream templateContentStream, String outputFilename) {
        IWorkbench workbench = PlatformUI.getWorkbench();
        workbench.getDisplay().asyncExec(() -> {
            Shell shell = workbench.getActiveWorkbenchWindow().getShell();
            ProgressMonitorDialog dialog = new ProgressMonitorDialog(shell);
            Report report = new Report(templateContentStream, outputFilename);

            try {
                dialog.run(true, true, report);
                report.showMessages(shell);
            } catch (InvocationTargetException e) {
                WPPException.handleException(e);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                LOG.log(Level.FINEST, "Report generation canceled.", e);
            }
        });
    }

    @Override
    public void run(IProgressMonitor monitor)
          throws InvocationTargetException, InterruptedException {
        this.monitor = monitor;
        monitor.beginTask("Generate PDF Report", 100);

        try {
            reportStatus("Generating report in background thread.");

            LOG.fine("Parsing input template");
            reportStatus("Parsing input template.");
            parseTemplateFile(inputStream);
            monitor.worked(10);

            reportStatus("Processing DSS files.");
            doProcessing();
            monitor.worked(85);

            reportStatus("Done");
            openOutputFile(outputFilename);
            monitor.worked(5);
        } catch (IOException | RuntimeException e) {
            LOG.log(Level.SEVERE, "Error processing report", e);
            throw new InvocationTargetException(e);
        } finally {
            monitor.done();
            this.monitor = null;
        }
    }

    private void reportStatus(String message) {
        if (monitor != null) {
            monitor.subTask(message);
        }
    }

    private void showMessages(Shell shell) {
        if (messages.isEmpty()) {
            return;
        }

        StringJoiner messageText = new StringJoiner(System.lineSeparator() + System.lineSeparator());
        for (String message : messages) {
            messageText.add(message);
        }

        MessageDialog.openInformation(shell, "Report Generation Messages", messageText.toString());
    }

    private void openOutputFile(String outputFilename) {
        File file = Paths.get(outputFilename).toFile();
        if (file.exists() && !Program.launch(file.getAbsolutePath())) {
            LOG.log(Level.WARNING, "Unable to open file: {0}", outputFilename);
        }
    }

    private void parseTemplateFile(InputStream templateFileStream)
          throws IOException, InterruptedException {

        reportStatus("Parsing template file.");

        Parser p = new Parser();
        Tables tables = p.parseModel(templateFileStream);
        // load scalars into a map
        InputTable scalarTable = tables.getTableNamed("SCALAR");
        ArrayList<ArrayList<String>> scalarValues = scalarTable.getValues();
        int nscalars = scalarValues.size();
        scalars = new HashMap<>();
        for (int i = 0; i < nscalars; i++) {
            ArrayList<String> row = scalarTable.getValues().get(i);
            int index = scalarTable.getHeaders().indexOf("NAME");
            String name = row.get(index);
            var copy = new ArrayList<>(row);
            copy.remove(index);
            String value = String.join(" ", copy);
            scalars.put(name, value.replace("\"", ""));
        }
        checkInterrupt();
        // load pathname mapping into a map
        InputTable pathnameMappingTable = tables.getTableNamed("PATHNAME_MAPPING");
        ArrayList<ArrayList<String>> pmapValues = pathnameMappingTable.getValues();
        int nvalues = pmapValues.size();
        pathnameMaps = new ArrayList<>();
        for (int i = 0; i < nvalues; i++) {
            checkInterrupt();
            String varName = pathnameMappingTable.getValue(i, "VARIABLE");
            varName = varName.replace("\"", "");
            PathnameMap pathMap = new PathnameMap(varName);
            pathMap.reportType = pathnameMappingTable.getValue(i, "REPORT_TYPE").toLowerCase();
            pathMap.pathBase = pathnameMappingTable.getValue(i, "PATH_BASE");
            pathMap.pathAlt = pathnameMappingTable.getValue(i, "PATH_ALT");
            pathMap.varCategory = pathnameMappingTable.getValue(i, "VAR_CATEGORY");
            pathMap.rowType = pathnameMappingTable.getValue(i, "ROW_TYPE");
            if ((pathMap.pathAlt == null) || (pathMap.pathAlt.isEmpty())) {
                pathMap.pathAlt = pathMap.pathBase;
            }
            pathMap.plot = "Y".equalsIgnoreCase(pathnameMappingTable.getValue(i, "PLOT"));
            pathMap.units = pathnameMappingTable.getValue(i, "UNIT");
            pathnameMaps.add(pathMap);
        }
        InputTable timeWindowTable = tables.getTableNamed("TIME_PERIODS");
        twValues = timeWindowTable.getValues();
    }

    private void checkInterrupt() throws InterruptedException {
        if (monitor != null && monitor.isCanceled()) {
            throw new InterruptedException("Report generation canceled.");
        }
    }

    private void doProcessing() throws InterruptedException {
        try {

            // open files 1 and file 2 and loop over to plot
            reportStatus("Processing template file.");

            DssFile dssBase = opendss(scalars.get(FILE_BASE));
            DssFile dssAlt = opendss(scalars.get(FILE_ALT));

            var timeWindows = new ArrayList<TimeWindow>();
            for (ArrayList<String> values : twValues) {
                String v = values.get(1).replace("\"", "");
                timeWindows.add(TimeFactory.getInstance().createTimeWindow(v));
            }
            TimeWindow tw = null;
            if (!timeWindows.isEmpty()) {
                tw = timeWindows.getFirst();
            }
            String outputFile = scalars.get("OUTFILE");
            writer = new ReportPDFWriter();
            boolean wasSuccessful = writer.startDocument(outputFile);
            if (!wasSuccessful) {
                return;
            }
            String author = scalars.get("MODELER").replace("\"", "");
            writer.addTitlePage(String.format("System Water Balance Report: %s vs %s", scalars.get(NAME_ALT),
                  scalars.get(NAME_BASE)), author, scalars.get(FILE_BASE), scalars.get(FILE_ALT));
            writer.setAuthor(author);

            generateSummaryTable();
            int dataIndex = 0;
            generatePlots(dssBase, dssAlt, tw, dataIndex);
            checkInterrupt();
        } finally {
            if (writer != null) {
                writer.endDocument();
            }
        }
        checkInterrupt();
    }

    private void generatePlots(DssFile dssBase, DssFile dssAlt, TimeWindow tw, int dataIndex)
          throws InterruptedException {
        for (PathnameMap pathMap : pathnameMaps) {
            checkInterrupt();
            dataIndex = dataIndex + 1;
            reportStatus("Generating plot " + dataIndex + " of " + pathnameMaps.size() + ".");

            LOG.log(Level.FINE, "Working on index: {0}", dataIndex);
            if (pathMap.pathAlt == null || pathMap.pathAlt.isEmpty()) {
                pathMap.pathAlt = pathMap.pathBase;
            }
            boolean calculateDts = false;
            if ("HEADER".equals(pathMap.varCategory)) {
                LOG.fine("Inserting header");
                continue;
            }

            processPlot(dssBase, dssAlt, tw, pathMap, calculateDts);
        }
    }

    private void processPlot(DssFile dssBase, DssFile dssAlt, TimeWindow tw, PathnameMap pathMap,
          boolean calculateDts) throws InterruptedException {
        try {
            if (pathMap.reportType.endsWith("_post")) {
                calculateDts = true;
            }

            DssSeries refBase = getReference(dssBase, pathMap.pathBase, calculateDts);
            DssSeries refAlt = getReference(dssAlt, pathMap.pathAlt, calculateDts);
            if (refBase != null && refAlt != null) {
                checkInterrupt();

                String[] seriesName = new String[] {scalars.get(NAME_ALT), scalars.get(NAME_BASE)};
                if ("CFS2TAF".equals(pathMap.units)) {
                    refBase = cfs2taf(refBase);
                    refAlt = cfs2taf(refAlt);
                } else if ("TAF2CFS".equals(pathMap.units)) {
                    refBase = taf2cfs(refBase);
                    refAlt = taf2cfs(refAlt);
                }

                String dataUnits = getUnits(refBase, refAlt);
                String dataType = getType(refBase, refAlt);
                if (pathMap.plot) {
                    generatePlotForReportType(tw, pathMap, refBase, refAlt, seriesName, dataUnits, dataType);
                }
            }
        } catch (RuntimeException e) {
            String msg = "Error generating plot for " + pathMap.varName + " using base path "
                  + pathMap.pathBase + " and alt path " + pathMap.pathAlt + ": " + e.getMessage();
            addMessage(msg);
            LOG.log(Level.FINE, msg, e);
        }
    }

    private void generatePlotForReportType(TimeWindow tw, PathnameMap pathMap, DssSeries refBase,
          DssSeries refAlt, String[] seriesName, String dataUnits, String dataType) throws InterruptedException {
        if (pathMap.reportType.startsWith("average")) {
            generatePlot(buildDataArray(refAlt, refBase, tw),
                  "Average " + pathMap.varName.replace("\"", ""), seriesName,
                  dataType + "(" + dataUnits + ")", "Time", TIME_SERIES);
        } else if (pathMap.reportType.startsWith(EXCEEDANCE)) {
            generatePlot(buildExceedanceArray(refAlt, refBase, S_SEPT.equals(pathMap.varCategory), tw),
                  getExceedancePlotTitle(pathMap), seriesName, dataType + "(" + dataUnits + ")",
                  "Percent at or above", EXCEEDANCE);
        } else if (pathMap.reportType.startsWith("avg_excd")) {
            generatePlot(buildDataArray(refAlt, refBase, tw),
                  "Average " + pathMap.varName.replace("\"", ""), seriesName,
                  dataType + "(" + dataUnits + ")", "Time", TIME_SERIES);
            generatePlot(buildExceedanceArray(refAlt, refBase, S_SEPT.equals(pathMap.varCategory), tw),
                  getExceedancePlotTitle(pathMap), seriesName, dataType + "(" + dataUnits + ")",
                  "Percent at or above", EXCEEDANCE);
        } else if (pathMap.reportType.startsWith(TIME_SERIES)) {
            generatePlot(buildDataArray(refAlt, refBase, tw),
                  "Average " + pathMap.varName.replace("\"", ""), seriesName,
                  dataType + "(" + dataUnits + ")", "Time", TIME_SERIES);
        } else if ("alloc".equals(pathMap.reportType)) {
            generatePlot(buildExceedanceArray(refAlt, refBase, true, tw),
                  "Exceedance " + pathMap.varName.replace("\"", ""), seriesName, "Allocation (%)",
                  "Probability", EXCEEDANCE);
        }
    }

    private void generateSummaryTable() throws InterruptedException {

        reportStatus("Generating summary table.");

        writer.setTableFontSize(scalars.get("TABLE_FONT_SIZE"));

        writer.addTableTitle(
              String.format("System Flow Comparision: %s vs %s", scalars.get(NAME_ALT),
                    scalars.get(NAME_BASE)));
        writer.addTableSubTitle(scalars.get("NOTE").replace("\"", ""));
        writer.addTableSubTitle(scalars.get("ASSUMPTIONS").replace("\"", ""));
        writer.addTableSubTitle(" "); // add empty line to increase space
        // between title and table
        DssFile dssBase = opendss(scalars.get(FILE_BASE));
        DssFile dssAlt = opendss(scalars.get(FILE_ALT));
        var timeWindows = new ArrayList<TimeWindow>();
        for (ArrayList<String> values : twValues) {
            String v = values.get(1).replace("\"", "");
            timeWindows.add(TimeFactory.getInstance().createTimeWindow(v));
        }
        var headerRow = new ArrayList<String>();
        headerRow.add("");
        var headerRow2 = new ArrayList<String>();
        headerRow2.add("");

        for (TimeWindow tw : timeWindows) {
            headerRow.add(formatTimeWindowAsWaterYear(tw));
            headerRow2.addAll(Arrays.asList(scalars.get(NAME_ALT), scalars.get(NAME_BASE), "Diff", "% Diff"));
        }
        int[] columnSpans = new int[timeWindows.size() + 1];
        columnSpans[0] = 1;
        for (int i = 1; i < columnSpans.length; i++) {
            columnSpans[i] = 4;
        }
        writer.addTableHeader(headerRow, columnSpans);
        writer.addTableHeader(headerRow2, null);
        List<String> categoryList = Arrays.asList("RF", "DI", "DO", "DE", "SWPSOD", "CVPSOD");
        boolean firstDataRow = true;
        int dataIndex = 0;
        for (PathnameMap pathMap : pathnameMaps) {
            checkInterrupt();
            dataIndex++;
            reportStatus("Processing dataset " + dataIndex + " of " + pathnameMaps.size());

            if (!categoryList.contains(pathMap.varCategory)) {
                continue;
            }
            firstDataRow = processSummaryForPath(dssBase, dssAlt, timeWindows, firstDataRow, pathMap);
        }
        writer.endTable();
    }

    private boolean processSummaryForPath(DssFile dssBase, DssFile dssAlt, ArrayList<TimeWindow> timewindows,
          boolean firstDataRow, PathnameMap pathMap) throws InterruptedException {
        try {
            var rowData = new ArrayList<String>();
            rowData.add(pathMap.varName);
            boolean calculateDts = pathMap.reportType.toLowerCase().endsWith("_post");
            DssSeries refBase = null;
            DssSeries refAlt = null;
            if (!IGNORE.equalsIgnoreCase(pathMap.pathBase)) {
                refBase = getReference(dssBase, pathMap.pathBase, calculateDts);
            }
            if (!IGNORE.equalsIgnoreCase(pathMap.pathAlt)) {
                refAlt = getReference(dssAlt, pathMap.pathAlt, calculateDts);
            }
            for (TimeWindow tw : timewindows) {
                processSummaryTimeWindow(rowData, refBase, refAlt, tw);
            }
            if ("B".equals(pathMap.rowType)) {
                if (!firstDataRow) {
                    var blankRow = new ArrayList<String>();
                    for (int i = 0; i < rowData.size(); i++) {
                        blankRow.add(" ");
                    }
                    writer.addTableRow(blankRow, null, Writer.NORMAL, false);
                }
                writer.addTableRow(rowData, null, Writer.BOLD, false);
            } else {
                writer.addTableRow(rowData, null, Writer.NORMAL, false);
            }
            firstDataRow = false;
        } catch (RuntimeException e) {
            addMessage(e.getMessage());
            LOG.log(Level.FINE, "Error obtaining dataset.", e);
        }
        return firstDataRow;
    }

    private void processSummaryTimeWindow(ArrayList<String> rowData, DssSeries refBase, DssSeries refAlt,
          TimeWindow tw) {
        double avgBase = 0;
        double avgAlt = 0;
        if (refAlt != null) {
            avgAlt = avg(cfs2taf(refAlt), tw);
            rowData.add(formatDoubleValue(avgAlt));
        } else {
            rowData.add("");
        }
        if (refBase != null) {
            avgBase = avg(cfs2taf(refBase), tw);
            rowData.add(formatDoubleValue(avgBase));
        } else {
            rowData.add("");
        }
        if ((refBase == null) || (refAlt == null)) {
            rowData.add("");
            rowData.add("");
        } else {
            double diff = avgAlt - avgBase;
            double pctDiff = Double.NaN;
            if (avgBase != 0) {
                pctDiff = diff / avgBase * 100;
            }
            rowData.add(formatDoubleValue(diff));
            rowData.add(formatDoubleValue(pctDiff));
        }
    }

    private String formatDoubleValue(double val) {
        return Double.isNaN(val) ? "" : String.format("%3d", Math.round(val));
    }

    private void generatePlot(List<double[]> buildDataArray, String title, String[] seriesName,
          String yAxisLabel, String xAxisLabel, String plotType) throws InterruptedException {
        checkInterrupt();
        if (plotType.equals(TIME_SERIES)) {
            writer.addTimeSeriesPlot(buildDataArray, title, seriesName, xAxisLabel, yAxisLabel);
        } else if (plotType.equals(EXCEEDANCE)) {
            writer.addExceedancePlot(buildDataArray, title, seriesName, xAxisLabel, yAxisLabel);
        } else {
            String msg = "Requested unknown plot type: " + plotType + " for title: " + title + " seriesName: "
                  + seriesName[0] + ",..";
            LOG.log(Level.FINE, msg);
            addMessage(msg);
        }
    }

    private ArrayList<double[]> buildDataArray(DssSeries ref1, DssSeries ref2, TimeWindow tw) {
        var dlist = new ArrayList<double[]>();
        if ((ref1 == null) || (ref2 == null)) {
            return dlist;
        }

        DssSeries data1 = slice(ref1, tw);
        DssSeries data2 = slice(ref2, tw);

        int n = Math.min(data1.values.length, data2.values.length);
        for (int i = 0; i < n; i++) {
            if (!isMissing(data1.values[i]) && !isMissing(data2.values[i])) {
                dlist.add(new double[] {data1.times[i], data1.values[i], data2.values[i]});
            }
        }
        return dlist;
    }

    private Date convertToDate(Time timeVal) {
        return new Date(timeVal.getDate().getTime() - TimeZone.getDefault().getRawOffset());
    }

    private List<double[]> buildExceedanceArray(DssSeries ref1, DssSeries ref2, boolean endOfSept,
          TimeWindow tw) {
        ArrayList<Double> x1 = sort(ref1, endOfSept, tw);
        ArrayList<Double> x2 = sort(ref2, endOfSept, tw);
        var darray = new ArrayList<double[]>();
        int i = 0;
        int n = Math.min(x1.size(), x2.size());
        while (i < n) {
            darray.add(new double[] {100.0 - 100.0 * i / (n + 1), x1.get(i), x2.get(i)});
            i = i + 1;
        }
        return darray;
    }

    private ArrayList<Double> sort(DssSeries ref, boolean endOfSept, TimeWindow tw) {
        DssSeries data = slice(ref, tw);
        var dx = new ArrayList<Double>();

        for (int i = 0; i < data.values.length; i++) {
            if (isMissing(data.values[i])) {
                continue;
            }

            if (endOfSept) {
                ZonedDateTime dateTime = ZonedDateTime.ofInstant(
                      Instant.ofEpochMilli(data.times[i]), ZoneId.systemDefault());
                if (dateTime.getMonth().equals(Month.SEPTEMBER) && dateTime.getDayOfMonth() == 30) {
                    dx.add(data.values[i]);
                }
            } else {
                dx.add(data.values[i]);
            }
        }
        Collections.sort(dx);
        return dx;
    }

    private String getTypeOfReference(DssSeries ref) {
        if (ref == null) {
            return "";
        }

        String cPart = getPathPart(ref.pathname, 3);
        if (cPart != null) {
            cPart = cPart.trim();
            if (!cPart.isEmpty() && !"-".equals(cPart)) {
                return cPart;
            }
        }

        return firstNonBlank(ref.parameter, ref.type);
    }

    private String getType(DssSeries ref1, DssSeries ref2) {
        if (ref1 == null) {
            if (ref2 == null) {
                return "";
            } else {
                return getTypeOfReference(ref2);
            }
        } else {
            return getTypeOfReference(ref1);
        }
    }

    /**
     * Opens a DSS file using HEC DSS classes.
     *
     * @return a handle to the DSS file and its catalog
     */
    private DssFile opendss(String filename) {
        try {
            HecDss hecDss = HecDss.open(filename);
            HecDSSUtilities utilities = (HecDSSUtilities) hecDss.getDataManager().dataManager();
            String[] catalog = utilities.getCatalog(true, null);
            return new DssFile(filename, hecDss, catalog);
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception e) {
            throw new IllegalStateException("Unable to open DSS file: " + filename, e);
        }
    }

    private DssSeries cfs2taf(DssSeries data) {
        double[] converted = Arrays.copyOf(data.values, data.values.length);
        ZoneId zone = ZoneId.systemDefault();
        for (int i = 0; i < converted.length; i++) {
            if (!isMissing(converted[i])) {
                int daysInMonth = Instant.ofEpochMilli(data.times[i]).atZone(zone).toLocalDate().lengthOfMonth();
                // cfs * (ac-ft/day per cfs) * days_in_month / 1000 = TAF for the month
                converted[i] = converted[i] * AC_FT_PER_DAY_PER_CFS * daysInMonth / 1000.0;
            }
        }
        return data.withValues(converted, "TAF");
    }

    private DssSeries taf2cfs(DssSeries data) {
        double[] converted = Arrays.copyOf(data.values, data.values.length);
        ZoneId zone = ZoneId.systemDefault();
        for (int i = 0; i < converted.length; i++) {
            if (!isMissing(converted[i])) {
                int daysInMonth = Instant.ofEpochMilli(data.times[i]).atZone(zone).toLocalDate().lengthOfMonth();
                // TAF * 1000 / (ac-ft/day per cfs * days_in_month) = average cfs for the month
                converted[i] = converted[i] * 1000.0 / (AC_FT_PER_DAY_PER_CFS * daysInMonth);
            }
        }
        return data.withValues(converted, "CFS");
    }

    private double avg(DssSeries data, TimeWindow tw) {
        try {
            DssSeries sliced = slice(data, tw);
            double sum = 0;
            int count = 0;

            for (double value : sliced.values) {
                if (!isMissing(value)) {
                    sum += value;
                    count++;
                }
            }

            if (count == 0) {
                return Double.NaN;
            }

            return sum / count * 12;
        } catch (RuntimeException ex) {
            LOG.log(Level.FINE, ex.getMessage(), ex);
            return Double.NaN;
        }
    }

    private DssSeries getReference(DssFile dssFile, String path, boolean calculateDts) throws InterruptedException {
        if (calculateDts) {
            return getDtsReference(dssFile, path);
        } else {
            return getTsReference(dssFile, path);
        }
    }

    private DssSeries getTsReference(DssFile dssFile, String path) {
        try {
            if (IGNORE.equalsIgnoreCase(path)) {
                return null;
            }
            String[] refs = findpath(dssFile, path);
            if (refs.length == 0 || refs[0] == null) {
                String msg = "No data found for " + path;
                addMessage(msg);
                LOG.log(Level.FINE, msg);
                return null;
            }
            var pathname = new DSSPathname(refs[0]);
            pathname.setDPart("");
            return readSeries(dssFile, pathname.getPathname());
        } catch (RuntimeException ex) {
            String msg = "Exception while trying to retrieve " + path + " from " + dssFile.filename;
            LOG.log(Level.FINE, msg, ex);
            addMessage(msg);
            return null;
        }
    }

    private DssSeries getDtsReference(DssFile dssFile, String path) throws InterruptedException {
        try {
            String bpart = path.split("/")[2];
            String[] vars = bpart.split("\\+");
            DssSeries ref = null;

            for (String varname : vars) {
                checkInterrupt();
                String varPath = createPathFromVarname(path, varname);
                DssSeries xref = getReference(dssFile, varPath, false);
                if (xref == null) {
                    throw new IllegalArgumentException(
                          "Aborting calculation of " + path + " due to previous path missing");
                }
                if (ref == null) {
                    ref = xref;
                } else {
                    ref = ref.add(xref);
                }
            }
            return ref;
        } catch (RuntimeException ex) {
            addMessage(ex.getMessage());
            LOG.log(Level.FINE, "Error obtaining dataset.", ex);
            return null;
        }
    }

    /*
     * findpath(file,path): this returns an array of matching DSS pathnames.
     * path is the dss pathname e.g. '//C6/FLOW-CHANNEL////'.
     */
    private String[] findpath(DssFile dssFile, String path) {
        String[] pa = new String[6];
        Arrays.fill(pa, "");

        int i = 0;
        String[] split = path.trim().split("/");
        for (String p : split) {
            if (i != 0) {
                if (i >= pa.length + 1) {
                    break;
                }
                pa[i - 1] = p;
                if (!p.isEmpty()) {
                    pa[i - 1] = "^" + pa[i - 1] + "$";
                }
            }
            i++;
        }

        return Arrays.stream(dssFile.catalog)
              .filter(pathname -> pathnameMatches(pathname, pa))
              .toArray(String[]::new);
    }

    private boolean pathnameMatches(String pathname, String[] partRegexes) {
        for (int i = 0; i < partRegexes.length; i++) {
            String regex = partRegexes[i];
            if (regex == null || regex.isEmpty()) {
                continue;
            }
            Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
            String actual = getPathPart(pathname, i + 1);
            if (!pattern.matcher(actual).matches()) {
                return false;
            }
        }

        return true;
    }

    private DssSeries readSeries(DssFile dssFile, String pathname) {
        try {
            TimeSeriesContainer container = new TimeSeriesContainer();
            container.fullName = pathname;

            HecTimeSeries timeSeries = new HecTimeSeries();
            timeSeries.setDSSFileName(dssFile.filename);
            int status = timeSeries.read(container, true);
            if (status < 0) {
                throw new IllegalStateException("HEC DSS retrieve failed with status " + status);
            }

            int numberValues = container.numberValues;
            long[] times = new long[numberValues];
            double[] values = new double[numberValues];

            for (int i = 0; i < numberValues; i++) {
                times[i] = getTimeMillis(container, i);
                values[i] = container.values[i];
            }

            return new DssSeries(pathname, nullToBlank(container.units), nullToBlank(container.parameter), nullToBlank(container.type), times, values);
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception e) {
            throw new IllegalStateException("Unable to read DSS time series: " + pathname, e);
        }
    }

    private long getTimeMillis(TimeSeriesContainer container, int index) {
        if (container.times != null && index < container.times.length) {
            return hecMinutesToMillis(container.times[index]);
        }

        if (container.julianBaseDate != 0 && container.getTimeIntervalSeconds() != 0) {
            long baseMillis = hecMinutesToMillis(container.julianBaseDate * 1440);
            long intervalMillis = container.getTimeIntervalSeconds() * 1000L;
            return baseMillis + index * intervalMillis;
        }

        throw new IllegalStateException("Unable to determine time for DSS record: " + container.fullName);
    }

    private long hecMinutesToMillis(int hecMinutes) {
        int julianDay = Math.floorDiv(hecMinutes, 1440);
        int minuteOfDay = Math.floorMod(hecMinutes, 1440);

        ZonedDateTime base = ZonedDateTime.of(1899, 12, 31, 0, 0, 0, 0, ZoneId.systemDefault());
        return base.plusDays(julianDay).plusMinutes(minuteOfDay).toInstant().toEpochMilli();
    }

    private DssSeries slice(DssSeries data, TimeWindow tw) {
        if (tw == null) {
            return data;
        }

        long start = convertToDate(tw.getStartTime()).getTime();
        long end = convertToDate(tw.getEndTime()).getTime();

        var times = new ArrayList<Long>();
        var values = new ArrayList<Double>();

        for (int i = 0; i < data.values.length; i++) {
            if (data.times[i] >= start && data.times[i] <= end) {
                times.add(data.times[i]);
                values.add(data.values[i]);
            }
        }

        return new DssSeries(data.pathname, data.units, data.parameter, data.type, toLongArray(times), toDoubleArray(values));
    }

    private String createPathFromVarname(String path, String varname) {
        String[] parts = path.split("/");
        if (parts.length > 2) {
            parts[2] = varname;
        }
        StringBuilder builder = new StringBuilder();
        for (String part : parts) {
            if (!part.isEmpty()) {
                part = "^" + part + "$";
            }
            builder.append(part).append("/");
        }
        return builder.toString();
    }

    private String formatTimeWindowAsWaterYear(TimeWindow tw) {
        SubTimeFormat yearFormat = new SubTimeFormat("yyyy");
        return tw.getStartTime().__add__("3MON").format(yearFormat) + "-"
              + tw.getEndTime().__add__("3MON").format(yearFormat);
    }

    private String getExceedancePlotTitle(PathnameMap pathMap) {
        String title = "Exceedance " + pathMap.varName.replace("\"", "");
        if (S_SEPT.equals(pathMap.varCategory)) {
            title = title + " (Sept)";
        }
        return title;
    }

    private String getUnitsForReference(DssSeries ref) {
        if (ref != null) {
            return ref.units;
        }
        return "";
    }

    private String getUnits(DssSeries ref1, DssSeries ref2) {
        if (ref1 == null) {
            if (ref2 == null) {
                return "";
            } else {
                return getUnitsForReference(ref2);
            }
        } else {
            return getUnitsForReference(ref1);
        }
    }

    private String getPathPart(String pathname, int oneBasedPartNumber) {
        String[] parts = pathname.split("/", -1);
        if (oneBasedPartNumber >= 1 && oneBasedPartNumber < parts.length) {
            return parts[oneBasedPartNumber];
        }
        return "";
    }

    private long[] toLongArray(List<Long> values) {
        long[] array = new long[values.size()];
        for (int i = 0; i < values.size(); i++) {
            array[i] = values.get(i);
        }
        return array;
    }

    private double[] toDoubleArray(List<Double> values) {
        double[] array = new double[values.size()];
        for (int i = 0; i < values.size(); i++) {
            array[i] = values.get(i);
        }
        return array;
    }

    private boolean isMissing(double value) {
        return Double.isNaN(value) || value <= -3.4028234663852886E38;
    }

    private String firstNonBlank(String first, String second) {
        if (first != null && !first.isBlank()) {
            return first;
        }
        return nullToBlank(second);
    }

    private String nullToBlank(String value) {
        return value == null ? "" : value;
    }

    private void addMessage(String msg) {
        if (msg != null && !msg.isBlank()) {
            messages.add(msg);
        }
    }

    /**
     * Externalizes the format for output. This allows the flexibility of
     * defining a writer to output the report to a PDF file vs an HTML file.
     *
     * @author psandhu
     */
    public interface Writer {

        int BOLD = 100;
        int NORMAL = 1;

        boolean startDocument(String outputFile);

        void endDocument();

        void setTableFontSize(String tableFontSize);

        void addTableTitle(String string);

        void addTableHeader(List<String> headerRow, int[] columnSpans);

        void addTableRow(List<String> rowData, int[] columnSpans, int style, boolean centered);

        void endTable();

        void addTimeSeriesPlot(List<double[]> buildDataArray, String title, String[] seriesName, String xAxisLabel,
              String yAxisLabel);

        void addExceedancePlot(List<double[]> buildDataArray, String title, String[] seriesName, String xAxisLabel,
              String yAxisLabel);

        void setAuthor(String author);

        void addTableSubTitle(String string);

        void addTitlePage(String compareInfo, String author, String fileBase, String fileAlt);
    }

    private static final class PathnameMap {
        private final String varName;
        private String reportType;
        private String pathBase;
        private String pathAlt;
        private String rowType;
        private String units;
        private String varCategory;
        private boolean plot;

        private PathnameMap(String varName) {
            this.varName = varName;
        }
    }

    @SuppressWarnings("java:S6218")
    private record DssFile(String filename, HecDss hecDss, String[] catalog) {
    }

    @SuppressWarnings("java:S6218")
    private record DssSeries(String pathname, String units, String parameter, String type, long[] times,
          double[] values) {

        private DssSeries withValues(double[] newValues, String newUnits) {
            return new DssSeries(pathname, newUnits, parameter, type, Arrays.copyOf(times, times.length), newValues);
        }

        private DssSeries add(DssSeries other) {
            int n = Math.min(values.length, other.values.length);
            long[] newTimes = Arrays.copyOf(times, n);
            double[] newValues = new double[n];

            for (int i = 0; i < n; i++) {
                if (Double.isNaN(values[i]) || Double.isNaN(other.values[i])) {
                    newValues[i] = Double.NaN;
                } else {
                    newValues[i] = values[i] + other.values[i];
                }
            }

            return new DssSeries(pathname, units, parameter, type, newTimes, newValues);
        }
    }
}