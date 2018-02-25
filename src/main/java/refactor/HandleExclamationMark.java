package refactor;

import java.util.HashMap;
import java.util.Map;

public class HandleExclamationMark implements Handler {


    private Map<String, Handler> handlerExclamationMark;

    public HandleExclamationMark(){
        handlerExclamationMark = new HashMap<>();
        handlerExclamationMark.put("!execute", new HandleExecuteCommand());
        handlerExclamationMark.put("!custom_command", new HandleCustomCommand());
        handlerExclamationMark.put("!single_line_directive", new HandleSingleLineDirective());
    }

    @Override
    public void doAction(String line, StringBuilder scope) {
        if (handlerExclamationMark.get(line) != null ){
            handlerExclamationMark.get(line).doAction(line, scope);
        }
        scope = new StringBuilder();
    }
}
