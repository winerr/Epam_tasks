package database_crud.dao.implementation;

import database_crud.dao.WorksOnDAO;
import database_crud.entities.CompositeKey;
import database_crud.entities.WorksOn;
import database_crud.persistant.ConnectionManager;
import database_crud.transformer.Transformer;
import database_crud.utils.Select;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WorksOnDAOImpl implements WorksOnDAO {
    private static final String FIND_ALL =
            "SELECT * from works_on LEFT JOIN employee e ON works_on.emp_no = e.emp_no " +
                    "LEFT JOIN project p ON works_on.project_no = p.project_no";

    private static final String FIND_BY_JOB =
            "SELECT * from works_on LEFT JOIN employee e ON works_on.emp_no = e.emp_no " +
                    "LEFT JOIN project p ON works_on.project_no = p.project_no WHERE job=?";

    private static final String FIND_BY_DATE =
            "SELECT * from works_on LEFT JOIN employee e ON works_on.emp_no = e.emp_no " +
                    "LEFT JOIN project p ON works_on.project_no = p.project_no WHERE enter_date=?";

    private static final String UPDATE = "UPDATE works_on SET job=?, enter_date=? WHERE emp_no=? AND project_no=?";
    private static final String CREATE = "INSERT INTO works_on VALUE (?, ?, ?, ?)";
    private static final String DELETE = "DELETE FROM works_on WHERE emp_no=? AND project_no=?";



    @Override
    public List<WorksOn> findByJob(String job) throws SQLException {
        List<WorksOn> worksOns = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection();
        Select.getResult(job, connection, FIND_BY_JOB, worksOns, WorksOn.class);
        return worksOns;
    }

    @Override
    public List<WorksOn> findByDate(Date date) throws SQLException {
        List<WorksOn> worksOns = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection();
        try(PreparedStatement statement = connection.prepareStatement(FIND_BY_DATE)){
            statement.setDate(1, date);
            try(ResultSet resultSet = statement.executeQuery() ) {
                while (resultSet.next()){
                    worksOns.add( new Transformer<>(WorksOn.class).fromResultSetToEntity(resultSet));
                }
            }
        }
        return worksOns;
    }

    @Override
    public List<WorksOn> findAll() throws SQLException {
        List<WorksOn> worksOns = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection();
        try(Statement statement = connection.createStatement()){
            try(ResultSet resultSet = statement.executeQuery(FIND_ALL) ) {
                while (resultSet.next()){
                    worksOns.add( new Transformer<>(WorksOn.class).fromResultSetToEntity(resultSet));
                }
            }
        }
        return worksOns;
    }

    @Override @Deprecated
    public WorksOn findById(CompositeKey id) throws SQLException {
        return null;
    }

    @Override
    public int update(WorksOn entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try(PreparedStatement statement = connection.prepareStatement(UPDATE)) {
            statement.setString(1, entity.getJob());
            statement.setDate(2, entity.getEnter_date());
            statement.setInt(3, entity.getEmployee().getEmp_no());
            statement.setString(4, entity.getProject().getProject_no());
            return statement.executeUpdate();

        }
    }

    @Override
    public int create(WorksOn entity) throws SQLException {
        int count = 0;
        Connection connection = ConnectionManager.getConnection();
        if ( (new EmployeeDAOImpl().findById(entity.getEmployee().getEmp_no())) == null )
            count += new EmployeeDAOImpl().create(entity.getEmployee());
        if ( (new ProjectDAOImpl().findById(entity.getProject().getProject_no())) == null )
            count += new ProjectDAOImpl().create(entity.getProject());
        try(PreparedStatement statement = connection.prepareStatement(CREATE)) {
            statement.setInt(1, entity.getEmployee().getEmp_no());
            statement.setString(2, entity.getProject().getProject_no());
            statement.setString(3, entity.getJob());
            statement.setDate(4, entity.getEnter_date());
            count += statement.executeUpdate();
            return count;
        }
    }

    @Override
    public int delete(CompositeKey id) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try(PreparedStatement statement = connection.prepareStatement(DELETE)) {
            statement.setInt(1, id.getEmp_no());
            statement.setString(2, id.getProject_no());
            return statement.executeUpdate();
        }
    }

}
