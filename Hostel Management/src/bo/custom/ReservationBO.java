package bo.custom;


import bo.SuperBO;
import dto.ReservationDTO;

import java.util.List;

public interface ReservationBO extends SuperBO {
    public boolean addReservation(ReservationDTO reserveDTO) throws Exception;

    public boolean updateReservation(ReservationDTO reserveDTO) throws Exception;

    public boolean deleteReservation(String id) throws Exception;

    public ReservationDTO searchReservation(String id) throws Exception;

    public String generateReservationNewID()throws Exception;

    public List<ReservationDTO> LoadAllReservation() throws Exception;
}
