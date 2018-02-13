package xml_parser;

import xml_parser.parser.dom.DOMParser;
import xml_parser.parser.sax.SAXParser;
import xml_parser.parser.stax.StAXParser;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        File xml = new File("src/main/resources/xml/computer.xml");
//        SAXParser.parse(xml).forEach(System.out::println);
//        DOMParser.parse(xml).forEach(System.out::println);
        StAXParser.parse(xml).forEach(System.out::println);
    }
}
