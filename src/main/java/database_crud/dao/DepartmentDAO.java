package database_crud.dao;

import database_crud.entities.Department;

import java.sql.SQLException;

public interface DepartmentDAO extends GeneralDAO<Department, String> {
    Department findByDeptName(String deptName) throws SQLException;
    Department findByLocation(String location) throws SQLException;
}
