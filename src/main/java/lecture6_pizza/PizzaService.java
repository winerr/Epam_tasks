package lecture6_pizza;

import lecture6_pizza.decorator.*;
import lecture6_pizza.strategies.PayStrategy;
import lecture6_pizza.strategies.PayWithCash;
import lecture6_pizza.strategies.PayWithCreditCard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PizzaService {
    public static void createOrder(){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String selected;
        Pizza pizza = new DefaultPizza();
        System.out.print("Select pizza component:\n" +
                "1. Cheese\n" +
                "2. Salami\n" +
                "3. Bacon\n" +
                "q. For exit");

        while (true){
            System.out.println("Now you select:");
            pizza.doOperation();
            System.out.println();
            try{
                selected = reader.readLine();
                if(selected.equals("1")){
                    pizza = new Cheese(pizza);
                }else if(selected.equals("2")){
                    pizza = new Salami(pizza);
                }else if(selected.equals("3")){
                    pizza = new Bacon(pizza);
                }else if(selected.equals("q")) {
                    break;
                }else{
                    System.out.println("error");
                }

            }catch (IOException ex){
                System.out.println(ex.getMessage());
            }

        }
        System.out.println("You select:");
        pizza.doOperation();
        System.out.println("\n You amount: " + pizza.getPrice()/100 );
        PayStrategy payType;
        System.out.print("Select payment type:\n" +
                "1. Credit card\n" +
                "2. Cash\n");

        try{
            selected = reader.readLine();
            if(selected.equals("1")){
                payType = new PayWithCreditCard();
                payType.collectPaymentDetails();
                payType.pay(pizza.getPrice());
            }else if (selected.equals("2")){
                payType = new PayWithCash();
                payType.pay(pizza.getPrice());
            }
        }catch (IOException ex){
            System.out.println(ex.getMessage());
        }

    }
}
