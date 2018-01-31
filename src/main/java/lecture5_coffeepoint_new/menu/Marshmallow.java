package lecture5_coffeepoint_new.menu;


import java.util.List;

public class Marshmallow extends CoffeeDecorator {
    public Marshmallow(Coffee coffee) {
        super(coffee);
    }

    @Override
    public List<String> getDescription() {
        List<String> description = coffee.getDescription();
        description.add("Marshmallow");
        return description;
    }
    @Override
    public int getPrice() {
        return coffee.getPrice()+1200;
    }
    @Override
    public void showDescription() {
        super.showDescription();
        System.out.print("with marshmallow ");
    }
}
