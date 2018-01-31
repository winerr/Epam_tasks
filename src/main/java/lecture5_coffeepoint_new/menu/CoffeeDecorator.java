package lecture5_coffeepoint_new.menu;

public abstract class CoffeeDecorator implements Coffee {
    protected Coffee coffee;

    public CoffeeDecorator(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public void showDescription() {
        coffee.showDescription();
    }
}
