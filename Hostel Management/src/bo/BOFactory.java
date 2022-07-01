package bo;

import bo.custom.impl.RegistrationBOImpl;
import bo.custom.impl.RoomBOImpl;
import bo.custom.impl.StudentBOImpl;
import bo.custom.impl.UserBOImpl;

public class BOFactory {
    private static BOFactory boFactory;

    private BOFactory(){
    }

    public static BOFactory getBoFactory(){
        return (boFactory==null) ? boFactory=new BOFactory() : boFactory;
    }

    public enum BOTypes{
        USER, STUDENT, ROOM, REGISTRATION
    }

    public SuperBO getBO(BOTypes types){
        switch (types){
            case USER:
                return new UserBOImpl();
            case STUDENT:
                return new StudentBOImpl();
            case ROOM:
                return new RoomBOImpl();
            case REGISTRATION:
                return new RegistrationBOImpl();
            default:
                return null;
        }
    }

}
