package lecture5_coffeepoint_new.menu;

import java.util.ArrayList;
import java.util.List;

public class DefaultCoffee implements Coffee {
    @Override
    public List<String> getDescription() {
        List<String> description = new ArrayList<>();
        description.add("Coffee");
        return description;
    }

    @Override
    public int getPrice() {
        return 2000;
    }

    @Override
    public void showDescription() {
        System.out.print("Coffee ");
    }
}
