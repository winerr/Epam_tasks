package lecture5_coffeepoint;

import lecture5_coffeepoint.product.Product;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        CoffeePoint cp = new CoffeePointImpl();
        List<Product> order = cp.selectOrder();
        System.out.println("My order");
        order.forEach(System.out::print);
        cp.orderSmth(order, new User("fn", "ln", 9000, 32532525352124L), PaymentType.BONUS);
    }

}
