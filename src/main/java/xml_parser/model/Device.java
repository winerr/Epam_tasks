package xml_parser.model;

import lombok.Getter;
import lombok.Setter;

public class Device {
    @Getter @Setter
    private String name;
    @Getter @Setter
    private String origin;
    @Getter @Setter
    private int price;
    @Getter @Setter
    private DeviceType deviceType;
    @Getter @Setter
    private boolean critical;

    @Override
    public String toString() {
        return "Device{" +
                "name='" + name + '\'' +
                ", origin='" + origin + '\'' +
                ", price=" + price +
                ", deviceType=" + deviceType +
                ", critical=" + critical +
                '}';
    }
}
