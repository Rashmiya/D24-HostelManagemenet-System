package lk.ijse.D24Hostel.dto;

import lk.ijse.D24Hostel.entity.Room;
import lk.ijse.D24Hostel.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReservationDTO {
    private String res_id;
    private LocalDate date;
    private Student studentID;
    private Room roomID;
    private double key_money;
    private String status;
    private int qty;
}
