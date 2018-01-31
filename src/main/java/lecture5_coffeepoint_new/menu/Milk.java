package lecture5_coffeepoint_new.menu;


import java.util.List;

public class Milk extends CoffeeDecorator {
    public Milk(Coffee coffee) {
        super(coffee);
    }

    @Override
    public List<String> getDescription() {
        List<String> description = coffee.getDescription();
        description.add("Milk");
        return description;
    }
    @Override
    public int getPrice() {
        return coffee.getPrice()+500;
    }
    @Override
    public void showDescription() {
        super.showDescription();
        System.out.print("with milk ");
    }
}
