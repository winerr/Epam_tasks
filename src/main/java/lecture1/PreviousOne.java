package lecture1;

public class PreviousOne {

    public static void check(int []array){
        for(int i=1; i<array.length; i++){

            for(int j=0; j<i; j++){
                if(array[i]%array[j] == 0){
                    System.out.println(array[i]);
                    break;
                }
            }

        }
    }

}
