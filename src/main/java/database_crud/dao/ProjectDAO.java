package database_crud.dao;

import database_crud.entities.Project;

import java.sql.SQLException;

public interface ProjectDAO extends GeneralDAO<Project, String> {
    Project findByProjectName(String projectName) throws SQLException;
    Project findByBudget(int budget) throws SQLException;
}
