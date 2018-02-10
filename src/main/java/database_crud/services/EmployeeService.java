package database_crud.services;

import database_crud.dao.implementation.EmployeeDAOImpl;
import database_crud.entities.Employee;

import java.sql.SQLException;
import java.util.List;

public class EmployeeService {
    public List<Employee> findAll() throws SQLException{
        return new EmployeeDAOImpl().findAll();
    }

    public Employee findById(int id) throws SQLException{
        return new EmployeeDAOImpl().findById(id);
    }

    public List<Employee> findByFirstName(String fname) throws SQLException{
        return new EmployeeDAOImpl().findByFirstName(fname);
    }

    public List<Employee> findByLastName(String lname) throws SQLException{
        return new EmployeeDAOImpl().findByLastName(lname);
    }

    public List<Employee> findByDeptNo(String deptNo) throws SQLException{
        return new EmployeeDAOImpl().findByDeptNo(deptNo);
    }

    public int create(Employee employee) throws SQLException{
        return new EmployeeDAOImpl().create(employee);
    }

    public int update(Employee employee) throws SQLException{
        return new EmployeeDAOImpl().update(employee);
    }

    public int delete(int id) throws SQLException{
        return new EmployeeDAOImpl().delete(id);
    }

}
