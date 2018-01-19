package lecture5_coffeepoint.menu;

import lecture5_coffeepoint.product.Dish;
import lecture5_coffeepoint.product.DishType;

import java.util.ArrayList;
import java.util.List;

public final class SnackMenu {
    public static List<Dish> snackMenu;

    static {
        snackMenu = new ArrayList<>();
        snackMenu.add(new Dish("Hot-Dog", 2300, DishType.SNACK));
        snackMenu.add(new Dish("Sandwich", 2800, DishType.SNACK));
    }

}
