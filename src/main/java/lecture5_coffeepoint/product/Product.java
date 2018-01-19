package lecture5_coffeepoint.product;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor(access = AccessLevel.PUBLIC)
public abstract class Product {
    @Getter @Setter
    protected String name;

    @Getter @Setter
    protected int price;
}
