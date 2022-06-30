package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDate;
import java.util.Date;
@AllArgsConstructor
@Data
@NoArgsConstructor
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Entity
public class Reservation {
    @Id
    String res_id;
    Date date;
    String status;

    @ManyToOne
    Room room_type_id;

    @ManyToOne
    Student student_id;

    public Reservation(String resId, LocalDate date, Student student, Room room_type_id, String status) {
    }

    public String getRes_id() {
        return res_id;
    }

    public void setRes_id(String res_id) {
        this.res_id = res_id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Room getRoom_type_id() {
        return room_type_id;
    }

    public void setRoom_type_id(Room room_type_id) {
        this.room_type_id = room_type_id;
    }

    public Student getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Student student_id) {
        this.student_id = student_id;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "res_id='" + res_id + '\'' +
                ", date=" + date +
                ", status='" + status + '\'' +
                ", room_type_id=" + room_type_id +
                ", student_id=" + student_id +
                '}';
    }
}
