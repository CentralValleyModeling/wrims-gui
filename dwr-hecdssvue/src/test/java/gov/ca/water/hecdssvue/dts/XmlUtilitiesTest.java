package gov.ca.water.hecdssvue.dts;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.StringReader;
import javax.xml.parsers.DocumentBuilder;
import org.junit.jupiter.api.Test;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

class XmlUtilitiesTest {

    @Test
    void newDocumentBuilderRejectsExternalEntities() throws Exception {
        DocumentBuilder builder = XmlUtilities.newDocumentBuilder();
        String xml = "<!DOCTYPE root [<!ENTITY external SYSTEM \"http://example.com/external.txt\">]>"
            + "<root>&external;</root>";

        assertThrows(SAXException.class, () -> builder.parse(new InputSource(new StringReader(xml))));
    }
}
