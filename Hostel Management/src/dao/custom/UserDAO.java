package dao.custom;

import dao.CrudDAO;
import entity.User;

import java.sql.SQLException;

public interface UserDAO extends CrudDAO<User, String> {
    public boolean updateUname(User entity) throws SQLException, ClassNotFoundException;
}
