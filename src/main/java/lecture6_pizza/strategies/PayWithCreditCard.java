package lecture6_pizza.strategies;

import lecture6_pizza.Card;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PayWithCreditCard implements PayStrategy {
    private Card card;

    @Override
    public boolean pay(int paymentAmount) {
        if(card == null)
            return false;
        else if (card.getAmount() < paymentAmount){
            System.out.println("Not enough money");
            return false;
        }else {
            card.setAmount(card.getAmount()-paymentAmount);
            System.out.println("You pay with card");
            return true;
        }
    }

    @Override
    public void collectPaymentDetails() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        card = new Card();
        try{
            System.out.println("Input card number:");
            card.setCardNumber(reader.readLine());
            System.out.println("Input card date:");
            card.setDate(reader.readLine());
            System.out.println("Input card cvv:");
            card.setCvv(reader.readLine());
            reader.close();
        }catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }

}
