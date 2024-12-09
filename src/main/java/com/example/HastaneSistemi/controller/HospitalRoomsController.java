package com.example.HastaneSistemi.controller;

import com.example.HastaneSistemi.model.HospitalRooms;
import com.example.HastaneSistemi.service.HospitalRoomsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hospitalRooms") // HospitalRooms için endpoint
public class HospitalRoomsController {

    private final HospitalRoomsService hospitalRoomsService;

    @Autowired
    public HospitalRoomsController(HospitalRoomsService hospitalRoomsService) {
        this.hospitalRoomsService = hospitalRoomsService;
    }

    // Tüm odaları getir
    @GetMapping
    public ResponseEntity<List<HospitalRooms>> getAllRooms() {
        return ResponseEntity.ok(hospitalRoomsService.getAllRooms());
    }

    // ID'ye göre oda getir
    @GetMapping("/{id}")
    public ResponseEntity<HospitalRooms> getRoomById(@PathVariable int id) {
        return ResponseEntity.ok(hospitalRoomsService.getRoomById(id));
    }

    // Yeni oda ekle
    @PostMapping
    public ResponseEntity<HospitalRooms> addRoom(@RequestBody HospitalRooms room) {
        return ResponseEntity.ok(hospitalRoomsService.addRoom(room));
    }

    // Oda bilgilerini güncelle
    @PutMapping("/{id}")
    public ResponseEntity<HospitalRooms> updateRoom(@PathVariable int id, @RequestBody HospitalRooms room) {
        return ResponseEntity.ok(hospitalRoomsService.updateRoom(id, room));
    }

    // Odayı sil
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRoom(@PathVariable int id) {
        hospitalRoomsService.deleteRoom(id);
        return ResponseEntity.noContent().build();
    }
}
