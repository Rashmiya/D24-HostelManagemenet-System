package lk.ijse.D24Hostel.view.tm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RoomTM {
    private String roomId;
    private String roomType;
    private String keyMoney;
    private int qty;
    private String status;
}
