package bo.custom;

import bo.SuperBO;
import dto.RoomDTO;

import java.sql.SQLException;
import java.util.List;

public interface RoomBO extends SuperBO {

    public boolean saveRooms(RoomDTO dto) throws SQLException, ClassNotFoundException;

    public boolean updateRooms(RoomDTO dto) throws SQLException, ClassNotFoundException;

    public List<RoomDTO> getAllRooms() throws SQLException, ClassNotFoundException;

    public boolean deleteRoom(String typeId) throws SQLException, ClassNotFoundException;

    public List<String> getRoomTypes() throws SQLException,ClassNotFoundException;

    public List<RoomDTO> getRoomId(String type) throws SQLException,ClassNotFoundException;
}
