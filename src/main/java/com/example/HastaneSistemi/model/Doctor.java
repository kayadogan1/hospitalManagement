package com.example.HastaneSistemi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import lombok.*;

import java.util.List;

@Entity
@DiscriminatorValue("DOCTOR")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Doctor extends Personel {
    @Getter
    @Column(nullable = false)
    private String speciality;

    @ManyToOne
    @JoinColumn(name="clinic_doktor",nullable = false)
    private Clinic clinic;

    @ManyToMany(mappedBy = "doctors")
    @JsonIgnore
    private List<Patient> patients;
    @OneToMany
    @JoinColumn
    @JsonIgnore
    List<Prescription> prescriptions;

}
