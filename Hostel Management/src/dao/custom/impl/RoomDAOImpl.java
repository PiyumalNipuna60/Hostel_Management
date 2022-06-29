package dao.custom.impl;

import dao.custom.RoomDAO;
import entity.Room;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoomDAOImpl implements RoomDAO {
    @Override
    public boolean add(Room room) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException, Exception {
        return false;
    }

    @Override
    public boolean update(Room room) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public Room search(String s) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<Room> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean save(Room entity) throws ClassNotFoundException, SQLException {
        return false;
    }

    @Override
    public Room get(String s) throws Exception {
        return null;
    }

    @Override
    public List<Room> getMatchingResults(String search) {
        return null;
    }
}
