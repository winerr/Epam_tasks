package lecture5_coffeepoint.product;


import lombok.Getter;
import lombok.Setter;

public class Coffee extends Product {
    @Getter @Setter
    private int volume;

    public Coffee(String name, int price, int volume) {
        super(name, price);
        this.volume = volume;
    }

    @Override
    public String toString() {
        return name + " " + volume + "мл. : " + price/100 + "." + price%100 + " грн.\n";
    }
}
