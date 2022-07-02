package lk.ijse.D24Hostel.bo.custom;

import javafx.collections.ObservableList;
import lk.ijse.D24Hostel.bo.SuperBO;
import lk.ijse.D24Hostel.dto.ReservationDTO;
import lk.ijse.D24Hostel.dto.RoomDTO;
import lk.ijse.D24Hostel.dto.StudentDTO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface ReservationBO extends SuperBO {
    boolean purchaseReserveSave(ReservationDTO dto) throws SQLException, ClassNotFoundException, IOException;

    boolean UpdateReservation(ReservationDTO dto) throws SQLException, ClassNotFoundException, IOException;

    boolean deleteReservation(String  id) throws SQLException, ClassNotFoundException, IOException;

    RoomDTO searchRooms(String id) throws SQLException, ClassNotFoundException, IOException;

    StudentDTO searchStudent(String id) throws SQLException, ClassNotFoundException, IOException;

    ReservationDTO searchReservation(String id) throws SQLException, ClassNotFoundException, IOException;

    String generateNewOrderID() throws SQLException, ClassNotFoundException, IOException;

    List<ReservationDTO> getAllReservation() throws Exception;


    List getStudentIds() throws IOException;

    List getRoomIds() throws IOException;

    /*ObservableList<RemainKeyMnyTM> getRemainKeyMnyStudent() throws SQLException, ClassNotFoundException, IOException;*/

}
