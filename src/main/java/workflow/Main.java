package workflow;

import workflow.view.WorkflowService;

public class Main {
    public static void main(String[] args) {
        new WorkflowService(new Task()).show();
    }
}
