package refactor;

import java.util.HashMap;
import java.util.Map;

public class Parser {

    private Map<Character, Handler> handler;

    public Parser(Map<Character, Handler> defaultHandler){
        handler = defaultHandler;
    }

    private void addHandler(char key, Handler action){
        handler.put(key, action);
    }
//
//    public void Parse(){
//        StringReader reader = new StringReader(scriptTextToProcess);
//        StringBuilder scope = new StringBuilder();
//        String line = reader.ReadLine();
//        while (line != null)
//        {
//            if( handler.get(line[0]) != null ){
//                handler.get(line[0]).doAction(line, scope);
//            }else {
//                scope.Append(line);
//            }
//            line = reader.ReadLine();
//        }
//    }
}
