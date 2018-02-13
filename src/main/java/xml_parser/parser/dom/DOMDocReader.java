package xml_parser.parser.dom;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import xml_parser.model.Device;
import xml_parser.model.DeviceType;

import java.util.ArrayList;
import java.util.List;

public class DOMDocReader {
    public List<Device> read(Document document){
        List<Device> devices = new ArrayList<>();
        document.getDocumentElement().normalize();

        NodeList nodeList = document.getElementsByTagName("device");

        for (int i=0; i<nodeList.getLength(); i++){
            Device device = new Device();
            DeviceType deviceType;

            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE){
                Element element = (Element) node;

                device.setName(element.getElementsByTagName("name").item(0).getTextContent());
                device.setOrigin(element.getElementsByTagName("origin").item(0).getTextContent());
                device.setPrice(Integer.parseInt(element.getElementsByTagName("price").item(0).getTextContent()));
                device.setCritical(Boolean.parseBoolean(element.getElementsByTagName("critical").item(0).getTextContent()));

                deviceType = getDeviceType(element.getElementsByTagName("type"));

                device.setDeviceType(deviceType);

                devices.add(device);
            }

        }

        return devices;
    }

    private DeviceType getDeviceType(NodeList nodeList){
        DeviceType deviceType = new DeviceType();
        if (nodeList.item(0).getNodeType() == Node.ELEMENT_NODE){
            Element element = (Element) nodeList.item(0);

            deviceType.setPeripheral(Boolean.parseBoolean(element.getElementsByTagName("peripheral").item(0).getTextContent()));
            deviceType.setEnergyConsumption(Integer.parseInt(element.getElementsByTagName("energyConsumption").item(0).getTextContent()));
            deviceType.setCooler(Boolean.parseBoolean(element.getElementsByTagName("cooler").item(0).getTextContent()));
            deviceType.setPorts(getPorts(element.getElementsByTagName("ports")));

        }
        return deviceType;
    }

    private List<String> getPorts(NodeList nodeList){
        List<String> ports = new ArrayList<>();
        if (nodeList.item(0).getNodeType() == Node.ELEMENT_NODE){
            Element element = (Element) nodeList.item(0);
            NodeList nodes = element.getChildNodes();
            for (int i=0; i<nodes.getLength(); i++){
                Node node = nodes.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE){
                    Element el = (Element) node;
                    ports.add(el.getTextContent());
                }
            }
        }
        return ports;
    }
}
