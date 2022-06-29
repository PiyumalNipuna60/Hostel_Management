package dao.custom;

import dao.CrudDAO;
import entity.Room;

import java.sql.SQLException;
import java.util.List;

public interface RoomDAO extends CrudDAO<Room,String> {
    boolean save(Room entity) throws ClassNotFoundException, SQLException;

    Room get(String s) throws Exception;

    List<Room> getMatchingResults(String search);
}
