package view.tdm;

import com.jfoenix.controls.JFXButton;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class KeyPaymentTM {
    private String resId;
    private String status;
    private String room_Type_id;
    private String type;
    private String StudentId;
    private String name;
    private JFXButton btn;

}
