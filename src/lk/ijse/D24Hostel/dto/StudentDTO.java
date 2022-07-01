package lk.ijse.D24Hostel.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentDTO {
    private String id;
    private String name;
    private String address;
    private String contactNumber;
    private LocalDate dob;
    private String gender;
}
