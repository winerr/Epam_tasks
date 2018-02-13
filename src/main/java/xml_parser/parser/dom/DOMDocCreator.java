package xml_parser.parser.dom;

import lombok.Getter;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class DOMDocCreator {
    private DocumentBuilderFactory documentBuilderFactory;
    private DocumentBuilder documentBuilder;
    @Getter
    private Document document;

    public DOMDocCreator(File xml){
        createDOMBuilder();
        createDocument(xml);
    }

    private void createDOMBuilder(){
        documentBuilderFactory = DocumentBuilderFactory.newInstance();
        try {
            documentBuilder = documentBuilderFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }

    private void createDocument(File xml){
        try {
            document = documentBuilder.parse(xml);
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}
