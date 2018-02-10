package database_crud.dao.implementation;

import database_crud.dao.DepartmentDAO;
import database_crud.entities.Department;
import database_crud.persistant.ConnectionManager;
import database_crud.transformer.Transformer;
import database_crud.utils.Select;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDAOImpl implements DepartmentDAO {
    private static final String FIND_ALL = "SELECT * FROM department";
    private static final String FIND_BY_ID = "SELECT * FROM department WHERE dept_no=?";
    private static final String FIND_BY_DEPT_NAME = "SELECT * FROM department WHERE dept_name=?";
    private static final String FIND_BY_LOCATION = "SELECT * FROM department WHERE location=?";
    private static final String UPDATE = "UPDATE department SET dept_name=?, location=? WHERE dept_no=?";
    private static final String DELETE = "DELETE FROM department WHERE dept_no=?";
    private static final String CREATE = "INSERT INTO department(dept_no, dept_name, location) VALUE (?, ?, ?)";


    @Override
    public Department findByDeptName(String deptName) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        return Select.getResult(deptName, connection, FIND_BY_DEPT_NAME, Department.class);
    }

    @Override
    public Department findByLocation(String location) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        return Select.getResult(location, connection, FIND_BY_LOCATION, Department.class);
    }


    @Override
    public List<Department> findAll() throws SQLException {
        List<Department> departments = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection();
        try(Statement statement = connection.createStatement()){
            try(ResultSet resultSet = statement.executeQuery(FIND_ALL) ) {
                while (resultSet.next()){
                    departments.add( new Transformer<>(Department.class).fromResultSetToEntity(resultSet));
                }
            }
        }
        return departments;
    }

    @Override
    public Department findById(String id) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        return Select.getResult(id, connection, FIND_BY_ID, Department.class);
    }

    @Override
    public int update(Department entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try(PreparedStatement statement = connection.prepareStatement(UPDATE)) {
            statement.setString(1, entity.getDept_name());
            statement.setString(2, entity.getLocation());
            statement.setString(3, entity.getDept_no());
            return statement.executeUpdate();
        }
    }

    @Override
    public int create(Department entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try(PreparedStatement statement = connection.prepareStatement(CREATE)) {
            statement.setString(1, entity.getDept_no());
            statement.setString(2, entity.getDept_name());
            statement.setString(3, entity.getLocation());
            return statement.executeUpdate();
        }
    }

    @Override
    public int delete(String id) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try(PreparedStatement statement = connection.prepareStatement(DELETE)) {
            statement.setString(1, id);
            return statement.executeUpdate();
        }
    }
}
