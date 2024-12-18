package com.example.HastaneSistemi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;


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
    @JoinColumn(name = "room_id")
    @JsonBackReference
    private HospitalRooms room;

}
