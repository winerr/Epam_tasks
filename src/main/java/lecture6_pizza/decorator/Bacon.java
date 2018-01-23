package lecture6_pizza.decorator;

import java.util.List;

public class Bacon extends PizzaDecorator{
    public Bacon(Pizza pizza) {
        super(pizza);
    }

    @Override
    public List<String> getDescription() {
        List<String> pizzaDescription = pizza.getDescription();
        pizzaDescription.add("Bacon");
        return pizzaDescription;
    }

    @Override
    public int getPrice() {
        return pizza.getPrice()+800;
    }

    @Override
    public void doOperation() {
        super.doOperation();
        System.out.print("with bacon ");
    }
}
