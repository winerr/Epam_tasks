package database_crud.entities;

import database_crud.annotation.Column;
import database_crud.annotation.ID;
import database_crud.annotation.Table;
import lombok.Getter;
import lombok.Setter;

@Table(name ="department")
public class Department {
    @Column(name = "dept_no") @Getter @Setter
    private String dept_no;
    @Column(name = "dept_name") @Getter @Setter
    private String dept_name;
    @Column(name = "location") @Getter @Setter
    private String location;

    public Department(){

    }

    public Department(String dept_no, String  dept_name, String location){
        this.dept_no = dept_no;
        this.dept_name = dept_name;
        this.location = location;
    }

    @Override
    public String toString() {
        return String.format("%-5s %-15s %-15s", dept_no, dept_name, location);
    }
}
