package lecture5_coffeepoint_new.payment;

public class PayWithCash implements PayStrategy {
    @Override
    public boolean pay(int paymentAmount) {
        System.out.println("Client will be pay cash");
        return true;
    }
}
