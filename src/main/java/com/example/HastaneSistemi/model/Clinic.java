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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClinicName() {
        return clinicName;
    }

    public void setClinicName(String clinicName) {
        this.clinicName = clinicName;
    }

    public String getClinicAddress() {
        return clinicAddress;
    }

    public void setClinicAddress(String clinicAddress) {
        this.clinicAddress = clinicAddress;
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }

    public List<Beds> getBeds() {
        return beds;
    }

    public void setBeds(List<Beds> beds) {
        this.beds = beds;
    }

    public List<HospitalRooms> getRooms() {
        return rooms;
    }

    public void setRooms(List<HospitalRooms> rooms) {
        this.rooms = rooms;
    }

    public List<Nurse> getNurses() {
        return nurses;
    }

    public void setNurses(List<Nurse> nurses) {
        this.nurses = nurses;
    }
}
