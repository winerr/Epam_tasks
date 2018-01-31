package lecture5_coffeepoint_new;

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

    public Card(String cardNumber, String date, String cvv) {
        this.cardNumber = cardNumber;
        this.date = date;
        this.cvv = cvv;
        this.amount = 100000;
    }
}
