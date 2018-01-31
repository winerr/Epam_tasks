package lecture5_coffeepoint_new.menu;

import java.util.List;

public class Cinnamon extends CoffeeDecorator {
    public Cinnamon(Coffee coffee) {
        super(coffee);
    }

    @Override
    public List<String> getDescription() {
        List<String> description = coffee.getDescription();
        description.add("Cinnamon");
        return description;
    }
    @Override
    public int getPrice() {
        return coffee.getPrice()+1000;
    }
    @Override
    public void showDescription() {
        super.showDescription();
        System.out.print("with cinnamon ");
    }
}
