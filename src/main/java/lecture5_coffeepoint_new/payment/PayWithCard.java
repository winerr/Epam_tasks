package lecture5_coffeepoint_new.payment;

import lecture5_coffeepoint_new.User;

public class PayWithCard implements PayStrategy {
    private User user;

    public PayWithCard(User user) {
        this.user = user;
    }

    @Override
    public boolean pay(int paymentAmount) {
        if (user.getCard() == null){
            System.out.println("You haven`t card!");
            return false;
        }else if (user.getCard().getAmount() < paymentAmount){
            System.out.println("Not enough money");
            return false;
        }else {
            user.getCard().setAmount(user.getCard().getAmount()-paymentAmount);
            System.out.println("You pay with card");
            return true;
        }
    }
}
