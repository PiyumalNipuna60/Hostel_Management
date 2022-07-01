package bo.custom.impl;

import bo.custom.RegistrationBO;
import dao.DAOFactory;
import dao.custom.ReservationDAO;
import dao.custom.RoomDAO;
import dao.custom.StudentDAO;
import dto.ReservationDTO;
import dto.RoomDTO;
import dto.StudentDTO;
import entity.Reservation;
import entity.Room;
import entity.Student;
import  util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RegistrationBOImpl implements RegistrationBO {

    ReservationDAO resDAO = (ReservationDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.RESERVATION);
    StudentDAO stuDAO = (StudentDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.STUDENT);
    RoomDAO roomDAO = (RoomDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ROOM);

    @Override
    public String generateNewOrderID() throws SQLException, ClassNotFoundException {
        List<Reservation> res = resDAO.generateNewId();
        for (Reservation r : res) {
            if(r.getRes_id() != null){
                return String.format("RID%03d", (Integer.parseInt(r.getRes_id().replace("RID", "")) + 1));
            }else if (r.getRes_id() == null){
                 return "RID001";
            }
        }
        return "nooo";
    }

    @Override
    public boolean reserveRoom(StudentDTO stDTO, RoomDTO roomDTO, ReservationDTO resDTO) throws SQLException, ClassNotFoundException {
        Student s = new Student();
        s.setStudent_id(stDTO.getStudent_id());
        s.setName(stDTO.getName());
        s.setAddress(stDTO.getAddress());
        s.setContact_no(stDTO.getContact_no());
        s.setDob(stDTO.getDob());
        s.setGender(stDTO.getGender());

        Room r = new Room();
        r.setRoom_type_id(roomDTO.getRoom_type_id());
        r.setType(roomDTO.getType());
        r.setKey_money(roomDTO.getKey_money());
        List<Room> roomList = roomDAO.search(roomDTO.getRoom_type_id());
        int rQty = 0;
        for (Room room : roomList) {
            rQty= room.getQty();
        }
        r.setQty(rQty-roomDTO.getQty());

        Reservation res = new Reservation();
        res.setRes_id(resDTO.getRes_id());
        res.setDate(resDTO.getDate());
        res.setStatus(resDTO.getStatus());

        res.setStudent(s);
        res.setRoom(r);

        ArrayList<Reservation> resList = new ArrayList<>();
        resList.add(res);

        s.setReserveList(resList);
        r.setReserveList(resList);

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        boolean saveStudent = stuDAO.save(s);
        if(!saveStudent){
            transaction.rollback();
        }else{
            transaction.commit();
        }

        boolean saveRes = resDAO.save(res);
        if(!saveRes){
            transaction.rollback();
        }else {
            transaction.commit();
        }

        boolean saveRoom = roomDAO.update(r);
        if(!saveRoom){
            transaction.rollback();
        }else {
            transaction.commit();
        }


        transaction.commit();
        return true;

    }
}
