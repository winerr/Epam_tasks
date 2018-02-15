package workflow.view;

import workflow.Task;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Hashtable;
import java.util.Map;

public class WorkflowService {
    private Task task;
    private Map<String, String> menu;
    private Map<String, Changeable> menuCase;
    private BufferedReader reader;

    public WorkflowService(Task task){
        this.task = task;
        this.menu = new Hashtable<>();
        this.menuCase = new Hashtable<>();
        this.reader = new BufferedReader(new InputStreamReader(System.in));

        this.menu.put("1", "1 - to set status open");
        this.menu.put("2", "2 - to set status resolved");
        this.menu.put("3", "3 - to set status close");
        this.menu.put("4", "4 - to set status reopen");
        this.menu.put("Q", "Q - for exit");

        this.menuCase.put("1", this::changeToOpen);
        this.menuCase.put("2", this::changeToResolved);
        this.menuCase.put("3", this::changeToClose);
        this.menuCase.put("4", this::changeToReOpen);
    }

    private void changeToOpen(){
        task.changeStatusToOpen();
        task.showStatus();
    }
    private void changeToReOpen(){
        task.changeStatusToReOpen();
        task.showStatus();
    }
    private void changeToClose(){
        task.changeStatusToClose();
        task.showStatus();
    }
    private void changeToResolved(){
        task.changeStatusToResolved();
        task.showStatus();
    }

    private void showMenu(){
        for (String menu: menu.values()){
            System.out.println(menu);
        }
    }

    public void show(){
        String key = "";
        task.showStatus();
        do {
            try {
                showMenu();
                key = reader.readLine().toUpperCase();
                if (key.matches("[1-4]")){
                    menuCase.get(key).change();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }while (!key.equals("Q"));
    }
}
