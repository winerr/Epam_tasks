package lecture1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputNumber {

    public static int[] readNumbers(){

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int []array = new int[5];
        String temp;

        for (int i = 0; i < 5; i++) {
            while (true){
                try {
                    temp = br.readLine();
                    int number = Integer.parseInt(temp);
                    //Перевірка на те що число складається з 5 цифр
                    if(number >= 10000 && number <= 99999){
                        array[i] = number;
                        break;
                    }else {
                        System.out.println("Number must consist five digits!");
                        continue;
                    }
                }catch (IOException e){
                    System.out.println(e.getMessage());
                }catch (NumberFormatException e){
                    System.out.println("Please enter the number!");
                }
            }
        }
        return array;
    }
}
