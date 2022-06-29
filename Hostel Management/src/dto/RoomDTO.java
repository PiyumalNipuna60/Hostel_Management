package dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.beans.ConstructorProperties;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RoomDTO {
    private String room_Type_id;
    private String type;
    private String key_money;
    private int qty;
}
