package dao.custom;

import dao.CrudDAO;
import entity.Room;

import java.sql.SQLException;
import java.util.List;

public interface RoomDAO extends CrudDAO <Room,String>{
    Room find(String s) throws Exception;

    List<Room> findAll() throws Exception;

    public List<String> getAllRoomIds() throws Exception;
    public boolean addNewRoomType(String id, int qty);
}
