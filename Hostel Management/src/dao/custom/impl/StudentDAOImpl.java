package dao.custom.impl;

import dao.custom.StudentDAO;
import entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.FactoryConfiguration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl implements StudentDAO {
    @Override
    public boolean add(Student student) throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.save(student);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(String s) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        String id = s;
        String hql = " DELETE FROM Student WHERE student_id = :search_id";
        Query query = session.createQuery(hql);
        query.setParameter("search_id", id);
        int rowCount = query.executeUpdate();
        transaction.commit();
        session.close();
        return rowCount > 0 ? true : false;
    }

    @Override
    public boolean update(Student student) throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        String hql = "UPDATE Student SET name = :student_name , address = :address, contact = :contact_no, date = :date,gender = :gender WHERE student_id = :student_id";
        Query query = session.createQuery(hql);
        query.setParameter("student_name", student.getName());
        query.setParameter("address", student.getAddress());
        query.setParameter("contact_no", student.getContact());
        query.setParameter("date", student.getDate());
        query.setParameter("gender", student.getGender());
        query.setParameter("student_id" ,student.getStudent_id());
        int rowCount = query.executeUpdate();
        transaction.commit();
        session.close();
        return rowCount > 0 ? true : false;


    }

    @Override
    public Student search(String s) throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        String id = s;
        String hql = "FROM Student  WHERE student_id = :search_id";
        Query query = session.createQuery(hql);
        query.setParameter("search_id", id);
        List<Student> studentsList = query.list();
        for (Student student : studentsList) {
            return new Student(student.getStudent_id(),student.getName(),student.getAddress(),student.getContact(),student.getDate(),student.getGender());
        }
        transaction.commit();
        session.close();
        return null;

    }

    @Override
    public ArrayList<Student> getAll() throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        String hql = "FROM Student";
        Query query = session.createQuery(hql);
        List<Student> list = query.list();
        transaction.commit();
        session.close();
        return (ArrayList<Student>) list;
    }
//
//    public List<Student> findAll() throws Exception {
//        Session session = FactoryConfiguration.getInstance().getSession();
//        Transaction transaction = session.beginTransaction();
//        String hql = "FROM Student";
//        Query query = session.createQuery(hql);
//        List<Student> list = query.list();
//        transaction.commit();
//        session.close();
//        return list;
//    }


    @Override
    public List<Student> getMatchingResults(String search) throws Exception {
        return null;
    }
}

///////////////////////////////////////////////////

//    public boolean add(User dto) throws Exception {
//        return false;
//    }
//
//    @Override
//    public boolean update(User entity) throws Exception {
//        Session session = FactoryConfiguration.getInstance().getSession();
//        Transaction transaction = session.beginTransaction();
//
//        String hql = "UPDATE User SET password = : password ,userName = : userName WHERE userId = :userId";
//        Query query = session.createQuery(hql);
//        query.setParameter("password", entity.getPassword());
//        query.setParameter("userName", entity.getUserName());
//        query.setParameter("userId", entity.getUserId());
//        int rowCount = query.executeUpdate();
//        transaction.commit();
//        session.close();
//        return rowCount > 0 ? true : false;
//    }
//
//    @Override
//    public boolean delete(String s) throws Exception {
//        return false;
//    }
//
//    @Override
//    public User find(String s) throws Exception {
//        return null;
//    }
//
//    public String find(String userName, String password ) throws Exception {
//        Session session = FactoryConfiguration.getInstance().getSession();
//        Transaction transaction = session.beginTransaction();
//        String hql = "SELECT userId FROM User WHERE userName =:userName AND password =: password";
//        Query query = session.createQuery(hql);
//        query.setParameter("userName", userName);
//        query.setParameter("password", password);
//        List<String> list = query.list();
//        String id = null;
//        for (String s:list
//        ) {
//            id = s;
//        }
//        System.out.println("User id " +id);
//        return id;
//
//    }
//    @Override
//    public List<User> findAll() throws Exception {
//        return null;
//    }
//}
