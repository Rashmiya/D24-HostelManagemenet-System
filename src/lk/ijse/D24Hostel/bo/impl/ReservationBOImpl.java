package lk.ijse.D24Hostel.bo.impl;

import lk.ijse.D24Hostel.bo.custom.ReservationBO;
import lk.ijse.D24Hostel.dao.DAOFactory;
import lk.ijse.D24Hostel.dao.custom.ReservationDAO;
import lk.ijse.D24Hostel.dto.ReservationDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class ReservationBOImpl implements ReservationBO {

    ReservationDAO reservationDAO = (ReservationDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOType.RESERVATION);

    @Override
    public ArrayList<ReservationDTO> getAllReserveDetails() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<ReservationDTO> searchReserveDetails(String enteredText) throws SQLException, ClassNotFoundException {
        return null;
    }
}
