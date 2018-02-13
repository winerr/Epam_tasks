package xml_parser.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class DeviceType {
    @Getter @Setter
    private boolean peripheral;
    @Getter @Setter
    private int energyConsumption;
    @Getter @Setter
    private boolean cooler;
    @Getter @Setter
    private List<String> ports;

    @Override
    public String toString() {
        return "DeviceType{" +
                "peripheral=" + peripheral +
                ", energyConsumption=" + energyConsumption +
                ", cooler=" + cooler +
                ", ports=" + ports +
                '}';
    }
}
