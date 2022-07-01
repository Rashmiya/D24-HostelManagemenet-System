package lk.ijse.D24Hostel.dao.impl;

import lk.ijse.D24Hostel.dao.custom.ReservationDAO;
import lk.ijse.D24Hostel.entity.Reservation;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class ReservationDAOImpl implements ReservationDAO {
    @Override
    public List<Reservation> getAll() throws IOException {
        return null;
    }

    @Override
    public boolean save(Reservation entity) throws IOException {
        return false;
    }

    @Override
    public boolean update(Reservation entity) throws IOException {
        return false;
    }

    @Override
    public boolean delete(String s) throws IOException {
        return false;
    }

    @Override
    public boolean find(String s) throws SQLException, ClassNotFoundException, IOException {
        return false;
    }

    @Override
    public String generateNewID() throws IOException {
        return null;
    }

    @Override
    public Reservation search(String s) throws SQLException, ClassNotFoundException, IOException {
        return null;
    }
}
