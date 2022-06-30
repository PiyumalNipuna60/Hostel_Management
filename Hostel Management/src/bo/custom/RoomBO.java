package bo.custom;



import bo.SuperBO;
import dto.RoomDTO;

import java.util.List;

public interface RoomBO extends SuperBO {
    public boolean addRoom(RoomDTO roomDTO) throws Exception;

    public boolean updateRoom(RoomDTO roomDTO) throws Exception;

    public boolean deleteRoom(String id) throws Exception;

    public RoomDTO searchRoom(String id) throws Exception;

    public List<RoomDTO> LoadAllRoom() throws Exception;

    public List<String> getAllRoomIds() throws Exception;

    public boolean AddNewRoomType(String id ,int qty) throws Exception;

}
