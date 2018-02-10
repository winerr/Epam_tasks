package database_crud.dao;

import database_crud.entities.Employee;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeDAO extends GeneralDAO<Employee, Integer> {
    List<Employee> findByFirstName(String fname) throws SQLException;
    List<Employee> findByLastName(String lname) throws SQLException;
    List<Employee> findByDeptNo(String deptNo) throws SQLException;
}
