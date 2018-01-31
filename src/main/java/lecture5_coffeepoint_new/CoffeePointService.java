package lecture5_coffeepoint_new;

import lecture5_coffeepoint_new.menu.*;
import lecture5_coffeepoint_new.payment.PayStrategy;
import lecture5_coffeepoint_new.payment.PayWithBonus;
import lecture5_coffeepoint_new.payment.PayWithCard;
import lecture5_coffeepoint_new.payment.PayWithCash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CoffeePointService {
    public static void createOrder(User user){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String selected;
        Coffee coffee = new DefaultCoffee();
        System.out.print("Select coffee component:\n" +
                "1. Milk\n" +
                "2. Cream\n" +
                "3. Chocolate\n" +
                "4. Cocoa\n" +
                "5. Cinnamon\n" +
                "6. Marshmallow\n" +
                "q. For exit\n");

        while (true){
            System.out.println("Now you select:");
            coffee.showDescription();
            System.out.println();
            try{
                selected = reader.readLine();
                if(selected.equals("1")){
                    coffee = new Milk(coffee);
                }else if(selected.equals("2")){
                    coffee = new Cream(coffee);
                }else if(selected.equals("3")){
                    coffee = new Chocolate(coffee);
                }else if(selected.equals("4")){
                    coffee = new Cocoa(coffee);
                }else if(selected.equals("5")){
                    coffee = new Cinnamon(coffee);
                }else if(selected.equals("6")){
                    coffee = new Marshmallow(coffee);
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
        coffee.showDescription();
        System.out.println("\n You amount: " + coffee.getPrice()/100 );
        PayStrategy payType;
        System.out.print("Select payment type:\n" +
                "1. Credit card\n" +
                "2. Bonus\n" +
                "3. Cash\n");
        while (true) {
            try {
                selected = reader.readLine();
                if (selected.equals("1")) {
                    payType = new PayWithCard(user);
                    payType.pay(coffee.getPrice());
                    break;
                } else if (selected.equals("2")) {
                    payType = new PayWithBonus(user);
                    payType.pay(coffee.getPrice());
                    break;
                } else if (selected.equals("3")) {
                    payType = new PayWithCash();
                    payType.pay(coffee.getPrice());
                    break;
                }else {
                    System.out.println("You must select one of this payment type");
                }
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }

    }
}
