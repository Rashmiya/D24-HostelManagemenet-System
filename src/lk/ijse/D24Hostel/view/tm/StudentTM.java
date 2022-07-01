package lk.ijse.D24Hostel.view.tm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentTM {
    private String id;
    private String name;
    private String address;
    private String contactNumber;
    private LocalDate dob;
    private String gender;
}
