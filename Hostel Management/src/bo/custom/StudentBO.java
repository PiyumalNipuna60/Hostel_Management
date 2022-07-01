package bo.custom;

import bo.SuperBO;
import dto.StudentDTO;

import java.sql.SQLException;
import java.util.List;

public interface StudentBO extends SuperBO {
    public List<StudentDTO> getAllStudents() throws SQLException, ClassNotFoundException;

    public boolean deleteStudent(String sId) throws SQLException, ClassNotFoundException;

    boolean updateStudent(StudentDTO dto) throws SQLException, ClassNotFoundException;
}
