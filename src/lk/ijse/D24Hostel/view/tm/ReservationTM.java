package lk.ijse.D24Hostel.view.tm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReservationTM {
    private String register_Id;
    private LocalDate date;
    private String keyMoneyStatus;
}
