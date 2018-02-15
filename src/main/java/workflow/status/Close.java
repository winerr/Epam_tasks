package workflow.status;

public class Close implements Status {
    @Override
    public void showStatus() {
        System.out.println("Now status is close");
    }
}
