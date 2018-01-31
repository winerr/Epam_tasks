package lecture5_coffeepoint_new;

import lombok.Getter;
import lombok.Setter;

public class User {
    @Getter @Setter
    private String firstName;
    @Getter @Setter
    private String lastName;
    @Getter @Setter
    private Card card;
    @Getter @Setter
    private int bonusBalance;

    public User(String firstName, String lastName, Card card, int bonusBalance) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.card = card;
        this.bonusBalance = bonusBalance;
    }
}
