package xml_parser.parser.stax;

import xml_parser.model.Device;
import xml_parser.model.DeviceType;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class StAXParser {
    public static List<Device> parse(File xml){
        List<Device> devices = new ArrayList<>();
        Device device = null;
        DeviceType deviceType = null;
        List<String> ports = null;

        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();

        try {
            XMLEventReader xmlEventReader = xmlInputFactory.createXMLEventReader(new FileInputStream(xml));

            while (xmlEventReader.hasNext()){
                XMLEvent xmlEvent = xmlEventReader.nextEvent();

                if (xmlEvent.isStartElement()){
                    StartElement startElement = xmlEvent.asStartElement();
                    String element = startElement.getName().getLocalPart();
                    if (element.equalsIgnoreCase("device")) {
                        device = new Device();
                    }else if(element.equalsIgnoreCase("name")){
                        xmlEvent = xmlEventReader.nextEvent();
                        assert device != null;
                        device.setName(xmlEvent.asCharacters().getData());
                    }else if (element.equalsIgnoreCase("origin")){
                        xmlEvent = xmlEventReader.nextEvent();
                        assert device != null;
                        device.setOrigin(xmlEvent.asCharacters().getData());
                    }else if (element.equalsIgnoreCase("price")){
                        xmlEvent = xmlEventReader.nextEvent();
                        assert device != null;
                        device.setPrice(Integer.parseInt(xmlEvent.asCharacters().getData()));
                    }else if (element.equalsIgnoreCase("type")){
                        xmlEvent = xmlEventReader.nextEvent();
                        deviceType = new DeviceType();
                    }else if (element.equalsIgnoreCase("peripheral")){
                        xmlEvent = xmlEventReader.nextEvent();
                        assert deviceType != null;
                        deviceType.setPeripheral(Boolean.parseBoolean(xmlEvent.asCharacters().getData()));
                    }else if (element.equalsIgnoreCase("energyConsumption")){
                        xmlEvent = xmlEventReader.nextEvent();
                        assert deviceType != null;
                        deviceType.setEnergyConsumption(Integer.parseInt(xmlEvent.asCharacters().getData()));
                    }else if (element.equalsIgnoreCase("cooler")){
                        xmlEvent = xmlEventReader.nextEvent();
                        assert deviceType != null;
                        deviceType.setCooler(Boolean.parseBoolean(xmlEvent.asCharacters().getData()));
                    }else if (element.equalsIgnoreCase("ports")){
                        xmlEvent = xmlEventReader.nextEvent();
                        ports = new ArrayList<>();
                    }else if (element.equalsIgnoreCase("port")){
                        xmlEvent = xmlEventReader.nextEvent();
                        assert ports != null;
                        ports.add(xmlEvent.asCharacters().getData());
                    }else if (element.equalsIgnoreCase("critical")){
                        xmlEvent = xmlEventReader.nextEvent();
                        assert device != null;
                        device.setCritical(Boolean.parseBoolean(xmlEvent.asCharacters().getData()));
                        assert deviceType != null;
                        deviceType.setPorts(ports);
                        device.setDeviceType(deviceType);
                    }
                }

                if (xmlEvent.isEndElement()){
                    EndElement endElement = xmlEvent.asEndElement();
                    if (endElement.getName().getLocalPart().equalsIgnoreCase("device")){
                        devices.add(device);
                    }
                }

            }

        } catch (XMLStreamException | FileNotFoundException e) {
            e.printStackTrace();
        }

        return devices;
    }
}
