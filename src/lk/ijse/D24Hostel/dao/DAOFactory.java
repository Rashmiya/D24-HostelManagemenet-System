package lk.ijse.D24Hostel.dao;

import lk.ijse.D24Hostel.bo.BOFactory;
import lk.ijse.D24Hostel.bo.SuperBO;
import lk.ijse.D24Hostel.dao.impl.ReservationDAOImpl;
import lk.ijse.D24Hostel.dao.impl.RoomDAOImpl;
import lk.ijse.D24Hostel.dao.impl.StudentDAOImpl;
import lk.ijse.D24Hostel.dao.impl.UserDAOImpl;

public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory(){}

    public static DAOFactory getInstance(){
        return (null == daoFactory) ? daoFactory = new DAOFactory() : daoFactory;
    }

    public enum DAOType {
        STUDENT,ROOM,RESERVATION,USER
    }
    public SuperDAO getDAO(DAOType types){
        switch (types){
            case STUDENT:
                return new StudentDAOImpl();
            case ROOM:
                return new RoomDAOImpl();
            case RESERVATION:
                return new ReservationDAOImpl();
            case USER:
                return new UserDAOImpl();
            default:
                return null;
        }
    }
}
