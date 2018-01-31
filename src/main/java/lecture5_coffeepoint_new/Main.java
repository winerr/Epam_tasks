package lecture5_coffeepoint_new;

public class Main {
    public static void main(String[] args) {
        Card card = new Card("321541515531", "12/21", "312");
        User client = new User("Ivan","Ivanov", card, 6000);
        CoffeePointService.createOrder(client);
    }
}
