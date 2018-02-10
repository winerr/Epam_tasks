package database_crud.services;

import database_crud.dao.implementation.WorksOnDAOImpl;
import database_crud.entities.CompositeKey;
import database_crud.entities.WorksOn;

import java.sql.*;
import java.util.List;

public class WorksOnService {
    public List<WorksOn> findByJob(String job) throws SQLException {
        return new WorksOnDAOImpl().findByJob(job);
    }

    public List<WorksOn> findByDate(Date date) throws SQLException {
        return new WorksOnDAOImpl().findByDate(date);
    }

    public List<WorksOn> findAll() throws SQLException {
        return new WorksOnDAOImpl().findAll();
    }

    public int update(WorksOn entity) throws SQLException {
        return new WorksOnService().update(entity);
    }

    public int create(WorksOn entity) throws SQLException {
        return new WorksOnDAOImpl().create(entity);
    }

    public int delete(CompositeKey key) throws SQLException {
        return new WorksOnDAOImpl().delete(key);
    }


}
