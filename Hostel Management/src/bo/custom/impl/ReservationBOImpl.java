package bo.custom.impl;



import bo.custom.ReservationBO;
import dao.DAOFactory;
import dao.custom.impl.ReservationDAOImpl;
import dto.ReservationDTO;
import entity.Reservation;
import entity.Room;
import entity.Student;

import java.util.ArrayList;
import java.util.List;

public class ReservationBOImpl implements ReservationBO {
    private final ReservationDAOImpl reservationDAO = (ReservationDAOImpl) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.RESERVATION);

    @Override
    public boolean addReservation(ReservationDTO reserveDTO) throws Exception {
        return reservationDAO.add(new Reservation(reserveDTO.getResId(), reserveDTO.getDate(), new Student(reserveDTO.getStudent_id()), new Room(reserveDTO.getRoom_id()), reserveDTO.getStatus()));
    }

    @Override
    public boolean updateReservation(ReservationDTO reserveDTO) throws Exception {
        return reservationDAO.update(new Reservation(reserveDTO.getResId(), reserveDTO.getDate(), new Student(reserveDTO.getStudent_id()), new Room(reserveDTO.getRoom_id()), reserveDTO.getStatus()));
    }

    @Override
    public boolean deleteReservation(String id) throws Exception {
        return reservationDAO.delete(id);
    }

    @Override
    public ReservationDTO searchReservation(String id) throws Exception {
        return null;
    }

    @Override
    public String generateReservationNewID() throws Exception {
        return reservationDAO.generateNewId();
    }

    @Override
    public List<ReservationDTO> LoadAllReservation() throws Exception {
        List<Reservation> list = reservationDAO.findAll();
        List<ReservationDTO> reserveList = new ArrayList<>();
        for (Reservation r : list
        ) {
            Student s1 =new Student(r.getStudent_id());
            Room r1 = new Room(r.getRoom_type_id());
            System.out.println("StudentId"+s1.getStudent_id());
            reserveList.add(new ReservationDTO(r.getRes_id(), r.getDate(),s1.getStudent_id() ,r1.getRoom_type_id(), r.getStatus()));

        }
        return reserveList;
    }
}
