package lecture1;

public class SimpleNumbers {

    public static void check(int []array){

        String str;
        char []chars;
        boolean isSimple = true;

        for (int i=0; i<array.length; i++){
            isSimple = true;
            str = String.valueOf(array[i]);
            chars = str.toCharArray();
            for(int j=0; j<chars.length; j++){

                int number = Character.getNumericValue(chars[j]);
                for(int k = 2; k<=Math.sqrt(number); k++){
                    if(number%k == 0){
                        isSimple = false;
                        break;
                    }
                }

                if (isSimple)
                    break;

            }
            if (isSimple)
                System.out.println(str);
        }

    }

}
