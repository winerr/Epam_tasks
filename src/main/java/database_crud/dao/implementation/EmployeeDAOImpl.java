package database_crud.dao.implementation;

import database_crud.dao.EmployeeDAO;
import database_crud.entities.Employee;
import database_crud.persistant.ConnectionManager;
import database_crud.transformer.Transformer;
import database_crud.utils.Select;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {
    private static final String FIND_ALL = "SELECT * FROM employee";
    private static final String FIND_BY_ID = "SELECT * FROM employee WHERE emp_no=?";
    private static final String FIND_BY_FNAME = "SELECT * FROM employee WHERE emp_fname=?";
    private static final String FIND_BY_LNAME = "SELECT * FROM employee WHERE emp_lname=?";
    private static final String FIND_BY_DEPT_NO = "SELECT * FROM employee WHERE dept_no=?";
    private static final String UPDATE = "UPDATE employee SET emp_fname=?, emp_lname=?, dept_no=? WHERE emp_no=?";
    private static final String DELETE = "DELETE FROM employee WHERE emp_no=?";
    private static final String CREATE = "INSERT INTO employee(emp_no, emp_fname, emp_lname, dept_no) VALUE (?, ?, ?, ?)";

    public List<Employee> findAll() throws SQLException {
        List<Employee> employees = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection();
        try(Statement statement = connection.createStatement()){
            try(ResultSet resultSet = statement.executeQuery(FIND_ALL) ) {
                while (resultSet.next()){
                    employees.add( new Transformer<>(Employee.class).fromResultSetToEntity(resultSet));
                }
            }
        }

        return employees;
    }

    public Employee findById(Integer id) throws SQLException {
        Employee employee;
        Connection connection = ConnectionManager.getConnection();
        try(PreparedStatement statement = connection.prepareStatement(FIND_BY_ID)){
            statement.setInt(1, id);
            try(ResultSet resultSet = statement.executeQuery()){
                if (resultSet.next())
                    employee = new Transformer<>(Employee.class).fromResultSetToEntity(resultSet);
                else
                    employee = null;
            }
        }
        return employee;
    }

    @Override
    public int update(Employee entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try(PreparedStatement statement = connection.prepareStatement(UPDATE)) {
            statement.setString(1, entity.getEmp_fname());
            statement.setString(2, entity.getEmp_lname());
            statement.setString(3, entity.getDept_no());
            statement.setInt(4, entity.getEmp_no());
            return statement.executeUpdate();
        }
    }

    @Override
    public int create(Employee entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try(PreparedStatement statement = connection.prepareStatement(CREATE)) {
            statement.setInt(1, entity.getEmp_no());
            statement.setString(2, entity.getEmp_fname());
            statement.setString(3, entity.getEmp_lname());
            statement.setString(4, entity.getDept_no());
            return statement.executeUpdate();
        }
    }

    @Override
    public int delete(Integer id) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try(PreparedStatement statement = connection.prepareStatement(DELETE)) {
            statement.setInt(1, id);
            return statement.executeUpdate();
        }
    }

    @Override
    public List<Employee> findByFirstName(String fname) throws SQLException {
        List<Employee> employees = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection();
        Select.getResult(fname, connection, FIND_BY_FNAME, employees, Employee.class);
        return employees;
    }

    @Override
    public List<Employee> findByLastName(String lname) throws SQLException {
        List<Employee> employees = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection();
        Select.getResult(lname, connection, FIND_BY_LNAME, employees, Employee.class);
        return employees;
    }



    @Override
    public List<Employee> findByDeptNo(String deptNo) throws SQLException {
        List<Employee> employees = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection();
        Select.getResult(deptNo, connection, FIND_BY_DEPT_NO, employees, Employee.class);
        return employees;
    }


}
