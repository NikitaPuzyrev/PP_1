package jm.task.core.jdbc.dao;

//import jm.task.core.jdbc.model.User;

import jm.task.core.jdbc.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static jm.task.core.jdbc.util.Util.getConnect;

public class UserDaoJDBCImpl implements UserDao {
    private String name;
    private String lastName;
    private Byte age;
    User user = new User();
    List<User> list = new ArrayList<>();

    public UserDaoJDBCImpl() {
    }

/*    public UserDaoJDBCImpl(String name, String lastName, Byte age) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }*/


    public void createUsersTable() throws SQLException {
        Connection connection = getConnect();
        String sqlCommand = "CREATE TABLE IF NOT EXISTS Users (Id INT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(50), lastName VARCHAR(50), age INT )";
        Statement statement = connection.createStatement();
        statement.executeUpdate(sqlCommand);
        statement.close();
        connection.close();
    }


    public void dropUsersTable() throws SQLException {
        Connection connection = getConnect();
        String sqlCommand = "DROP TABLE IF EXISTS Users";
        Statement statement = connection.createStatement();
        statement.executeUpdate(sqlCommand);
        statement.close();
        connection.close();


    }

    public void saveUser(String name, String lastName, byte age) throws SQLException {
        System.out.println(name + " " + lastName + " " + age);
        String sqlCommand = "CREATE TABLE IF NOT EXISTS Users (Id INT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(50), lastName VARCHAR(50), age INT )";
        String n = name.toString();
        String l = lastName.toString();
        int a = age;
        String sqlCommand1 = "INSERT Users (id, name, lastName, age) VALUES (?, ?, ?, ?)";
        Connection connection = getConnect();
    //    Statement statement = connection.createStatement();


        PreparedStatement ps = connection.prepareStatement(sqlCommand1);
        ps.setString(1, null);
        ps.setString(2, n);
        ps.setString(3, l);
        ps.setString(4, String.valueOf(age));
        ps.executeUpdate();
        System.out.printf("User with name %s added to database."+"\n",n);
   //     statement.close();
        ps.close();
        connection.close();

    }

    public void removeUserById(long id) throws SQLException {


        String sqlCommand = "DELETE FROM Users WHERE Id = ?";
        Connection connection = getConnect();
        PreparedStatement ps = connection.prepareStatement(sqlCommand);
        ps.setLong(1, id);
        ps.executeUpdate();
        ps.close();
        connection.close();
    }

    public List<User> getAllUsers() throws SQLException {
        Connection connection = getConnect();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM Users");
        while (resultSet.next()) {

            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            String lastname = resultSet.getString(3);
            int age = resultSet.getInt(4);
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
        Statement statement = connection.createStatement();
        statement.executeUpdate(sqlCommand);
        statement.close();
        connection.close();
    }
}




