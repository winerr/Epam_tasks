package database_crud.entities;

import database_crud.annotation.Column;
import database_crud.annotation.OneToOne;
import database_crud.annotation.Table;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Table(name = "works_on")
public class WorksOn {
    @OneToOne @Getter @Setter
    private Employee employee;
    @OneToOne @Getter @Setter
    private Project project;
    @Column(name = "job") @Getter @Setter
    private String job;
    @Column(name = "enter_date") @Getter @Setter
    private Date enter_date;

    public WorksOn(){

    }

    public WorksOn(Employee employee, Project project, String job, Date enter_date){
        this.employee = employee;
        this.project = project;
        this.enter_date = enter_date;
        this.job = job;
    }

    public WorksOn(String job, Date enter_date){
        this.employee = null;
        this.project = null;
        this.enter_date = enter_date;
        this.job = job;
    }

    @Override
    public String toString() {
        return employee.toString() +
                '\t' +
                project.toString() +
                '\t' +
                String.format("%-10s %-10s", job, enter_date.toString());
    }
}
