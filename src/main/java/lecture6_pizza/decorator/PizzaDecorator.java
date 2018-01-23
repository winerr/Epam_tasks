package lecture6_pizza.decorator;


public abstract class PizzaDecorator implements Pizza {
    protected Pizza pizza;

    public PizzaDecorator(Pizza pizza){
        this.pizza = pizza;
    }

    @Override
    public void doOperation() {
        pizza.doOperation();
    }

}
