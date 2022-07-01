package lk.ijse.D24Hostel.dao.impl;

import lk.ijse.D24Hostel.dao.custom.StudentDAO;
import lk.ijse.D24Hostel.entity.Student;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class StudentDAOImpl implements StudentDAO {
    @Override
    public List<Student> getAll() throws IOException {
        return null;
    }

    @Override
    public boolean save(Student entity) throws IOException {
        return false;
    }

    @Override
    public boolean update(Student entity) throws IOException {
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
    public Student search(String s) throws SQLException, ClassNotFoundException, IOException {
        return null;
    }
}
