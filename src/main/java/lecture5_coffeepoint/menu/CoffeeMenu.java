package lecture5_coffeepoint.menu;

import lecture5_coffeepoint.product.Coffee;

import java.util.ArrayList;
import java.util.List;

public final class CoffeeMenu {
    public static List<Coffee> coffeeMenu;

    static {
        coffeeMenu = new ArrayList<>();
        coffeeMenu.add(new Coffee("Late", 4000, 330));
        coffeeMenu.add(new Coffee("Late", 5200, 470));
        coffeeMenu.add(new Coffee("Espresso", 3200, 60));
        coffeeMenu.add(new Coffee("Ristretto", 3500, 30));
    }

}
