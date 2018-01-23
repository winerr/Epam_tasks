package lecture6_pizza.decorator;

import java.util.List;

public class Cheese extends PizzaDecorator {
    public Cheese(Pizza pizza) {
        super(pizza);
    }

    @Override
    public void doOperation() {
        super.doOperation();
        System.out.print("with cheese ");
    }


    @Override
    public List<String> getDescription() {
        List<String> pizzaDescription = pizza.getDescription();
        pizzaDescription.add("Cheese");
        return pizzaDescription;
    }

    @Override
    public int getPrice() {
        return pizza.getPrice() + 750;
    }



}
