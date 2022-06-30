package bo;


import bo.custom.impl.ReservationBOImpl;
import bo.custom.impl.RoomBOImpl;
import bo.custom.impl.StudentBOImpl;
import bo.custom.impl.UserBOImpl;

public class BOFactory {
    private static BOFactory boFactory;

    private BOFactory() {
    }

    public static BOFactory getBoFactory() {
        return boFactory == null ? boFactory = new BOFactory() : boFactory;
    }

    public SuperBO getBO(BOTypes types) {
        switch (types) {
            case STUDENT:
                return (SuperBO) new StudentBOImpl();
            case ROOM:
                return (SuperBO) new RoomBOImpl();
            case RESERVE:
                return (SuperBO) new ReservationBOImpl();
            case USER:
                return new UserBOImpl();
            default:
                return null;
        }
    }

    public enum BOTypes {
        STUDENT, ROOM, RESERVE, USER
    }
}
