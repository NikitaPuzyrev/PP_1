package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static jm.task.core.jdbc.util.Util.getConnect;

public class UserDaoJDBCImpl implements UserDao {

    User user = new User();
    List<User> list = new ArrayList<>();


    public UserDaoJDBCImpl() {
    }

    public void createUsersTable() throws SQLException {
        Connection connection = getConnect();
        connection.setAutoCommit(false);
        String sqlCommand = "CREATE TABLE IF NOT EXISTS Users (Id INT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(50), lastName VARCHAR(50), age INT )";
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sqlCommand);
            connection.commit();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Create UsersTable error");
            if (connection != null) {
                try {
                    System.err.print("Transaction is being rolled back");
                    connection.rollback();
                } catch (SQLException ignored) {
                }
            }
        }
    }

    public void dropUsersTable() throws SQLException {
        Connection connection = getConnect();
        connection.setAutoCommit(false);
        String sqlCommand = "DROP TABLE IF EXISTS Users";
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sqlCommand);
            connection.commit();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Drop UsersTable error");
            if (connection != null) {
                try {
                    System.err.print("Transaction is being rolled back");
                    connection.rollback();
                } catch (SQLException ignored) {
                }
            }
        }
    }

    public void saveUser(String name, String lastName, byte age) throws SQLException {
        String sqlCommand = "CREATE TABLE IF NOT EXISTS Users (Id INT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(50), lastName VARCHAR(50), age INT )";
           String sqlCommand1 = "INSERT Users (id, name, lastName, age) VALUES (?, ?, ?, ?)";
        Connection connection = getConnect();
        connection.setAutoCommit(false);
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sqlCommand);

            PreparedStatement ps = connection.prepareStatement(sqlCommand1);
            ps.setString(1, null);
            ps.setString(2, name);
            ps.setString(3, lastName);
            ps.setString(4, String.valueOf(age));
            ps.executeUpdate();
            System.out.printf("User with name %s added to database." + "\n", name);
            connection.commit();
            statement.close();
            ps.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("SaveUser error");
            if (connection != null) {
                try {
                    System.err.print("Transaction is being rolled back");
                    connection.rollback();
                } catch (SQLException ignored) {
                }
            }
        }
    }

    public void removeUserById(long id) throws SQLException {
        String sqlCommand = "DELETE FROM Users WHERE Id = ?";
        Connection connection = getConnect();
        connection.setAutoCommit(false);
        try {
            PreparedStatement ps = connection.prepareStatement(sqlCommand);
            ps.setLong(1, id);
            ps.executeUpdate();
            connection.commit();
            ps.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("DelateUser error");
            if (connection != null) {
                try {
                    System.err.print("Transaction is being rolled back");
                    connection.rollback();
                } catch (SQLException ignored) {
                }
            }
        }
    }

    public List<User> getAllUsers() throws SQLException {
        Connection connection = getConnect();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM Users");
        while (resultSet.next()) {
            user.setId((long) resultSet.getInt(1));
            user.setName(resultSet.getString(2));
            user.setLastName(resultSet.getString(3));
            user.setAge((byte) resultSet.getInt(4));
            System.out.println(user);
            list.add(user);
        }
        statement.close();
        connection.close();
        return list;
    }

    public void cleanUsersTable() throws SQLException {

        String sqlCommand = "TRUNCATE Users";
        Connection connection = getConnect();
        connection.setAutoCommit(false);
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sqlCommand);
            connection.commit();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Clean UsersTable error");
            if (connection != null) {
                try {
                    System.err.print("Transaction is being rolled back");
                    connection.rollback();
                } catch (SQLException ignored) {
                }
            }
        }
    }
}




