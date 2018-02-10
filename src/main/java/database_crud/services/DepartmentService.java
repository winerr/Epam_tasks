package database_crud.services;

import database_crud.dao.implementation.DepartmentDAOImpl;
import database_crud.entities.Department;

import java.sql.SQLException;
import java.util.List;

public class DepartmentService {
    public List<Department> findAll() throws SQLException {
        return new DepartmentDAOImpl().findAll();
    }

    public Department findById(String id) throws SQLException{
        return new DepartmentDAOImpl().findById(id);
    }

    public Department findByDeptName(String deptName) throws SQLException{
        return new DepartmentDAOImpl().findByDeptName(deptName);
    }

    public Department findByLocation(String location) throws SQLException{
        return new DepartmentDAOImpl().findByLocation(location);
    }

    public int create(Department department) throws SQLException{
        return new DepartmentDAOImpl().create(department);
    }

    public int update(Department department) throws SQLException{
        return new DepartmentDAOImpl().update(department);
    }

    public int delete(String id) throws SQLException{
        return new DepartmentDAOImpl().delete(id);
    }
}
