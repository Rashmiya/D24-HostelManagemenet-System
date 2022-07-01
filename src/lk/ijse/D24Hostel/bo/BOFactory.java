package lk.ijse.D24Hostel.bo;

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
