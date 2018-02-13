package xml_parser.parser.sax;

import lombok.Getter;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import xml_parser.model.Device;
import xml_parser.model.DeviceType;

import java.util.ArrayList;
import java.util.List;

public class SAXHandler extends DefaultHandler {
    @Getter
    private List<Device> devices = new ArrayList<>();
    private Device device = null;
    private DeviceType deviceType = null;
    private List<String> ports;

    private boolean dName = false;
    private boolean dOrigin = false;
    private boolean dPrice = false;
    private boolean dDeviceType = false;
    private boolean dPeripheral = false;
    private boolean dEnergyConsumption = false;
    private boolean dCooler = false;
    private boolean dPorts = false;
    private boolean dPort = false;
    private boolean dCritical = false;

    public SAXHandler(){
        super();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if(qName.equalsIgnoreCase("device")){
            device = new Device();
        }else if (qName.equalsIgnoreCase("name")){
            dName = true;
        }else if (qName.equalsIgnoreCase("origin")){
            dOrigin = true;
        }else if (qName.equalsIgnoreCase("price")){
            dPrice = true;
        }else if (qName.equalsIgnoreCase("type")){
            dDeviceType = true;
        }else if (qName.equalsIgnoreCase("peripheral")){
            dPeripheral = true;
        }else if (qName.equalsIgnoreCase("energyConsumption")){
            dEnergyConsumption = true;
        }else if (qName.equalsIgnoreCase("cooler")){
            dCooler = true;
        }else if (qName.equalsIgnoreCase("ports")){
            dPorts = true;
        }else if (qName.equalsIgnoreCase("port")){
            dPort = true;
        }else if (qName.equalsIgnoreCase("critical")){
            dCritical = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("device")){
            devices.add(device);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (dName){
            device.setName(new String(ch, start, length));
            dName = false;
        }else if (dOrigin){
            device.setOrigin(new String(ch, start, length));
            dOrigin = false;
        }else if (dPrice){
            device.setPrice(Integer.parseInt(new String(ch, start, length)));
            dPrice = false;
        }else if (dDeviceType){
            deviceType = new DeviceType();
            dDeviceType = false;
        }else if (dPeripheral){
            deviceType.setPeripheral(Boolean.parseBoolean(new String(ch, start, length)));
            dPeripheral = false;
        }else if (dEnergyConsumption){
            deviceType.setEnergyConsumption(Integer.parseInt(new String(ch, start, length)));
            dEnergyConsumption = false;
        }else if (dCooler){
            deviceType.setCooler(Boolean.parseBoolean(new String(ch, start, length)));
            dCooler = false;
        }else if (dPorts){
            ports = new ArrayList<>();
            dPorts = false;
        }else if (dPort){
            ports.add(new String(ch, start, length));
            dPort = false;
        }else if (dCritical){
            device.setCritical(Boolean.parseBoolean(new String(ch, start, length)));
            dCritical = false;
            deviceType.setPorts(ports);
            device.setDeviceType(deviceType);
        }
    }
}














