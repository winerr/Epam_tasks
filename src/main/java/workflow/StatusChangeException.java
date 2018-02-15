package workflow;

public class StatusChangeException extends Exception {
    @Override
    public String getMessage() {
        return "Status can't be changed";
    }
}
