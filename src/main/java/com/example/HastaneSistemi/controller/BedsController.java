package com.example.HastaneSistemi.controller;

import com.example.HastaneSistemi.model.Beds;
import com.example.HastaneSistemi.service.BedsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/beds")
public class BedsController {

    private final BedsService bedsService;

    @Autowired
    public BedsController(BedsService bedsService) {
        this.bedsService = bedsService;
    }

    // Tüm yatakları getir
    @GetMapping
    public ResponseEntity<List<Beds>> getAllBeds() {
        return ResponseEntity.ok(bedsService.getAllBeds());
    }

    // ID'ye göre yatak getir
    @GetMapping("/{id}")
    public ResponseEntity<Beds> getBedById(@PathVariable Integer id) {
        return ResponseEntity.ok(bedsService.getBedById(id));
    }

    // Yeni yatak ekle
    @PostMapping
    public ResponseEntity<Beds> addBed(@RequestBody Beds bed) {
        return ResponseEntity.ok(bedsService.addBed(bed));
    }

    // Yatak güncelle
    @PutMapping("/{id}")
    public ResponseEntity<Beds> updateBed(@PathVariable Integer id, @RequestBody Beds bed) {
        return ResponseEntity.ok(bedsService.updateBed(id, bed));
    }

    // Yatak sil
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBed(@PathVariable Integer id) {
        bedsService.deleteBed(id);
        return ResponseEntity.noContent().build();
    }
}
