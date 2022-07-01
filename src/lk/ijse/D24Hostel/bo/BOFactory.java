package lk.ijse.D24Hostel.bo;

import lk.ijse.D24Hostel.bo.impl.ReservationBOImpl;
import lk.ijse.D24Hostel.bo.impl.RoomBOImpl;
import lk.ijse.D24Hostel.bo.impl.StudentBOImpl;
import lk.ijse.D24Hostel.bo.impl.UserBOImpl;

public class BOFactory {
    private static BOFactory boFactory;

    private BOFactory(){}

    public static BOFactory getInstance(){
        return (null == boFactory) ? boFactory = new BOFactory() : boFactory;
    }

    public enum BOTypes{
        STUDENT, ROOM, RESERVATION, USER
    }
    public SuperBO getBO(BOTypes types){
        switch (types){
            case STUDENT:
                return new StudentBOImpl();
            case ROOM:
                return new RoomBOImpl();
            case RESERVATION:
                return new ReservationBOImpl();
            case USER:
                return new UserBOImpl();
            default:
                return null;
        }
    }
}
