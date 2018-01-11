package lecture4;

import lombok.Getter;

public class BurrowsWheelerTransform {
    private String inputString;
    @Getter
    private String outputString;

    private String[] transformString;

    public BurrowsWheelerTransform(String inputString){
        this.inputString = inputString;
        this.transformString = new String[this.inputString.length()];
    }

    public void transform(){
        firstStep();
        secondStep();
        thirdStep();
    }

    //Перший крок (Перестановки)
    private void firstStep(){
        char[] inputStringArray = inputString.toCharArray();

        char[] chars;

        for(int i=0; i<inputStringArray.length; i++){
            chars = new char[inputStringArray.length];
            for (int j=i; j<=inputStringArray.length; j++){
                if(j >= inputStringArray.length){
                    for (int k=0; k<i; k++){
                        chars[j-i+k] = inputStringArray[k];
                    }
                    break;
                }
                chars[j-i] = inputStringArray[j];
            }
            transformString[i] = new String(chars);
        }

    }

    //Другий крок (Сортування)
    private void secondStep(){
        String temp;
        for(int i=0; i<transformString.length; i++){

            for(int j=0; j<transformString.length-1; j++){

                if(transformString[j].compareTo(transformString[j+1]) > 0){
                    temp = transformString[j];
                    transformString[j] = transformString[j+1];
                    transformString[j+1] = temp;
                }

            }

        }
    }

    //Третый крок (Отримання результату)
    private void thirdStep(){
        StringBuilder result = new StringBuilder();
        for (String str: transformString){
            result.append(str.charAt(str.length()-1));
        }
        outputString = result.toString();
    }


}
