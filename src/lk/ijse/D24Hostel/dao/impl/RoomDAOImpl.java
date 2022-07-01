package lk.ijse.D24Hostel.dao.impl;

import lk.ijse.D24Hostel.dao.custom.RoomDAO;
import lk.ijse.D24Hostel.entity.Room;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class RoomDAOImpl implements RoomDAO {
    @Override
    public List<Room> getAll() throws IOException {
        return null;
    }

    @Override
    public boolean save(Room entity) throws IOException {
        return false;
    }

    @Override
    public boolean update(Room entity) throws IOException {
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
    public Room search(String s) throws SQLException, ClassNotFoundException, IOException {
        return null;
    }
}
