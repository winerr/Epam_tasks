package workflow.status;

import workflow.StatusChangeException;

public interface Status {
    default Status setClose() throws StatusChangeException {
        throw new StatusChangeException();
    }
    default Status setOpen() throws StatusChangeException {
        throw new StatusChangeException();
    }
    default Status setResolved() throws StatusChangeException {
        throw new StatusChangeException();
    }
    default Status setReOpen() throws StatusChangeException {
        throw new StatusChangeException();
    }

    void showStatus();
}
