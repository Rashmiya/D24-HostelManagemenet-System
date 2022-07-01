package lk.ijse.D24Hostel.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomDTO {
    private String id;
    private String name;
    private String address;
    private String contactNumber;
    private LocalDate dob;
    private String gender;

    private String roomId;
    private String roomType;
    private String keyMoney;
    private int qty;
    private String status;

    private String register_Id;
    private LocalDate date;
    private String keyMoneyStatus;

    private String userID;
    private String userName;
    private String password;
}
