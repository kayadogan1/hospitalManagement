package com.example.HastaneSistemi.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
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

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getBedCount() {
        return bedCount;
    }

    public void setBedCount(int bedCount) {
        this.bedCount = bedCount;
    }

    public Clinic getClinic() {
        return clinic;
    }

    public void setClinic(Clinic clinic) {
        this.clinic = clinic;
    }

    public List<Beds> getBeds() {
        return beds;
    }

    public void setBeds(List<Beds> beds) {
        this.beds = beds;
    }
}
