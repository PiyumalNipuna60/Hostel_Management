package bo.custom.impl;

import bo.custom.RoomBO;
import dao.DAOFactory;
import dao.custom.RoomDAO;
import dto.RoomDTO;
import entity.Room;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoomBOImpl implements RoomBO {

    RoomDAO roomDAO = (RoomDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ROOM);

    @Override
    public boolean saveRooms(RoomDTO dto) throws SQLException, ClassNotFoundException {
        return roomDAO.save(new Room(dto.getRoom_type_id(),dto.getType(), dto.getKey_money(), dto.getQty()));
    }

    @Override
    public boolean updateRooms(RoomDTO dto) throws SQLException, ClassNotFoundException {
       return roomDAO.update(new Room(dto.getRoom_type_id(),dto.getType(), dto.getKey_money(), dto.getQty()));
    }

    @Override
    public List<RoomDTO> getAllRooms() throws SQLException, ClassNotFoundException {
        List<Room> roomList = roomDAO.getAll();
        List<RoomDTO> dtoList= new ArrayList<>();

        for (Room room : roomList) {
            dtoList.add(new RoomDTO(room.getRoom_type_id(), room.getType(), room.getKey_money(), room.getQty()));
        }
        return dtoList;
    }

    @Override
    public boolean deleteRoom(String typeId) throws SQLException, ClassNotFoundException {
        return roomDAO.delete(typeId);
    }

    @Override
    public List<String> getRoomTypes() throws SQLException, ClassNotFoundException {
        List<String> roomTypes = roomDAO.getRoomTypes();
        return roomTypes;
    }

    @Override
    public List<RoomDTO> getRoomId(String type) throws SQLException, ClassNotFoundException {
        List<Room> roomList = roomDAO.getRoomId(type);
        List<RoomDTO> list = new ArrayList<>();
        for (Room r : roomList) {
            list.add(new RoomDTO(r.getRoom_type_id(),r.getType(),r.getKey_money(),r.getQty()));
        }
        return list;
    }
}
