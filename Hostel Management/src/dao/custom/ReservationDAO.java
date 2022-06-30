package dao.custom;

import dao.CrudDAO;
import entity.Reservation;
import entity.Room;

import java.sql.SQLException;
import java.util.List;

public interface ReservationDAO extends CrudDAO<Reservation ,String> {
    Reservation find(String s) throws Exception;

    List<Reservation> findAll() throws Exception;

    public String generateNewId()throws Exception;
}
