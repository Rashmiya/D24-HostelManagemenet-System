package lk.ijse.D24Hostel.bo.impl;

import lk.ijse.D24Hostel.bo.custom.RoomBo;
import lk.ijse.D24Hostel.dao.DAOFactory;
import lk.ijse.D24Hostel.dao.custom.RoomDAO;
import lk.ijse.D24Hostel.dto.RoomDTO;
import lk.ijse.D24Hostel.entity.Room;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RoomBOImpl implements RoomBo {

    RoomDAO roomDAO = (RoomDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOType.ROOM);

    @Override
    public List<RoomDTO> getAllRooms() throws IOException {
        List<Room> all = roomDAO.getAll();
        ArrayList<RoomDTO> allRooms = new ArrayList<>();

        for(Room room: all){
            allRooms.add(new RoomDTO(
                    room.getRoomTypeID(),
                    room.getRoomType(),
                    room.getKeyMoney(),
                    room.getQty()
            ));
        }
        return allRooms;
    }

    @Override
    public boolean saveRoom(RoomDTO dto) throws IOException {
        return roomDAO.save(new Room(
                dto.getRoomId(),
                dto.getRoomType(),
                dto.getKeyMoney(),
                dto.getQty()
        ));
    }

    @Override
    public boolean updateRoom(RoomDTO dto) throws IOException {
        return roomDAO.update(new Room(
                dto.getRoomId(),
                dto.getRoomType(),
                dto.getKeyMoney(),
                dto.getQty()
        ));
    }

    @Override
    public boolean deleteRoom(String id) throws IOException {
        return roomDAO.delete(id);
    }

    @Override
    public String generateRoomID() throws IOException {
        return null;
    }
}
