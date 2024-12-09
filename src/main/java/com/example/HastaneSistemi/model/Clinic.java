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
public class Clinic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String clinicName;

    private String clinicAddress;
    @OneToMany
    private List<Doctor> doctors;
    @OneToMany
    List<Beds> beds;
    @OneToMany
    List<HospitalRooms> rooms;
    @OneToMany
    List<Nurse> nurses;


}
