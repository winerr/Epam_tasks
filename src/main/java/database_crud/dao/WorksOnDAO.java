package database_crud.dao;

import database_crud.entities.CompositeKey;
import database_crud.entities.WorksOn;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

//необходимо разобраться с интом
public interface WorksOnDAO extends GeneralDAO<WorksOn, CompositeKey> {
    List<WorksOn> findByJob(String job) throws SQLException;
    List<WorksOn> findByDate(Date date) throws SQLException;
}
