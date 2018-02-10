package database_crud.dao.implementation;

import database_crud.dao.ProjectDAO;
import database_crud.entities.Project;
import database_crud.persistant.ConnectionManager;
import database_crud.transformer.Transformer;
import database_crud.utils.Select;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProjectDAOImpl implements ProjectDAO {
    private static final String FIND_ALL = "SELECT * FROM project";
    private static final String FIND_BY_ID = "SELECT * FROM project WHERE project_no=?";
    private static final String FIND_BY_PROJECT_NAME = "SELECT * FROM project WHERE project_name=?";
    private static final String FIND_BY_BUDGET = "SELECT * FROM project WHERE budget=?";
    private static final String UPDATE = "UPDATE project SET project_name=?, budget=? WHERE project_no=?";
    private static final String DELETE = "DELETE FROM project WHERE project_no=?";
    private static final String CREATE = "INSERT INTO project(project_no, project_name, budget) VALUE (?, ?, ?)";

    @Override
    public Project findByProjectName(String projectName) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        return Select.getResult(projectName, connection, FIND_BY_PROJECT_NAME, Project.class);
    }

    @Override
    public Project findByBudget(int budget) throws SQLException {
        Project project;
        Connection connection = ConnectionManager.getConnection();
        try(PreparedStatement statement = connection.prepareStatement(FIND_BY_BUDGET)){
            statement.setInt(1, budget);
            try(ResultSet resultSet = statement.executeQuery()){
                if (resultSet.next())
                    project = new Transformer<>(Project.class).fromResultSetToEntity(resultSet);
                else
                    project = null;
            }
        }
        return project;
    }

    @Override
    public List<Project> findAll() throws SQLException {
        List<Project> projects = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection();
        try(Statement statement = connection.createStatement()){
            try(ResultSet resultSet = statement.executeQuery(FIND_ALL) ) {
                while (resultSet.next()){
                    projects.add( new Transformer<>(Project.class).fromResultSetToEntity(resultSet));
                }
            }
        }
        return projects;
    }

    @Override
    public Project findById(String id) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        return Select.getResult(id, connection, FIND_BY_ID, Project.class);
    }

    @Override
    public int update(Project entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try(PreparedStatement statement = connection.prepareStatement(UPDATE)) {
            statement.setString(1, entity.getProject_name());
            statement.setInt(2, entity.getBudget());
            statement.setString(3, entity.getProject_no());
            return statement.executeUpdate();
        }
    }

    @Override
    public int create(Project entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try(PreparedStatement statement = connection.prepareStatement(CREATE)) {
            statement.setString(1, entity.getProject_no());
            statement.setString(2, entity.getProject_name());
            statement.setInt(3, entity.getBudget());
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
