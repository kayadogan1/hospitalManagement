package com.example.HastaneSistemi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    @OneToMany(mappedBy = "room",cascade = CascadeType.ALL)
    @JsonManagedReference
    List<Beds> beds;


}
