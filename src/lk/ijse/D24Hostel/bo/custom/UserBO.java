package lk.ijse.D24Hostel.bo.custom;

import lk.ijse.D24Hostel.bo.SuperBO;
import lk.ijse.D24Hostel.dto.UserDTO;
import lk.ijse.D24Hostel.entity.User;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface UserBO extends SuperBO {
    List<UserDTO> getAllUser() throws IOException;

    boolean saveUser(UserDTO dto) throws IOException;

    boolean updateUser(UserDTO dto) throws IOException;

    boolean deleteUser(String id) throws IOException;

    User searchUser(String id) throws IOException, SQLException, ClassNotFoundException;

}
