package com.example.HastaneSistemi.controller;

import com.example.HastaneSistemi.model.Clinic;
import com.example.HastaneSistemi.service.ClinicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clinics") // Kliniklere özel bir endpoint
public class ClinicController {

    private final ClinicService clinicService;

    @Autowired
    public ClinicController(ClinicService clinicService) {
        this.clinicService = clinicService;
    }

    // Tüm klinikleri getir
    @GetMapping
    public ResponseEntity<List<Clinic>> getAllClinics() {
        return ResponseEntity.ok(clinicService.getAllClinics());
    }

    // ID'ye göre klinik getir
    @GetMapping("/{id}")
    public ResponseEntity<Clinic> getClinicById(@PathVariable Integer id) {
        return ResponseEntity.ok(clinicService.getClinicById(id));
    }

    // Yeni bir klinik ekle
    @PostMapping
    public ResponseEntity<Clinic> addClinic(@RequestBody Clinic clinic) {
        return ResponseEntity.ok(clinicService.addClinic(clinic));
    }

    // Klinik güncelle
    @PutMapping("/{id}")
    public ResponseEntity<Clinic> updateClinic(@PathVariable Integer id, @RequestBody Clinic clinic) {
        return ResponseEntity.ok(clinicService.updateClinic(id, clinic));
    }

    // Klinik sil
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClinic(@PathVariable Integer id) {
        clinicService.deleteClinic(id);
        return ResponseEntity.noContent().build();
    }
}
