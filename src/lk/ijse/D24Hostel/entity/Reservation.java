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
    @Column(nullable = false)
    private double key_money;
    @Column(nullable = false)
    private Integer qty;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Student student;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Room room;

    public Reservation(String register_Id, LocalDate date, double keyMoney, int qty, String keyMoneyStatus, Room roomID, Student studentID) {
        this.register_Id=register_Id;
        this.date=date;
        this.key_money=keyMoney;
        this.qty=qty;
        this.keyMoneyStatus=keyMoneyStatus;
        this.room=roomID;
        this.student=studentID;

    }
}
