package dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoomDTO {
    private String room_type_id;
    private String type;
    private String key_money;
    private int qty;

    public RoomDTO(String room_type_id, String type, String key_money) {
        this.room_type_id = room_type_id;
        this.type = type;
        this.key_money = key_money;
    }
}
