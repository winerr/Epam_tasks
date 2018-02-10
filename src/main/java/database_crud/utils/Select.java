package database_crud.utils;

import database_crud.transformer.Transformer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class Select {
    public static <T>T getResult(String data, Connection connection, String select, Class<T> resultClass) throws SQLException {
        T result = null;
        try(PreparedStatement statement = connection.prepareStatement(select)) {
            statement.setString(1, data);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    result = new Transformer<>(resultClass).fromResultSetToEntity(resultSet);
                    return result;
                } else {
                    return null;
                }
            }
        }
    }


    public static <T>void getResult(String data, Connection connection, String select, List<T> result, Class<T> resultClass) throws SQLException {
        try(PreparedStatement statement = connection.prepareStatement(select)){
            statement.setString(1, data);
            try(ResultSet resultSet = statement.executeQuery() ) {
                while (resultSet.next()){
                    result.add( new Transformer<>(resultClass).fromResultSetToEntity(resultSet));
                }
            }
        }
    }

}
