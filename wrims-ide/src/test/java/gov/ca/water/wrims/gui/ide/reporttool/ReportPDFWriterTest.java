/*
 * Copyright (c) 2026
 * United States Army Corps of Engineers - Hydrologic Engineering Center (USACE/HEC)
 * All Rights Reserved.  USACE PROPRIETARY/CONFIDENTIAL.
 * Source may not be released without written approval from HEC
 */

package gov.ca.water.wrims.gui.ide.reporttool;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

final class ReportPDFWriterTest {

    @Test
    void writesPdfWithSummaryTable() throws Exception {
        Path pdf = Files.createTempFile("ReportPDFWriterTest-", ".pdf");

        ReportPDFWriter writer = new ReportPDFWriter();
        writer.startDocument(pdf.toString());
        writer.addTitlePage("Test Title", "Test Author", "Test Base", "Test Alt");
        writer.addNewPage();
        writer.writeParagraph("This is a test paragraph.");
        writer.setTableFontSize("9");

        writer.addTableTitle("My Summary Table");
        writer.addTableSubTitle("Sub-title goes here");

        ArrayList<String> header = new ArrayList<>(
            List.of("Name", "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec")
        );
        int[] spans = new int[header.size()];
        Arrays.fill(spans, 1);

        writer.addTableHeader(header, spans);

        ArrayList<String> row1 = new ArrayList<>(
            List.of("Scenario A", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12")
        );
        writer.addTableRow(row1, spans, ReportPDFWriter.NORMAL, false);

        ArrayList<String> row2 = new ArrayList<>(
            List.of("Scenario B", "10", "20", "30", "40", "50", "60", "70", "80", "90", "100", "110", "120")
        );
        writer.addTableRow(row2, spans, ReportPDFWriter.BOLD, false);

        assertDoesNotThrow(writer::endTable);
        assertDoesNotThrow(writer::endDocument);

        assertTrue(Files.exists(pdf), "Expected the PDF file to be created");
        assertTrue(Files.size(pdf) > 0, "Expected the PDF file to be non-empty");
    }

    @Test
    void writesPdfWithExceedancePlot() throws Exception {
        Path pdf = Files.createTempFile("ReportPDFWriterTest-exceedance-", ".pdf");

        ReportPDFWriter writer = new ReportPDFWriter();

        assertDoesNotThrow(() -> writer.startDocument(pdf.toString()));
        assertDoesNotThrow(() -> writer.setTableFontSize("9"));

        ArrayList<double[]> buildDataArray = new ArrayList<>();
        buildDataArray.add(new double[] {0.0, 100.0, 90.0});
        buildDataArray.add(new double[] {50.0, 60.0, 55.0});
        buildDataArray.add(new double[] {100.0, 10.0, 5.0});

        String[] seriesName = {"Alt 1", "Alt 2"};

        assertDoesNotThrow(() -> writer.addExceedancePlot(
            buildDataArray,
            "Exceedance Plot - Unit Test",
            seriesName,
            "Percent Exceedance",
            "Value"
        ));


        ArrayList tsArray = new ArrayList<>();
        tsArray.add(new double[] {1.0, 100.0, 90.0});
        tsArray.add(new double[] {2.0, 110.0, 95.0});
        tsArray.add(new double[] {3.0, 120.0, 100.0});
        tsArray.add(new double[] {4.0, 130.0, 105.0});

        String[] tsSeriesName = {"Series 1", "Series 2"};

        assertDoesNotThrow(() -> writer.addTimeSeriesPlot(
            tsArray,
            "Time Series Plot - Unit Test",
            tsSeriesName,
            "Time Period",
            "Value"
        ));

        assertDoesNotThrow(writer::endDocument);

        assertTrue(Files.exists(pdf), "Expected the PDF file to be created");
        assertTrue(Files.size(pdf) > 0, "Expected the PDF file to be non-empty");
    }

    @Test
    void setTableFontSize_withNonNumericInput_doesNotThrow() {
        ReportPDFWriter writer = new ReportPDFWriter("test.pdf");
        assertDoesNotThrow(() -> writer.setTableFontSize("not-a-number"));
    }
}
