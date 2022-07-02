package lk.ijse.D24Hostel.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Room {
    @Id
    private String roomTypeID;
    @Column(nullable = false)
    private String roomType;
    @Column(nullable = false)
    private String keyMoney;
    @Column(nullable = false)
    private int qty;
    @Column(nullable = false)
    private String status;

    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
    private List<Reservation> reservationList = new ArrayList<>();

    public Room(String roomId, String roomType, String keyMoney, int qty) {
        this.roomTypeID = roomId;
        this.roomType = roomType;
        this.keyMoney = keyMoney;
        this.qty = qty;
    }
}

