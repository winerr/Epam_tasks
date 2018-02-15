package workflow;

import lombok.Getter;
import lombok.Setter;
import workflow.status.Open;
import workflow.status.Status;

public class Task {
    private Status status;
    @Getter @Setter
    private boolean assigned;

    public Task(){
        this.status = new Open();
    }

    public void changeStatusToResolved(){
        try {
            status = status.setResolved();
        } catch (StatusChangeException e) {
            System.out.println(e.getMessage());
        }
    }

    public void changeStatusToOpen(){
        try {
            status = status.setOpen();
        } catch (StatusChangeException e) {
            System.out.println(e.getMessage());
        }
    }

    public void changeStatusToReOpen(){
        try {
            status = status.setReOpen();
        } catch (StatusChangeException e) {
            System.out.println(e.getMessage());
        }
    }

    public void changeStatusToClose(){
        try {
            status = status.setClose();
        } catch (StatusChangeException e) {
            System.out.println(e.getMessage());
        }
    }

    public void showStatus(){
        status.showStatus();
    }
}
