package dao.custom;

import dao.CrudDAO;
import entity.Student;

import java.sql.SQLException;
import java.util.List;

public interface StudentDAO extends CrudDAO<Student,String> {
    public List<Student> getMatchingResults(String search) throws Exception;
}
