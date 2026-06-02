/*
 * MIT License
 *
 * Copyright (c) 2026, California Department of Water Resources
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package gov.ca.water.wrims.gui.ide.reporttool;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
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
        tsArray.add(new double[] {1704067200000.0, 100.0, 90.0});
        tsArray.add(new double[] {1706745600000.0, 110.0, 95.0});
        tsArray.add(new double[] {1709251200000.0, 120.0, 100.0});
        tsArray.add(new double[] {1711929600000.0, 130.0, 105.0});

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
    void setTableFontSize_withNonNumericInput_doesNotThrow() throws IOException {
        String testFile = Files.createTempFile("setTableFontSize_withNonNumericInput_doesNotThrow", ".pdf").toString();
        ReportPDFWriter writer = new ReportPDFWriter(testFile);
        assertDoesNotThrow(() -> writer.setTableFontSize("not-a-number"));
    }
}
