package database_crud.dao.implementation;

import database_crud.entities.metadata.ColumnMetaData;
import database_crud.entities.metadata.TableMetaData;
import database_crud.persistant.ConnectionManager;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MetaDataDAOImpl {
    public List<TableMetaData> getTableMetaData() throws SQLException {
        List<TableMetaData> tableMetaDataList = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection();
        DatabaseMetaData databaseMetaData = connection.getMetaData();

        String[] types = {"TABLE"};
        String dbName = connection.getCatalog();
        ResultSet resultSet = databaseMetaData.getTables(dbName, null, "%", types);

        while (resultSet.next()){
            TableMetaData tableMetaData = new TableMetaData();
            tableMetaData.setDataBaseName(dbName);
            tableMetaData.setTableName(resultSet.getString("TABLE_NAME"));

            List<String> pkList = new ArrayList<>();
            ResultSet PKs = databaseMetaData.getPrimaryKeys(connection.getCatalog(), null, resultSet.getString("TABLE_NAME"));
            while (PKs.next()) {
                pkList.add(PKs.getString("COLUMN_NAME"));
            }

            List<ColumnMetaData> columnsMetaData = new ArrayList<>();
            ResultSet columnResultSet = databaseMetaData.getColumns(dbName, null, resultSet.getString("TABLE_NAME"), "%");
            while (columnResultSet.next()){
                ColumnMetaData columnMetaData = new ColumnMetaData();
                columnMetaData.setColumnName(columnResultSet.getString("COLUMN_NAME"));
                columnMetaData.setColumnSize(columnResultSet.getString("COLUMN_SIZE"));
                columnMetaData.setDataType(columnResultSet.getString("TYPE_NAME"));
                columnMetaData.setNullable(columnResultSet.getString("IS_NULLABLE").equals("YES"));
                columnMetaData.setAutoincrement(columnResultSet.getString("IS_AUTOINCREMENT").equals("IS_AUTOINCREMENT"));

                columnMetaData.setPk(false);
                for (String pkName: pkList){
                    if (columnMetaData.getColumnName().equals(pkName)) {
                        columnMetaData.setPk(true);
                        break;
                    }
                }
                columnsMetaData.add(columnMetaData);
            }
            tableMetaData.setColumnsMetaData(columnsMetaData);
            tableMetaDataList.add(tableMetaData);
        }
        return tableMetaDataList;
    }

}
