package database_crud.entities;

import database_crud.annotation.Column;
import database_crud.annotation.Table;
import lombok.Getter;
import lombok.Setter;

@Table(name = "project")
public class Project {
    @Column(name = "project_no") @Getter @Setter
    private String project_no;
    @Column(name = "project_name") @Getter @Setter
    private String project_name;
    @Column(name = "budget") @Getter @Setter
    private Integer budget;

    public Project(){

    }

    public Project(String project_no, String project_name, int budget){
        this.project_no = project_no;
        this.project_name = project_name;
        this.budget = budget;
    }

    @Override
    public String toString() {
        return String.format("%-5s %-15s %-10d", project_no, project_name, budget);
    }
}
