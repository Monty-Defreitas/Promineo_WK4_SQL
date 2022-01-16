package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private final static String URL = "jdbc:mysql://localhost:3306/{ }";// insert database/schema name { }
    private final static String USERNAME = ""; //Enter SQL username
    private final static String PASSWORD = ""; //Enter SQL password
    private static Connection connection;
    private static DBConnection instance;

    private  DBConnection(Connection connection){
            DBConnection.connection = connection;
    }

    public static Connection initializeConnection() {
        if (instance == null) {
            try {
                connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
                instance = new DBConnection(connection);
                System.out.println("Connection Established");
            } catch (SQLException e) {
                e.printStackTrace();

            }
        }
        return DBConnection.connection;
    }
}
