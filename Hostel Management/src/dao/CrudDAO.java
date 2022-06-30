package dao;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CrudDAO<T,ID> extends SuperDAO{
    boolean add(T t) throws SQLException, ClassNotFoundException, Exception;

    boolean delete(ID id) throws SQLException, ClassNotFoundException, Exception;

    boolean update(T t) throws SQLException, ClassNotFoundException, Exception;

    T search(ID id) throws SQLException, ClassNotFoundException;

    ArrayList<T> getAll() throws SQLException, ClassNotFoundException;
}
