package dao.custom;

import dao.CrudDAO;
import entity.User;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

public interface UserDAO extends CrudDAO<User,String> {
    List<User> getMatchingResults(String search) throws Exception;

    HashMap<String, String> getAllUserNPasswordMap() throws Exception;
}
