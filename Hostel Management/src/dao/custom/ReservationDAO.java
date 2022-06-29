package dao.custom;

import dao.CrudDAO;
import entity.Reservation;
import entity.Room;

import java.sql.SQLException;
import java.util.List;

public interface ReservationDAO extends CrudDAO<Reservation,String> {
    boolean save(Reservation entity) throws ClassNotFoundException, SQLException;

    List<Reservation> getMatchingResults(String search);

    String getReservationId() throws Exception;
}
