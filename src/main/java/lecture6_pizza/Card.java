package lecture6_pizza;

import lombok.Getter;
import lombok.Setter;

public class Card {

    @Getter @Setter
    private int amount;

    @Getter @Setter
    private String cardNumber;

    @Getter @Setter
    private String date;

    @Getter @Setter
    private String cvv;

    public Card(){
        this.amount = 100000;
    }
}
