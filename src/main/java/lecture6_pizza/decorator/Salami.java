package lecture6_pizza.decorator;

import java.util.List;

public class Salami extends PizzaDecorator {
    public Salami(Pizza pizza) {
        super(pizza);
    }

    @Override
    public List<String> getDescription() {
        List<String> pizzaDescription = pizza.getDescription();
        pizzaDescription.add("Salami");
        return pizzaDescription;
    }

    @Override
    public int getPrice() {
        return pizza.getPrice()+1000;
    }

    @Override
    public void doOperation() {
        super.doOperation();
        System.out.print("with salami ");
    }


}
