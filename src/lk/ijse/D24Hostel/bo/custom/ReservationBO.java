package lk.ijse.D24Hostel.bo.custom;

import javafx.collections.ObservableList;
import lk.ijse.D24Hostel.bo.SuperBO;
import lk.ijse.D24Hostel.dto.ReservationDTO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public interface ReservationBO extends SuperBO {
    ArrayList<ReservationDTO> getAllReserveDetails() throws SQLException, ClassNotFoundException;

    public ArrayList<ReservationDTO> searchReserveDetails(String enteredText) throws SQLException, ClassNotFoundException;

    /*ObservableList<RemainKeyMnyTM> getRemainKeyMnyStudent() throws SQLException, ClassNotFoundException, IOException;*/
}
