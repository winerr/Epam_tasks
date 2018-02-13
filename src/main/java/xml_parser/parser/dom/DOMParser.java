package xml_parser.parser.dom;

import org.w3c.dom.Document;
import xml_parser.model.Device;

import java.io.File;
import java.util.List;

public class DOMParser {
    public static List<Device> parse(File xml){
        DOMDocCreator domDocCreator = new DOMDocCreator(xml);
        Document document = domDocCreator.getDocument();
        DOMDocReader domDocReader = new DOMDocReader();
        return domDocReader.read(document);
    }
}
