package lk.ijse.D24Hostel.bo.impl;

import lk.ijse.D24Hostel.bo.custom.RoomBo;
import lk.ijse.D24Hostel.dao.DAOFactory;
import lk.ijse.D24Hostel.dao.custom.RoomDAO;
import lk.ijse.D24Hostel.dto.RoomDTO;

import java.io.IOException;
import java.util.List;

public class RoomBOImpl implements RoomBo {

    RoomDAO roomDAO = (RoomDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOType.ROOM);

    @Override
    public List<RoomDTO> getAllRooms() throws IOException {
        return null;
    }

    @Override
    public boolean saveRoom(RoomDTO dto) throws IOException {
        return false;
    }

    @Override
    public boolean updateRoom(RoomDTO dto) throws IOException {
        return false;
    }

    @Override
    public boolean deleteRoom(String id) throws IOException {
        return false;
    }

    @Override
    public String generateRoomID() throws IOException {
        return null;
    }
}
