package lecture1;

public class Fibonachi {

    public static void printFibonachi(int count){
        long firstPrevious = 0;
        long secondPrevious = 1;
        long current;
        for(int i=1; i<count; i++){
            current = firstPrevious + secondPrevious;
            secondPrevious = firstPrevious;
            System.out.println(current);
            firstPrevious = current;

        }
    }

    public static void main(String[] args) {
        printFibonachi(20);
    }
}
