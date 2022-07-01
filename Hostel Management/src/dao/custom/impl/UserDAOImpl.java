package dao.custom.impl;

import dao.custom.UserDAO;
import entity.User;
import util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;

public class UserDAOImpl implements UserDAO {
    @Override
    public List<User> getAll() throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        String hql = "FROM User";
        List<User> userList = session.createQuery(hql).list();

        transaction.commit();
        session.close();
        return userList;
    }

    @Override
    public boolean save(User entity) throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.save(entity);

        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(User entity) throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.update(entity);

        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public List<User> search(String s) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean exist(String s) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String userNme) throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        User user = session.load(User.class, userNme);
        session.delete(user);

        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public List<User> generateNewId() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean updateUname(User entity) throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        String newUName = entity.getUser_name();
        String pwd = entity.getPassword();
        String hql = "UPDATE User SET user_name = :uName WHERE password = :pswd";
        Query query = session.createQuery(hql);
        query.setParameter("uName", newUName);
        query.setParameter("pswd", pwd);

        transaction.commit();
        session.close();
        return true;
    }
}
