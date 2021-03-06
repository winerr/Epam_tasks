package workflow.status;

public class Open implements Status{
    @Override
    public Status setResolved() {
        return new Resolved();
    }

    @Override
    public Status setClose() {
        return new Close();
    }

    @Override
    public void showStatus() {
        System.out.println("Now status is open");
    }
}
