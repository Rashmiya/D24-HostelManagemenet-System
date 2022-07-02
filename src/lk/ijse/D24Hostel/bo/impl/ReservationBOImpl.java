package lk.ijse.D24Hostel.bo.impl;

import lk.ijse.D24Hostel.bo.custom.ReservationBO;
import lk.ijse.D24Hostel.dao.DAOFactory;
import lk.ijse.D24Hostel.dao.custom.ReservationDAO;
import lk.ijse.D24Hostel.dao.custom.RoomDAO;
import lk.ijse.D24Hostel.dao.custom.StudentDAO;
import lk.ijse.D24Hostel.dto.ReservationDTO;
import lk.ijse.D24Hostel.dto.RoomDTO;
import lk.ijse.D24Hostel.dto.StudentDTO;
import lk.ijse.D24Hostel.entity.Reservation;
import lk.ijse.D24Hostel.entity.Room;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class ReservationBOImpl implements ReservationBO {

    ReservationDAO reservationDAO = (ReservationDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOType.RESERVATION);
    RoomDAO roomDAO = (RoomDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOType.ROOM);
    StudentDAO studentDAO= (StudentDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOType.STUDENT);

    @Override
    public boolean purchaseReserveSave(ReservationDTO dto) throws SQLException, ClassNotFoundException, IOException {
        return false;
    }

    @Override
    public boolean UpdateReservation(ReservationDTO dto) throws SQLException, ClassNotFoundException, IOException {
       return null;
    }

    @Override
    public boolean deleteReservation(String id) throws SQLException, ClassNotFoundException, IOException {
        return reservationDAO.delete(id);
    }

    @Override
    public RoomDTO searchRooms(String id) throws SQLException, ClassNotFoundException, IOException {
        Room room = roomDAO.search(id);
        return new RoomDTO(room.getRoomTypeID(),room.getRoomType(),room.getKeyMoney(),room.getQty());
    }

    @Override
    public StudentDTO searchStudent(String id) throws SQLException, ClassNotFoundException, IOException {
        return null;
    }

    @Override
    public ReservationDTO searchReservation(String id) throws SQLException, ClassNotFoundException, IOException {
        return null;
    }

    @Override
    public String generateNewOrderID() throws SQLException, ClassNotFoundException, IOException {
        return null;
    }

    @Override
    public List<ReservationDTO> getAllReservation() throws Exception {
        return null;
    }

    @Override
    public List getStudentIds() throws IOException {
        return null;
    }

    @Override
    public List getRoomIds() throws IOException {
        return null;
    }
}
