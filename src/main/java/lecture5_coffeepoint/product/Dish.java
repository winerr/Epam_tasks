package lecture5_coffeepoint.product;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

public class Dish extends Product {
    @Getter @Setter
    private DishType type;

    public Dish(String name, int price, DishType type) {
        super(name, price);
        this.type = type;
    }

    @Override
    public String toString() {
        return name + " : " + price/100 + "." + price%100 + " грн.\n";
    }
}
