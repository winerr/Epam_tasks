package lecture6_pizza.decorator;

import java.util.List;

public interface Pizza {
    List<String> getDescription();
    int getPrice();

    void doOperation();
}
