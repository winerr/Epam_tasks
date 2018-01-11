package lecture4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputText {

    public static String read(){

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String temp;
        StringBuilder sb = new StringBuilder();

        while (true){
            try {
                temp = br.readLine();
                if(temp.equals("")){
                    break;
                }else{
                    sb.append(temp);
                    sb.append('\n');
                }
            }catch (IOException e){
                System.out.println(e.getMessage());
            }

        }

        return sb.toString();
    }

}
