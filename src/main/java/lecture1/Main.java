package lecture1;

public class Main {
    public static void main(String[] args) {
        int[] array = InputNumber.readNumbers();
        System.out.println("Sort");
        Sort.sort(array);
        for (int i: array)
            System.out.println(i);
        System.out.println("CheckNumber");
        CheckNumber.check(array);
        System.out.println("SimpleNumbers");
        SimpleNumbers.check(array);
        System.out.println("PreviousOne");
        PreviousOne.check(array);
    }
}
