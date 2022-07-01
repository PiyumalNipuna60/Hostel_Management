package dao;

import java.sql.SQLException;
import java.util.List;

public interface CrudDAO<T, ID> extends SuperDAO{
    public List<T> getAll() throws SQLException, ClassNotFoundException;

    public boolean save(T entity) throws SQLException, ClassNotFoundException;

    public boolean update(T entity) throws SQLException, ClassNotFoundException;

    public List<T> search(ID id) throws SQLException, ClassNotFoundException;

    public boolean exist(ID id) throws SQLException, ClassNotFoundException;

    public boolean delete(ID id) throws SQLException, ClassNotFoundException;

    public List<T> generateNewId() throws SQLException, ClassNotFoundException;
}
