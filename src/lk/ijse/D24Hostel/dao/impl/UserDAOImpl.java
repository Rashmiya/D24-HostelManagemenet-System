package lk.ijse.D24Hostel.dao.impl;

import lk.ijse.D24Hostel.dao.custom.UserDAO;
import lk.ijse.D24Hostel.entity.User;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class UserDAOImpl implements UserDAO {
    @Override
    public List<User> getAll() throws IOException {
        return null;
    }

    @Override
    public boolean save(User entity) throws IOException {
        return false;
    }

    @Override
    public boolean update(User entity) throws IOException {
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
    public User search(String s) throws SQLException, ClassNotFoundException, IOException {
        return null;
    }
}
