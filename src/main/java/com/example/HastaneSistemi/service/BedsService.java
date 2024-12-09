package com.example.HastaneSistemi.service;

import com.example.HastaneSistemi.model.Beds;
import com.example.HastaneSistemi.repository.BedsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BedsService {

    private final BedsRepository bedsRepository;

    @Autowired
    public BedsService(BedsRepository bedsRepository) {
        this.bedsRepository = bedsRepository;
    }

    // Tüm yatakları getir
    public List<Beds> getAllBeds() {
        return bedsRepository.findAll();
    }

    // ID'ye göre yatak getir
    public Beds getBedById(Integer id) {
        return bedsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Bed not found with id: " + id));
    }

    // Yeni yatak ekle
    public Beds addBed(Beds bed) {
        return bedsRepository.save(bed);
    }

    // Yatak güncelle
    public Beds updateBed(Integer id, Beds updatedBed) {
        Beds existingBed = getBedById(id);
        existingBed.setStatus(updatedBed.isStatus());
        existingBed.setRoomName(updatedBed.getRoomName());
        existingBed.setRoom(updatedBed.getRoom());
        return bedsRepository.save(existingBed);
    }

    // Yatak sil
    public void deleteBed(Integer id) {
        bedsRepository.deleteById(id);
    }
}
