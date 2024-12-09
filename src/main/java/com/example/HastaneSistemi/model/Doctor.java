package com.example.HastaneSistemi.model;

import jakarta.persistence.*;

import lombok.Data;
import lombok.Getter;

import java.util.List;

@Entity
@DiscriminatorValue("DOCTOR")
@Getter
public class Doctor extends Personel {
    @Getter
    @Column(nullable = false)
    private String speciality;

    @ManyToOne
    @JoinColumn(name="clinic_doktor")
    private Clinic clinic;

    @ManyToOne
    @JoinColumn(name = "doctor_patient")
    private Patient patient;
    @OneToMany
    @JoinColumn
    List<Prescription> prescriptions;

}
