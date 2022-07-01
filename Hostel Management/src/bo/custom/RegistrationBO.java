package bo.custom;

import bo.SuperBO;
import dto.ReservationDTO;
import dto.RoomDTO;
import dto.StudentDTO;

import java.sql.SQLException;

public interface RegistrationBO extends SuperBO {
    public String generateNewOrderID() throws SQLException, ClassNotFoundException;

    public boolean reserveRoom(StudentDTO stDTO, RoomDTO roomDTO, ReservationDTO resDTO) throws SQLException, ClassNotFoundException;
}
