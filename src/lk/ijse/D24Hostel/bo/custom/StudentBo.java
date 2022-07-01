package lk.ijse.D24Hostel.bo.custom;

import lk.ijse.D24Hostel.bo.SuperBO;
import lk.ijse.D24Hostel.dto.StudentDTO;

import java.io.IOException;
import java.util.List;

public interface StudentBo extends SuperBO {
    List<StudentDTO> getAllStudent() throws IOException;

    boolean saveStudent(StudentDTO dto) throws IOException;

    boolean updateStudent(StudentDTO dto) throws IOException;

    boolean deleteStudent(String id) throws IOException;

    String generateStudentId() throws IOException;
}
