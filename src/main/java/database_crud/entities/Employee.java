package database_crud.entities;

import database_crud.annotation.Column;
import database_crud.annotation.ID;
import database_crud.annotation.Table;
import lombok.Getter;
import lombok.Setter;

@Table(name = "employee")
public class Employee {
    @ID(name = "emp_no") @Getter @Setter
    private int emp_no;
    @Column(name = "emp_fname") @Getter @Setter
    private String emp_fname;
    @Column(name = "emp_lname") @Getter @Setter
    private String emp_lname;
    @Column(name = "dept_no") @Getter @Setter
    private String dept_no;

    public Employee(){

    }

    public Employee(Integer empNo, String empFirstName, String epmLastName, String deptNo) {
        this.emp_no = empNo;
        this.emp_fname = empFirstName;
        this.emp_lname = epmLastName;
        this.dept_no = deptNo;
    }

    @Override
    public String toString() {
        return String.format("%-10d %-15s %-15s %s", emp_no, emp_fname, emp_lname, dept_no);
    }
}
