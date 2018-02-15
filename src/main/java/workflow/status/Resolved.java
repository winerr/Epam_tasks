package workflow.status;

public class Resolved implements Status {
    @Override
    public Status setReOpen() {
        return new ReOpen();
    }

    @Override
    public Status setClose() {
        return new Close();
    }

    @Override
    public void showStatus() {
        System.out.println("Now status is resolved");
    }
}
