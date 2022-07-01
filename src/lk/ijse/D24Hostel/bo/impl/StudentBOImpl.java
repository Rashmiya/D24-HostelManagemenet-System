package lk.ijse.D24Hostel.bo.impl;

import lk.ijse.D24Hostel.bo.custom.StudentBo;
import lk.ijse.D24Hostel.dao.DAOFactory;
import lk.ijse.D24Hostel.dao.custom.StudentDAO;
import lk.ijse.D24Hostel.dto.StudentDTO;

import java.io.IOException;
import java.util.List;

public class StudentBOImpl implements StudentBo {

    StudentDAO studentDAO = (StudentDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOType.STUDENT);

    @Override
    public List<StudentDTO> getAllStudent() throws IOException {
        return null;
    }

    @Override
    public boolean saveStudent(StudentDTO dto) throws IOException {
        return false;
    }

    @Override
    public boolean updateStudent(StudentDTO dto) throws IOException {
        return false;
    }

    @Override
    public boolean deleteStudent(String id) throws IOException {
        return false;
    }

    @Override
    public String generateStudentId() throws IOException {
        return null;
    }
}
