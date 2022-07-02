package lk.ijse.D24Hostel.view.tm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReservationTM {
    private String reservationID;
    private String roomID;
    private String roomType;
    private int Qty;
    private double keyMoney;
    private String status;
}
