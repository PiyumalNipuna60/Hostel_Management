package entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Student {
    @Id
    String student_id;
    String name;
    String address;
    String contact;
    Date date;
    String gender;

    @OneToMany(mappedBy = "student_id")
    List<Reservation> reservation_list=new ArrayList();

    public Student() {
    }

    public Student(String student_id, String name, String address, String contact, Date date, String gender, List<Reservation> reservation_list) {
        this.student_id = student_id;
        this.name = name;
        this.address = address;
        this.contact = contact;
        this.date = date;
        this.gender = gender;
        this.reservation_list = reservation_list;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<Reservation> getReservation_list() {
        return reservation_list;
    }

    public void setReservation_list(List<Reservation> reservation_list) {
        this.reservation_list = reservation_list;
    }

    @Override
    public String toString() {
        return "Student{" +
                "student_id='" + student_id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", contact='" + contact + '\'' +
                ", date=" + date +
                ", gender='" + gender + '\'' +
                ", reservation_list=" + reservation_list +
                '}';
    }
}
