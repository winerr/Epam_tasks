package database_crud.services;

import database_crud.dao.implementation.DepartmentDAOImpl;
import database_crud.dao.implementation.ProjectDAOImpl;
import database_crud.entities.Department;
import database_crud.entities.Project;

import java.sql.SQLException;
import java.util.List;

public class ProjectService {
    public List<Project> findAll() throws SQLException {
        return new ProjectDAOImpl().findAll();
    }

    public Project findById(String id) throws SQLException{
        return new ProjectDAOImpl().findById(id);
    }

    public Project findByProjectName(String projectName) throws SQLException{
        return new ProjectDAOImpl().findByProjectName(projectName);
    }

    public Project findByBudget(int budget) throws SQLException{
        return new ProjectDAOImpl().findByBudget(budget);
    }

    public int create(Project project) throws SQLException{
        return new ProjectDAOImpl().create(project);
    }

    public int update(Project project) throws SQLException{
        return new ProjectDAOImpl().update(project);
    }

    public int delete(String id) throws SQLException{
        return new ProjectDAOImpl().delete(id);
    }
}
