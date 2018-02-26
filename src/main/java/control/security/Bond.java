package control.security;

import control.Risk;
import control.Trend;
import lombok.Getter;
import lombok.Setter;

public class Bond implements Security{
    @Getter @Setter
    private int code;
    @Getter @Setter
    private String name;
    private int price;
    private Risk risk;
    private Trend trend;

    public Bond(int code, String name, int price, Risk risk, Trend trend) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.risk = risk;
        this.trend = trend;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public Risk getRisk() {
        return risk;
    }

    @Override
    public Trend getTrend() {
        return trend;
    }

    @Override
    public int compareTo(Security security) {
        return this.risk.compareTo(security.getRisk());
    }

    @Override
    public String toString() {
        return "Bond{" +
                "code=" + code +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", risk=" + risk +
                ", trend=" + trend +
                '}';
    }
}
