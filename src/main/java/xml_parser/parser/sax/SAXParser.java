package xml_parser.parser.sax;

import org.xml.sax.SAXException;
import xml_parser.model.Device;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SAXParser {
    private static final SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();


    public static List<Device> parse(File xml){
        List<Device> devices = new ArrayList<>();
        try {
            javax.xml.parsers.SAXParser saxParser = saxParserFactory.newSAXParser();
            SAXHandler saxHandler = new SAXHandler();
            saxParser.parse(xml, saxHandler);

            devices = saxHandler.getDevices();
        }
        catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }

        return devices;
    }
}
