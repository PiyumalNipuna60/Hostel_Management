package entity;

import dto.RoomDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Data
@Entity
public class Room {
    @Id
    String room_type_id;
    String type;
    String key_money;
    int qty;

    @OneToMany(mappedBy = "room_type_id")
    List<Reservation> reservation_list=new ArrayList();

    public Room(String room_type_id, String type, String key_money, int qty) {
    }

    public Room(RoomDTO room_id) {
    }

    public Room(Room room_type_id) {
    }


    public String getRoom_type_id() {
        return room_type_id;
    }

    public void setRoom_type_id(String room_type_id) {
        this.room_type_id = room_type_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getKey_money() {
        return key_money;
    }

    public void setKey_money(String key_money) {
        this.key_money = key_money;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public List<Reservation> getReservation_list() {
        return reservation_list;
    }

    public void setReservation_list(List<Reservation> reservation_list) {
        this.reservation_list = reservation_list;
    }

    @Override
    public String toString() {
        return "Room{" +
                "room_type_id='" + room_type_id + '\'' +
                ", type='" + type + '\'' +
                ", key_money='" + key_money + '\'' +
                ", qty=" + qty +
                ", reservation_list=" + reservation_list +
                '}';
    }
}


