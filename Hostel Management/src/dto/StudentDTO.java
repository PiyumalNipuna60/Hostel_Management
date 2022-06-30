package dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentDTO {
    private String StudentId;
    private String name;
    private String address;
    private String ContactNo;
    private LocalDate dob;
    private String gender;

    public StudentDTO(String student_id, String name, String address, String contact, Date date, String gender) {
    }
}
