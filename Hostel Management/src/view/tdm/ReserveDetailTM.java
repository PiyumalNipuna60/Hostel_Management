package view.tdm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReserveDetailTM {
    String student_id;
    String room_type_id;
    String status;
}