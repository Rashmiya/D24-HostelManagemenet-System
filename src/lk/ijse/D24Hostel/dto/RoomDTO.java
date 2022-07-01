package lk.ijse.D24Hostel.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RoomDTO {
    private String roomId;
    private String roomType;
    private String keyMoney;
    private int qty;
    private String status;
}
