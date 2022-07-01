package lk.ijse.D24Hostel.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Reservation {
    @Id
    private String register_Id;
    @Column(columnDefinition = "DATE", nullable = false)
    private LocalDate date;
    @Column(nullable = false)
    private String keyMoneyStatus;

    @ManyToOne(cascade = CascadeType.ALL)
    private Student student;

    @ManyToOne(cascade = CascadeType.ALL)
    private Room room;
}
