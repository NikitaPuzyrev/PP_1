package jm.task.core.jdbc;


import java.sql.*;

import com.mysql.cj.jdbc.StatementImpl;
import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.HibernateUtil;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;


public class Main {


    public static void main(String[] args) throws SQLException {

        UserDao userDao = new UserDaoJDBCImpl();


        userDao.createUsersTable();
        userDao.saveUser(" Un1 ", "Ul1 ", (byte) 20);
        userDao.saveUser(" Un ", "Ul ", (byte) 28);
        userDao.saveUser(" Un3 ", "Ul3 ", (byte) 27);
        userDao.saveUser(" Un4 ", "Ul4 ", (byte) 42);
       // userDao.removeUserById(2);
        userDao.getAllUsers();
        userDao.cleanUsersTable();
        userDao.dropUsersTable();



    }
}

