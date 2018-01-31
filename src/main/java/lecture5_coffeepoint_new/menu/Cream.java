package lecture5_coffeepoint_new.menu;

import java.util.List;

public class Cream extends CoffeeDecorator {
    public Cream(Coffee coffee) {
        super(coffee);
    }

    @Override
    public List<String> getDescription() {
        List<String> description = coffee.getDescription();
        description.add("Cream");
        return description;
    }
    @Override
    public int getPrice() {
        return coffee.getPrice()+700;
    }
    @Override
    public void showDescription() {
        super.showDescription();
        System.out.print("with cream ");
    }
}
