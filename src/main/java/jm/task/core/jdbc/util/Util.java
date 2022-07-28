package jm.task.core.jdbc.util;

import com.mysql.cj.xdevapi.SessionFactory;
import jdk.jfr.Configuration;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;

import javax.imageio.spi.ServiceRegistry;
import java.net.spi.InetAddressResolverProvider;
import java.sql.*;
import java.util.Properties;

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

//        SessionFactory sessionFactory = new Configuration().builtinSessionFactory();
//
//
//        sessionFactory.close();