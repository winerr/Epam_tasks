package database_crud.services;

import database_crud.dao.implementation.MetaDataDAOImpl;
import database_crud.entities.metadata.TableMetaData;

import java.sql.SQLException;
import java.util.List;

public class MetaDataService {
    public List<TableMetaData> getTableMetaData() throws SQLException {
        return new MetaDataDAOImpl().getTableMetaData();
    }
}
