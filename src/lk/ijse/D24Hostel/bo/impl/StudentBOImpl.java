package lk.ijse.D24Hostel.bo.impl;

import lk.ijse.D24Hostel.bo.custom.StudentBo;
import lk.ijse.D24Hostel.dao.DAOFactory;
import lk.ijse.D24Hostel.dao.custom.StudentDAO;
import lk.ijse.D24Hostel.dto.StudentDTO;
import lk.ijse.D24Hostel.entity.Student;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StudentBOImpl implements StudentBo {

    StudentDAO studentDAO = (StudentDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOType.STUDENT);

    @Override
    public List<StudentDTO> getAllStudent() throws IOException {
        List<Student> all = studentDAO.getAll();

        ArrayList<StudentDTO> allStudents = new ArrayList<>();

        for(Student student: all){
            allStudents.add(new StudentDTO(
                    student.getSId(),
                    student.getName(),
                    student.getAddress(),
                    student.getContactNumber(),
                    student.getDob(),
                    student.getGender()));
        }
        return allStudents;
    }

    @Override
    public boolean saveStudent(StudentDTO dto) throws IOException {
        return studentDAO.save(new Student(
                dto.getId(),
                dto.getName(),
                dto.getAddress(),
                dto.getContactNumber(),
                dto.getDob(),
                dto.getGender()
        ));
    }

    @Override
    public boolean updateStudent(StudentDTO dto) throws IOException {
        return studentDAO.update(new Student(
                dto.getId(),
                dto.getName(),
                dto.getAddress(),
                dto.getContactNumber(),
                dto.getDob(),
                dto.getGender()
        ));
    }

    @Override
    public boolean deleteStudent(String id) throws IOException {
        return studentDAO.delete(id);
    }

    @Override
    public String generateStudentId() throws IOException {
        return null;
    }
}
