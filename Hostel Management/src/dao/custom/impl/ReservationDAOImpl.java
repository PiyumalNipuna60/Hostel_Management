package dao.custom.impl;

import dao.custom.ReservationDAO;
import entity.Reservation;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReservationDAOImpl implements ReservationDAO {
    @Override
    public boolean add(Reservation reservation) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException, Exception {
        return false;
    }

    @Override
    public boolean update(Reservation reservation) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public Reservation search(String s) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<Reservation> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean save(Reservation entity) throws ClassNotFoundException, SQLException {
        return false;
    }

    @Override
    public List<Reservation> getMatchingResults(String search) {
        return null;
    }

    @Override
    public String getReservationId() throws Exception {
        return null;
    }
}
