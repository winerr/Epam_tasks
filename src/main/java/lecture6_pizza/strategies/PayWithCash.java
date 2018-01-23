package lecture6_pizza.strategies;

public class PayWithCash implements PayStrategy {
    @Override
    public boolean pay(int paymentAmount) {
        System.out.println("Client will be pay cash");
        return true;
    }

    @Override
    public void collectPaymentDetails() {
        System.out.println("Client will be pay cash");
    }
}
