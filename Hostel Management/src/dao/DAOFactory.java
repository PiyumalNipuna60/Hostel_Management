package dao;

import dao.custom.impl.*;

public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory(){
    }

    public static DAOFactory getDaoFactory(){
        return (daoFactory==null) ? daoFactory=new DAOFactory() : daoFactory;
    }

    public enum DAOTypes{
        USER, STUDENT, ROOM, RESERVATION, QUEERYDAO
    }

    public SuperDAO getDAO(DAOTypes types){
        switch (types) {
            case USER:
                return new UserDAOImpl();
            case STUDENT:
                return new StudentDAOImpl();
            case ROOM:
                return new RoomDAOImpl();
            case RESERVATION:
                return new ReservationDAOImpl();
            case QUEERYDAO:
                return new QueryDAOImpl();
            default:
                return null;
        }
    }

}
