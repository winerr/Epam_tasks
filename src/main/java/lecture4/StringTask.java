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
        char [] exitText;
        int index = 0;
        int position, sizeOfRow = 50;
        int startPosition;
        boolean interrupt = false;
        for (int i=50; i<textArray.length; i+=sizeOfRow){
            while (true) {
                if (textArray[i] == ' ' || textArray[i] == '\n' || textArray[i] == '.' || textArray[i] == ',' || textArray[i] == '!' || textArray[i] == '?') {

                    exitText = new char[sizeOfRow+1];
                    //Заповнюємо усю стрічку пробілами
                    for (int l=0; l<sizeOfRow+1; l++)
                        exitText[l] = ' ';

                    position = sizeOfRow-(i-index);
                    startPosition = position;
                    //Переносимо вміст вчіжного тексту у відформатовану стрічку
                    for ( ; index < i; index++) {
                        //Якщо знайшли символ '\n' в середині стрічки то переносимо весь вміст у кінець
                        if(textArray[index] == '\n'){
                            int startElement = sizeOfRow-1;
                            for(int j=position-1; j>=startPosition; j--){
                                exitText[startElement] = exitText[j];
                                exitText[j] = ' ';
                                startElement--;
                            }
                            exitText[sizeOfRow] = '\n';
                            index++;
                            i = index;
                            interrupt = true;
                            break;
                        }

                        exitText[position] = textArray[index];
                        position++;

                    }
                    //Якщо ми не зустріли символ переносу рядка раніше то додаємо його в кінець
                    if(!interrupt)
                        exitText[position] = '\n';
                    else
                        interrupt = false;

                    //Додаємо отриманий масив символів до кінцевого тексту
                    resultText.append(exitText);
                    break;
                } else {
                    i--;
                }
            }

        }
        return resultText.toString();
    }

}
