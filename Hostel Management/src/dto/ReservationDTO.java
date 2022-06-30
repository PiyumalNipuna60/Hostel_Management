package dto;

import entity.Room;
import entity.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReservationDTO {
    private String resId;
    private LocalDate date;
    private StudentDTO student_id;
    private RoomDTO room_id;
    private String status;

    public ReservationDTO(String res_id, Date date, String student_id, String room_type_id, String status) {
    }
}
