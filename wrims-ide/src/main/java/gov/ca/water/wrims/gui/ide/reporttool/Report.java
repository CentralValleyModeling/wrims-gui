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
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.swt.program.Program;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;
import vista.db.dss.DSSUtil;
import vista.report.TSMath;
import vista.set.Constants;
import vista.set.DataReference;
import vista.set.DataSetElement;
import vista.set.ElementFilterIterator;
import vista.set.Group;
import vista.set.MultiIterator;
import vista.set.Pathname;
import vista.set.RegularTimeSeries;
import vista.set.Stats;
import vista.set.TimeSeries;
import vista.time.SubTimeFormat;
import vista.time.Time;
import vista.time.TimeFactory;
import vista.time.TimeWindow;

/**
 * Generates a report based on the template file instructions
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
    public static final String S_SEPT = "S_SEPT";
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
            ArrayList<String> copy = new ArrayList<>(row);
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
            Group dssGroupBase = opendss(scalars.get(FILE_BASE));
            Group dssGroupAlt = opendss(scalars.get(FILE_ALT));
            ArrayList<TimeWindow> timewindows = new ArrayList<>();
            for (ArrayList<String> values : twValues) {
                String v = values.get(1).replace("\"", "");
                timewindows.add(TimeFactory.getInstance().createTimeWindow(v));
            }
            TimeWindow tw = null;
            if (!timewindows.isEmpty()) {
                tw = timewindows.getFirst();
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
            generatePlots(dssGroupBase, dssGroupAlt, tw, dataIndex);
            checkInterrupt();
        } finally {
            if (writer != null) {
                writer.endDocument();
            }
        }
        checkInterrupt();
    }

    private void generatePlots(Group dssGroupBase, Group dssGroupAlt, TimeWindow tw, int dataIndex)
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
            processPlot(dssGroupBase, dssGroupAlt, tw, pathMap, calculateDts);
        }
    }

    private void processPlot(Group dssGroupBase, Group dssGroupAlt, TimeWindow tw, PathnameMap pathMap,
        boolean calculateDts) throws InterruptedException {
        if (pathMap.reportType.endsWith("_post")) {
            calculateDts = true;
        }
        DataReference refBase = getReference(dssGroupBase, pathMap.pathBase, calculateDts);
        DataReference refAlt = getReference(dssGroupAlt, pathMap.pathAlt, calculateDts);
        if (refBase != null && refAlt != null) {
            checkInterrupt();
            // Switch order from original code to reverse legends ... LimnoTech
            // 20110816
            String[] seriesName = new String[] {scalars.get(NAME_ALT), scalars.get(NAME_BASE)};
            if ("CFS2TAF".equals(pathMap.units)) {
                TSMath.cfs2taf((RegularTimeSeries) refBase.getData());
                TSMath.cfs2taf((RegularTimeSeries) refAlt.getData());
            } else if ("TAF2CFS".equals(pathMap.units)) {
                TSMath.taf2cfs((RegularTimeSeries) refBase.getData());
                TSMath.taf2cfs((RegularTimeSeries) refAlt.getData());
            }
            String dataUnits = getUnits(refBase, refAlt);
            String dataType = getType(refBase, refAlt);
            if (pathMap.plot) {
                generatePlotForReportType(tw, pathMap, refBase, refAlt, seriesName, dataUnits, dataType);
            }
        }
    }

    private void generatePlotForReportType(TimeWindow tw, PathnameMap pathMap, DataReference refBase,
        DataReference refAlt,
        String[] seriesName, String dataUnits, String dataType) throws InterruptedException {
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
        Group dssGroupBase = opendss(scalars.get(FILE_BASE));
        Group dssGroupAlt = opendss(scalars.get(FILE_ALT));
        ArrayList<TimeWindow> timewindows = new ArrayList<>();
        for (ArrayList<String> values : twValues) {
            String v = values.get(1).replace("\"", "");
            timewindows.add(TimeFactory.getInstance().createTimeWindow(v));
        }
        ArrayList<String> headerRow = new ArrayList<>();
        headerRow.add("");
        ArrayList<String> headerRow2 = new ArrayList<>();
        headerRow2.add("");

        for (TimeWindow tw : timewindows) {
            headerRow.add(formatTimeWindowAsWaterYear(tw));
            headerRow2.addAll(Arrays.asList(scalars.get(NAME_ALT), scalars.get(NAME_BASE), "Diff", "% Diff"));
        }
        int[] columnSpans = new int[timewindows.size() + 1];
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
            firstDataRow = processSummaryForPath(dssGroupBase, dssGroupAlt, timewindows, firstDataRow, pathMap);
        }
        writer.endTable();
    }

    private boolean processSummaryForPath(Group dssGroupBase, Group dssGroupAlt, ArrayList<TimeWindow> timewindows,
        boolean firstDataRow, PathnameMap pathMap) throws InterruptedException {
        try {
            ArrayList<String> rowData = new ArrayList<>();
            rowData.add(pathMap.varName);
            boolean calculateDts = pathMap.reportType.toLowerCase().endsWith("_post");
            DataReference refBase = null;
            DataReference refAlt = null;
            if (!"ignore".equalsIgnoreCase(pathMap.pathBase)) {
                refBase = getReference(dssGroupBase, pathMap.pathBase, calculateDts);
            }
            if (!"ignore".equalsIgnoreCase(pathMap.pathAlt)) {
                refAlt = getReference(dssGroupAlt, pathMap.pathAlt, calculateDts);
            }
            for (TimeWindow tw : timewindows) {
                processSummaryTimeWindow(rowData, refBase, refAlt, tw);
            }
            if ("B".equals(pathMap.rowType)) {
                if (!firstDataRow) {
                    ArrayList<String> blankRow = new ArrayList<>();
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

    private void processSummaryTimeWindow(ArrayList<String> rowData, DataReference refBase, DataReference refAlt,
        TimeWindow tw) {
        double avgBase = 0;
        double avgAlt = 0;
        if (refAlt != null) {
            avgAlt = avg(cfs2taf((RegularTimeSeries) refAlt.getData()), tw);
            rowData.add(formatDoubleValue(avgAlt));
        } else {
            rowData.add("");
        }
        if (refBase != null) {
            avgBase = avg(cfs2taf((RegularTimeSeries) refBase.getData()), tw);
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

    private ArrayList<double[]> buildDataArray(DataReference ref1, DataReference ref2, TimeWindow tw) {
        ArrayList<double[]> dlist = new ArrayList<>();
        if ((ref1 == null) || (ref2 == null)) {
            return dlist;
        }
        TimeSeries data1 = (TimeSeries) ref1.getData();
        TimeSeries data2 = (TimeSeries) ref2.getData();
        if (tw != null) {
            data1 = data1.createSlice(tw);
            data2 = data2.createSlice(tw);
        }
        MultiIterator iterator = new MultiIterator(new TimeSeries[] {data1, data2}, Constants.DEFAULT_FLAG_FILTER);
        while (!iterator.atEnd()) {
            DataSetElement e = iterator.getElement();
            Date date = convertToDate(TimeFactory.getInstance().createTime(e.getXString()));
            dlist.add(new double[] {date.getTime(), e.getX(1), e.getX(2)});
            iterator.advance();
        }
        return dlist;
    }

    private Date convertToDate(Time timeVal) {
        return new Date(timeVal.getDate().getTime() - TimeZone.getDefault().getRawOffset());
    }

    private List<double[]> buildExceedanceArray(DataReference ref1, DataReference ref2, boolean endOfSept,
        TimeWindow tw) {
        ArrayList<Double> x1 = sort(ref1, endOfSept, tw);
        ArrayList<Double> x2 = sort(ref2, endOfSept, tw);
        ArrayList<double[]> darray = new ArrayList<>();
        int i = 0;
        int n = Math.min(x1.size(), x2.size());
        while (i < n) {
            darray.add(new double[] {100.0 - 100.0 * i / (n + 1), x1.get(i), x2.get(i)});
            i = i + 1;
        }
        return darray;
    }

    private ArrayList<Double> sort(DataReference ref, boolean endOfSept, TimeWindow tw) {
        TimeSeries data = (TimeSeries) ref.getData();
        if (tw != null) {
            data = data.createSlice(tw);
        }
        ArrayList<Double> dx = new ArrayList<>();
        ElementFilterIterator iter = new ElementFilterIterator(data.getIterator(), Constants.DEFAULT_FLAG_FILTER);
        while (!iter.atEnd()) {
            if (endOfSept) {
                if (iter.getElement().getXString().contains("30SEP")) {
                    dx.add(iter.getElement().getY());
                }
            } else {
                dx.add(iter.getElement().getY());
            }
            iter.advance();
        }
        Collections.sort(dx);
        return dx;
    }

    private String getTypeOfReference(DataReference ref) {
        if (ref != null) {
            Pathname p = ref.getPathname();
            return p.getPart(Pathname.C_PART);
        }
        return "";
    }

    private String getType(DataReference ref1, DataReference ref2) {
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
     * Retrieves the contents list for a dss file
     *
     * @return a handle to the content listing for a dss file
     */
    private Group opendss(String filename) {
        return DSSUtil.createGroup("local", filename);
    }

    private RegularTimeSeries cfs2taf(RegularTimeSeries data) {
        RegularTimeSeries dataTaf = (RegularTimeSeries) TSMath.createCopy(data);
        TSMath.cfs2taf(dataTaf);
        return dataTaf;
    }

    private double avg(RegularTimeSeries data, TimeWindow tw) {
        try {
            return Stats.avg(data.createSlice(tw)) * 12;
        } catch (RuntimeException ex) {
            LOG.log(Level.FINE, ex.getMessage(), ex);
            return Double.NaN;
        }
    }

    private DataReference getReference(Group group, String path, boolean calculateDts) throws InterruptedException {
        if (calculateDts) {
            return getDtsReference(group, path);
        } else {
            return getTsReference(group, path);
        }
    }

    private DataReference getTsReference(Group group, String path) {
        try {
            DataReference[] refs = findpath(group, path);
            if (refs == null || refs.length == 0 || refs[0] == null) {
                String msg = "No data found for " + path;
                addMessage(msg);
                LOG.log(Level.FINE, msg);
                return null;
            } else {
                DataReference firstRef = refs[0];
                DataReference retval = firstRef;
                if (refs.length > 1) {
                    DataReference lastRef = refs[refs.length - 1];
                    String serverName = firstRef.getServername();
                    String fileName = firstRef.getFilename();
                    String firstDPart = firstRef.getPathname().getPart(Pathname.D_PART);
                    if (firstDPart.contains("-")) {
                        firstDPart = firstDPart.split("-")[0];
                    }
                    String lastDPart = lastRef.getPathname().getPart(Pathname.D_PART);
                    if (lastDPart.contains("-")) {
                        String[] split = lastDPart.split("-");
                        lastDPart = split[split.length - 1];
                    }
                    String newDPart = firstDPart;
                    if (!Objects.equals(firstDPart, lastDPart)) {
                        newDPart = firstDPart + " - " + lastDPart;
                    }
                    Pathname pathname = Pathname.createPathname(new String[]
                        {
                            firstRef.getPathname().getPart(Pathname.A_PART),
                            firstRef.getPathname().getPart(Pathname.B_PART),
                            firstRef.getPathname().getPart(Pathname.C_PART),
                            newDPart,
                            firstRef.getPathname().getPart(Pathname.E_PART),
                            firstRef.getPathname().getPart(Pathname.F_PART),
                        });
                    retval = DSSUtil.createDataReference(serverName, fileName, pathname);
                }
                return retval;
            }
        } catch (RuntimeException ex) {
            String msg = "Exception while trying to retrieve " + path + " from " + group;
            LOG.log(Level.FINE, msg, ex);
            addMessage(msg);
            return null;
        }
    }

    private DataReference getDtsReference(Group group, String path) throws InterruptedException {
        try {
            String bpart = path.split("/")[2];
            String[] vars = bpart.split("\\+");
            DataReference ref = null;
            for (String varname : vars) {
                checkInterrupt();
                String varPath = createPathFromVarname(path, varname);
                DataReference xref = getReference(group, varPath, false);
                if (xref == null) {
                    throw new IllegalArgumentException(
                        "Aborting calculation of " + path + " due to previous path missing");
                }
                if (ref == null) {
                    ref = xref;
                } else {
                    ref = ref.__add__(xref);
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
     * findpath(g,path,exact=1): this returns an array of matching data
     * references g is the group returned from opendss function path is the
     * dsspathname e.g. '//C6/FLOW-CHANNEL////' exact means that the exact
     * string is matched as opposed to the reg. exp.
     */
    private DataReference[] findpath(Group g, String path) {
        String[] pa = new String[6];
        for (int i = 0; i < 6; i++) {
            pa[i] = "";
        }
        int i = 0;
        String[] split = path.trim().split("/");
        for (String p : split) {
            if (i != 0) {
                if (i >= pa.length) {
                    break;
                }
                pa[i - 1] = p;
                if (!p.isEmpty()) {
                    pa[i - 1] = "^" + pa[i - 1] + "$";
                }
            }
            i++;
        }
        return g.find(pa);
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

    private String getUnitsForReference(DataReference ref) {
        if (ref != null) {
            return ref.getData().getAttributes().getYUnits();
        }
        return "";
    }

    private String getUnits(DataReference ref1, DataReference ref2) {
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
}
