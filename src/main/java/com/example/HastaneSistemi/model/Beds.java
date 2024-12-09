package com.example.HastaneSistemi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
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

    public Integer getBed_id() {
        return bed_id;
    }

    public void setBed_id(Integer bed_id) {
        this.bed_id = bed_id;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public HospitalRooms getRoom() {
        return room;
    }

    public void setRoom(HospitalRooms room) {
        this.room = room;
    }
}
