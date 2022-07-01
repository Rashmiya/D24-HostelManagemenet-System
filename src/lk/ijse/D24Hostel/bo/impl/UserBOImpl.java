package lk.ijse.D24Hostel.bo.impl;

import lk.ijse.D24Hostel.bo.BOFactory;
import lk.ijse.D24Hostel.bo.custom.StudentBo;
import lk.ijse.D24Hostel.bo.custom.UserBO;
import lk.ijse.D24Hostel.dao.DAOFactory;
import lk.ijse.D24Hostel.dao.custom.UserDAO;
import lk.ijse.D24Hostel.dto.UserDTO;
import lk.ijse.D24Hostel.entity.User;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class UserBOImpl implements UserBO {

     UserDAO userDAO = (UserDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOType.USER);

    @Override
    public List<UserDTO> getAllUser() throws IOException {
        return null;
    }

    @Override
    public boolean saveUser(UserDTO dto) throws IOException {
        return false;
    }

    @Override
    public boolean updateUser(UserDTO dto) throws IOException {
        return false;
    }

    @Override
    public boolean deleteUser(String id) throws IOException {
        return false;
    }

    @Override
    public User searchUser(String id) throws IOException, SQLException, ClassNotFoundException {
        return null;
    }
}
