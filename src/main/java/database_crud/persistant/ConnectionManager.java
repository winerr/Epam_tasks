package database_crud.persistant;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionManager {
    private static String URL;
    private static String USER;
    private static String PASSWORD;

    private static Connection connection = null;

    static {
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream("src/main/resources/database.properties"));
            URL = properties.getProperty("databaseUrl");
            USER = properties.getProperty("databaseUser");
            PASSWORD = properties.getProperty("databasePassword");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ConnectionManager(){
    }

    public static Connection getConnection() {
        if(connection == null){
            try {
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
}
