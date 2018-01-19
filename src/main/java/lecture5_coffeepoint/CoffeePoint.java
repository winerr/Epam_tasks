package lecture5_coffeepoint;

import lecture5_coffeepoint.product.Product;

import java.util.List;

public interface CoffeePoint {
    void showMenu();
    List<Product> selectOrder();
    <T extends Product> boolean orderSmth(List<T> orderList, User user, PaymentType paymentType);
}
