package dao.custom.impl;

import dao.custom.UserDAO;
import entity.User;

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
        return false;
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
}
