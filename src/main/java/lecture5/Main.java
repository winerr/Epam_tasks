package lecture5;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> l = new ArrayList<>();
        l.add(2);
        l.add(3);
        l.add(4);
        l.add(5);
        l.add(6);
        System.out.println(Generic.oddNumberCount(l, new OddPredicate()));

    }
}
