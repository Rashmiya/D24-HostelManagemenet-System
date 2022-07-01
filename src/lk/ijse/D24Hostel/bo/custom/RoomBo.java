package lk.ijse.D24Hostel.bo.custom;

import lk.ijse.D24Hostel.bo.SuperBO;
import lk.ijse.D24Hostel.dto.RoomDTO;

import java.io.IOException;
import java.util.List;

public interface RoomBo extends SuperBO {
    List<RoomDTO> getAllRooms() throws IOException;

    boolean saveRoom(RoomDTO dto) throws IOException;

    boolean updateRoom(RoomDTO dto) throws IOException;

    boolean deleteRoom(String id) throws IOException;

    String generateRoomID() throws IOException;
}
