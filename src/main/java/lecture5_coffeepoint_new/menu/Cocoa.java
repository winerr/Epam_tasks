package lecture5_coffeepoint_new.menu;

import java.util.List;

public class Cocoa extends CoffeeDecorator{
    public Cocoa(Coffee coffee) {
        super(coffee);
    }

    @Override
    public List<String> getDescription() {
        List<String> description = coffee.getDescription();
        description.add("Cocoa");
        return description;
    }
    @Override
    public int getPrice() {
        return coffee.getPrice()+800;
    }
    @Override
    public void showDescription() {
        super.showDescription();
        System.out.print("with cocoa ");
    }
}
