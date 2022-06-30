package bo.custom.impl;



import bo.custom.StudentBO;
import dao.DAOFactory;
import dao.custom.impl.StudentDAOImpl;
import dto.StudentDTO;
import entity.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentBOImpl implements StudentBO {
    private final StudentDAOImpl studentDAO = (StudentDAOImpl) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.STUDENT);
    @Override
    public boolean addStudent(StudentDTO studentDTO) throws Exception {
        return studentDAO.add(new Student(studentDTO.getStudentId(),studentDTO.getName(),studentDTO.getAddress(),studentDTO.getContactNo(),studentDTO.getDob(),studentDTO.getGender()));
    }

    @Override
    public boolean updateStudent(StudentDTO studentDTO) throws Exception {
        return studentDAO.update(new Student(studentDTO.getStudentId(),studentDTO.getName(),studentDTO.getAddress(),studentDTO.getContactNo(),studentDTO.getDob(),studentDTO.getGender()));

    }

    @Override
    public boolean deleteStudent(String id) throws Exception {
        return studentDAO.delete(id);
    }

    @Override
    public StudentDTO searchStudent(String id) throws Exception {
        Student student =studentDAO.search(id);
        return new StudentDTO(student.getStudent_id(),student.getName(),student.getAddress(),student.getContact(),student.getDate(),student.getGender());
    }

    @Override
    public List<StudentDTO> LoadAllStudent() throws Exception {
        List<StudentDTO>studentDTOList =new ArrayList<>();
        List<Student>list = studentDAO.getAll();
        for (Student s:list
             ) {
             studentDTOList.add(new StudentDTO(s.getStudent_id(),s.getName(),s.getAddress(),s.getContact(),s.getDate(),s.getGender()));

        }
        return studentDTOList;
    }

    @Override
    public ArrayList<Student> getAllStudentIds() throws Exception {
        ArrayList<Student> list = studentDAO.getAll();
        return list;
    }
}
