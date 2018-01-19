package lecture5_coffeepoint;

import lecture5_coffeepoint.menu.CoffeeMenu;
import lecture5_coffeepoint.menu.SnackMenu;
import lecture5_coffeepoint.product.Coffee;
import lecture5_coffeepoint.product.Dish;
import lecture5_coffeepoint.product.Product;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CoffeePointImpl implements CoffeePoint {
    private final List<Coffee> coffeeMenu = CoffeeMenu.coffeeMenu;
    private final List<Dish> snackMenu = SnackMenu.snackMenu;

    @Override
    public void showMenu() {
        showList(coffeeMenu);
        showList(snackMenu);
    }

    private void showList(List<?> list){
        for (int i=0; i < list.size(); i++){
            System.out.print( (i+1) + ". " + list.get(i));
        }
    }

    @Override
    public <T extends Product> boolean orderSmth(List<T> orderList, User user, PaymentType paymentType) {
        int orderSum = calcOrderSum(orderList);
        if (paymentType == PaymentType.BONUS && user.getBonusBalance() >= orderSum){
            user.setBonusBalance(user.getBonusBalance()-orderSum);
            System.out.println("You have free coffee and snack");
            return true;
        }else if (paymentType == PaymentType.CARD){
            /**
             * Юзаємо якесь api для оплати карткою
             */
            System.out.println("You use card for pay order");
            return true;
        }else if (paymentType == PaymentType.CASH){
            System.out.println("You mast pay in coffee point");
            return true;
        }else{
            System.out.println("Ops error. Maybe you can select other payment type or you don`t have money on card");
            return false;
        }

    }

    private <T extends Product> int calcOrderSum(List<T> orderList){
        int sum = 0;
        for (Product p: orderList){
            sum += p.getPrice();
        }
        return sum;
    }

    @Override
    public List<Product> selectOrder(){
        List<Product> order = new ArrayList<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String readCommand;

        while(true){
            System.out.println("Press 1 for coffee menu\n" +
                    "Press 2 for snack menu\n" +
                    "Press \'q\' for exit ");
            try {
                readCommand = br.readLine();
                if (readCommand.equals("q") || readCommand.equals("Q") ){
                    break;
                }else if (readCommand.equals("1")){
                    selectProduct(coffeeMenu ,order);
                }else if (readCommand.equals("2")){
                    selectProduct(snackMenu, order);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return order;
    }

    private void selectProduct(List<? extends Product> selectedMenu, List<Product> order){
        showList(selectedMenu);
        System.out.println("Select " + "" + ". For exit please press \'q\'");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String readCommand;
        while(true){
            try {
                readCommand = br.readLine();
                if (readCommand.equals("q") || readCommand.equals("Q") ){
                    break;
                }else{
                    order.add(selectedMenu.get(Integer.parseInt(readCommand)-1));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
