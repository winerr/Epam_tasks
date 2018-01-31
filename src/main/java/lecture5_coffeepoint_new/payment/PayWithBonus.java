package lecture5_coffeepoint_new.payment;

import lecture5_coffeepoint_new.User;

public class PayWithBonus implements PayStrategy {
    private User user;

    public PayWithBonus(User user) {
        this.user = user;
    }

    @Override
    public boolean pay(int paymentAmount) {
        if (user.getBonusBalance() < paymentAmount){
            System.out.println("Not enough bonuses");
            return false;
        }else {
            user.getCard().setAmount(user.getBonusBalance()-paymentAmount);
            System.out.println("You pay with bonus");
            return true;
        }
    }
}
