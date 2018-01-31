package lecture5_coffeepoint_new.menu;

import java.util.List;

public interface Coffee {
    List<String> getDescription();
    int getPrice();

    void showDescription();
}
