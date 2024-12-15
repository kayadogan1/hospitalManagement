package com.example.HastaneSistemi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HospitalRooms {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int roomId;
    private int roomNumber;
    private int bedCount;
    @ManyToOne
    Clinic clinic;
    @OneToMany
    List<Beds> beds;


}
