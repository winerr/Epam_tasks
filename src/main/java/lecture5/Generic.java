package lecture5;

import java.util.Collection;

public class Generic {

    public static <T> int oddNumberCount(Collection<T> c, UnaryPredicate<T> p){
        int count = 0;

        for (T n: c){
            if(p.test(n)){
                count++;
            }
        }

        return count;
    }


}
