package jm.task.core.jdbc.util;

import java.sql.*;

public class Util {
    private static final String USERNAME = "Nikita";
    private static final String PASSWORD = "Nikita";
    private static String URLFIXED = "jdbc:mysql://localhost:3306/mybase";
    private String base;

    public static Connection getConnect() {

        Connection connection;
        try {
            connection = DriverManager.getConnection(URLFIXED, USERNAME, PASSWORD);
            if (!connection.isClosed())
                System.out.println("Good connect");
            return connection;
        } catch (SQLException e) {
            System.out.println("getConnect error");
            return null;
        }
    }
 /*   void connectClose(Connection connection) {
        try {
            connection.close();
            if (connection.isClosed())
                System.out.println("connect is closed");
        } catch (SQLException e) {
            System.out.println("connectClose error");
        }
    }*/
}