package com.example.HastaneSistemi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import lombok.*;

import java.util.List;

@Entity
@DiscriminatorValue("DOCTOR")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"clinic","clinic_beds","clinic_nurses","doctor_patient","clinic_rooms"})
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
