package com.example.HastaneSistemi.model;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Beds {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bed_id;
    private boolean status;
    private String roomName;
    @ManyToOne
    HospitalRooms room;

}
