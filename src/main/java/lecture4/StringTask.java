package lecture4;
//Барроуз - Уіллер
public class StringTask {
    private String text;

    public StringTask(String text){
        this.text = text;
    }

    public String replaceSimilar(){
        StringBuilder resultText = new StringBuilder();
        char[] textArray = text.toCharArray();
        resultText.append(textArray[0]);
        for(int i=1; i<textArray.length; i++){
            if(textArray[i] == textArray[i-1]){
                continue;
            }else{
                resultText.append(textArray[i]);
            }
        }

        return resultText.toString();
    }

    public String rightTab(){
        StringBuilder resultText = new StringBuilder();
        char[] textArray = text.toCharArray();
        int index = 50;
        while (index < textArray.length){
            //таблица acii
            if(textArray[index] == ' ' || textArray[index] == '\n' || textArray[index] == ',' || textArray[index] == '.'){
                resultText.append(new String(textArray).subSequence(index-50, index+1));
            }else{

            }
        }



        return null;
    }

}
