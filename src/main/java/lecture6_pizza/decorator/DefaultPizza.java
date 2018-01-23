package lecture6_pizza.decorator;

import java.util.ArrayList;
import java.util.List;

public class DefaultPizza implements Pizza {
    @Override
    public List<String> getDescription() {
        List<String> pizzaDescription = new ArrayList<>();
        pizzaDescription.add("Base");
        pizzaDescription.add("Souce");
        pizzaDescription.add("Cheese");
        return pizzaDescription;
    }

    @Override
    public int getPrice() {
        return 5000;
    }

    @Override
    public void doOperation() {
        System.out.print("Default pizza (Base, souce, cheese) ");
    }
}
