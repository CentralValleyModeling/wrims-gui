/*
 * Water Resource Integrated Modeling System (WRIMS) Copyright (c) 2026.
 *
 * WRIMS 3 is copyrighted by the State of California Department of Water Resources.
 * It is licensed under the Eclipse Public License, Version 1.0.
 * See Eclipse Public License for more details.
 */

package gov.ca.water.hecdssvue.dts;

import java.io.FileWriter;
import java.io.IOException;
import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.traversal.TreeWalker;

public class XmlUtilities {

    /**
     * Creates an XML document builder with external entity and DTD access disabled.
     *
     * @return a securely configured document builder
     * @throws ParserConfigurationException if the secure parser configuration is unsupported
     */
    public static DocumentBuilder newDocumentBuilder() throws ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
        factory.setFeature("http://xml.org/sax/features/external-general-entities", false);
        factory.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
        factory.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
        factory.setAttribute(XMLConstants.ACCESS_EXTERNAL_DTD, "");
        factory.setAttribute(XMLConstants.ACCESS_EXTERNAL_SCHEMA, "");
        factory.setXIncludeAware(false);
        factory.setExpandEntityReferences(false);
        return factory.newDocumentBuilder();
    }

    public static Document newDocument() throws IOException {
        try {
            return newDocumentBuilder().newDocument();
        } catch (ParserConfigurationException ex) {
            throw new IOException(ex);
        }

    }


    public static Element getNextElement(TreeWalker treeWalker, String nodeName) {
        for (Node nextNode = treeWalker.nextNode(); nextNode != null; nextNode = treeWalker.nextNode()) {
            if (nextNode.getNodeType() == Node.ELEMENT_NODE &&
                (nodeName == null || nodeName.equals(nextNode.getNodeName()))) {
                return (Element) nextNode;
            }
        }
        return null;
    }

    /**
     * @param document
     * @param filename
     * @throws Exception
     */
    public static void saveTo(Node document, String filename) throws IOException {
        try (FileWriter writer = new FileWriter(filename)) {
            TransformerFactory tFactory = TransformerFactory.newInstance();
            Transformer transformer = tFactory.newTransformer();

            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(writer);
            transformer.setOutputProperty(
                "{http://xml.apache.org/xslt}indent-amount", "4");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-16");
            transformer.transform(source, result);
        } catch (TransformerException e) {
            throw new IOException(e);
        }
    }
}
