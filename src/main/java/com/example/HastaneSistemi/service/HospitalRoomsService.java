package com.example.HastaneSistemi.service;

import com.example.HastaneSistemi.model.HospitalRooms;
import com.example.HastaneSistemi.repository.HospitalRoomsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HospitalRoomsService {

    private final HospitalRoomsRepository hospitalRoomsRepository;

    @Autowired
    public HospitalRoomsService(HospitalRoomsRepository hospitalRoomsRepository) {
        this.hospitalRoomsRepository = hospitalRoomsRepository;
    }

    // Tüm odaları getir
    public List<HospitalRooms> getAllRooms() {
        return hospitalRoomsRepository.findAll();
    }

    // ID'ye göre oda getir
    public Optional<HospitalRooms> getRoomById(int id) {
        return hospitalRoomsRepository.findById(id);
    }

    // Yeni oda ekle
    public HospitalRooms addRoom(HospitalRooms room) {
        return hospitalRoomsRepository.save(room);
    }

    // Oda bilgilerini güncelle
    public HospitalRooms updateRoom(int id, HospitalRooms updatedRoom) {
        HospitalRooms existingRoom = getRoomById(id).orElse(null);
        existingRoom.setRoomNumber(updatedRoom.getRoomNumber());
        existingRoom.setBedCount(updatedRoom.getBedCount());
        existingRoom.setBeds(updatedRoom.getBeds());
        return hospitalRoomsRepository.save(existingRoom);
    }

    // Odayı sil
    public void deleteRoom(int id) {
        hospitalRoomsRepository.deleteById(id);
    }
}
