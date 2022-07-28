package jm.task.core.jdbc.service;

//import jm.task.core.jdbc.model.User;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {

    UserDao userDao  = new UserDaoJDBCImpl();


    public void createUsersTable() throws SQLException {
        userDao.createUsersTable();
    }

    public void dropUsersTable() throws SQLException {
        userDao.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) throws SQLException {
        System.out.println(name);
        userDao.saveUser(name, lastName, age);
    }

    public void removeUserById(long id) throws SQLException {
        userDao.removeUserById(id);
    }
    public List<User> getAllUsers() {
        try {
            return userDao.getAllUsers();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void cleanUsersTable() throws SQLException {
        userDao.cleanUsersTable();
    }
}

