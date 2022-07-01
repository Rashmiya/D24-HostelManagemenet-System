package lk.ijse.D24Hostel.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {
    @Id
    private String user_id;
    @Column(nullable = false)
    private String user_name;
    @Column(nullable = false)
    private String password;
}
