package dao.custom;

import dao.CrudDAO;
import entity.Room;

import java.sql.SQLException;
import java.util.List;

public interface RoomDAO extends CrudDAO<Room, String> {
    public List<String> getRoomTypes() throws SQLException, ClassNotFoundException;

    public List<Room> getRoomId(String type) throws SQLException, ClassNotFoundException;
}
