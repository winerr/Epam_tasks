package lecture1;

public class CheckNumber {

    public static void check(int []array){
        String str;
        char []number;
        boolean check = false;
        for(int i=0; i<array.length; i++){
            //Перетворення кожного алементу числового масиву у масив символів
            str = String.valueOf(array[i]);
            number = str.toCharArray();
            for(int j=0; j<number.length-1; j++){
                //Перевірка чи наступне число більше за попереднє
                if( (int)number[j] < (int)number[j+1]){
                    check = true;
                }else{
                    check = false;
                    break;
                }
            }
            if(check){
                System.out.println(str);
            }
        }
    }

}
