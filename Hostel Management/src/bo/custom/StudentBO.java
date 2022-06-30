package bo.custom;


import bo.SuperBO;
import dto.StudentDTO;
import entity.Student;

import java.util.ArrayList;
import java.util.List;

public interface StudentBO extends SuperBO {
    public boolean addStudent(StudentDTO studentDTO) throws Exception;

    public boolean updateStudent(StudentDTO studentDTO) throws Exception;

    public boolean deleteStudent(String id) throws Exception;

    public StudentDTO searchStudent(String id) throws Exception;

    public List<StudentDTO> LoadAllStudent() throws Exception;

    public ArrayList<Student> getAllStudentIds() throws Exception;
}
