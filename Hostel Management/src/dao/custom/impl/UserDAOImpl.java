package dao.custom.impl;

import dao.custom.UserDAO;
import entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.FactoryConfiguration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UserDAOImpl implements UserDAO{
    @Override
    public boolean add(User user) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException, Exception {
        return false;
    }

    @Override
    public boolean update(User user) throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        String hql = "UPDATE User SET password = : password ,userName = : userName WHERE id = :userId";
        Query query = session.createQuery(hql);
        query.setParameter("password", user.getPassword());
        query.setParameter("userName", user.getUserName());
        query.setParameter("userId", user.getId());
        int rowCount = query.executeUpdate();
        transaction.commit();
        session.close();
        return rowCount > 0 ? true : false;
    }

    @Override
    public User search(String s) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<User> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public List<User> getMatchingResults(String search) throws Exception {
        return null;
    }

    @Override
    public HashMap<String, String> getAllUserNPasswordMap() throws Exception {
        return null;
    }

    public String find(String userName, String password ) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        String hql = "SELECT id FROM User WHERE userName =:userName AND password =: password";
        Query query = session.createQuery(hql);
        query.setParameter("userName", userName);
        query.setParameter("password", password);
        List<String> list = query.list();
        String id = null;
        for (String s:list
        ) {
            id = s;
        }
        System.out.println("User id " +id);
        return id;

    }
}

