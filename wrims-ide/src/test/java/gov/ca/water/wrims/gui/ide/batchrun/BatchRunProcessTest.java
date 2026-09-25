package gov.ca.water.wrims.gui.ide.batchrun;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;
import org.junit.jupiter.api.Test;

class BatchRunProcessTest {

    @Test
    void generatedBatchPreservesEngineStatusAcrossTimeout() {
        StringWriter contents = new StringWriter();

        new BatchRunProcess().generateBatch(new PrintWriter(contents), "test.config");

        List<String> lines = contents.toString().lines().toList();
        assertEquals("set \"WRIMS_EXIT=%errorlevel%\"", lines.get(lines.size() - 3));
        assertEquals("timeout 10 > NUL", lines.get(lines.size() - 2));
        assertEquals("exit %WRIMS_EXIT%", lines.get(lines.size() - 1));
    }
}
