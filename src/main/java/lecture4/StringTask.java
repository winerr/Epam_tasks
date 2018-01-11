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
        char [][] exitText = new char[textArray.length/50+10][51];
        int index = 0;
        int row = 0, column;
        for (int i=50; i<textArray.length; i+=50){
            while (true) {
                if (textArray[i] == ' ' || textArray[i] == '\n') {
                    column = 50-(i-index);
                    for (int l=0; l<column; l++)
                        exitText[row][l] = ' ';
                    for ( ; index < i; index++) {
                        if(textArray[index] == '\n'){
                            index++;
                            i = index;
                            break;
                        }
                        exitText[row][column] = textArray[index];
                        column++;
                    }
                    exitText[row][column] = '\n';
                    row++;
                    break;
                } else {
                    i--;
                }
            }

        }

        for (char[] c: exitText){
            resultText.append(c);
        }


        return resultText.toString();
    }

}
