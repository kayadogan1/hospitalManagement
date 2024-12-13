package com.example.HastaneSistemi.service;

import com.example.HastaneSistemi.model.Clinic;
import com.example.HastaneSistemi.repository.ClinicRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class ClinicService {

    private final ClinicRepository clinicRepository;


    public ClinicService(ClinicRepository clinicRepository) {
        this.clinicRepository = clinicRepository;
    }
    @PostConstruct
    public void init(){
        if(clinicRepository.count()==1){
            initializeClinics();
        }
    }
    public void initializeClinics() {
        List<Clinic> clinics = Arrays.asList(
                new Clinic(null, "Kardiyoloji Kliniği", "Ana Hastane Binası 1. Kat", null, null, null, null),
                new Clinic(null, "Nöroloji Kliniği", "Ana Hastane Binası 2. Kat", null, null, null, null),
                new Clinic(null, "Pediatri Kliniği", "Çocuk Hastanesi Binası", null, null, null, null),
                new Clinic(null, "Onkoloji Kliniği", "Yan Bina 3. Kat", null, null, null, null),
                new Clinic(null, "Acil Servis Kliniği", "Giriş Katı", null, null, null, null)
        );

        clinicRepository.saveAll(clinics);
    }
    // Tüm klinikleri getir
    public List<Clinic> getAllClinics() {
        return clinicRepository.findAll();
    }

    // ID'ye göre klinik getir
    public Clinic getClinicById(Integer id) {
        Optional<Clinic> clinic = clinicRepository.findById(id);
        return clinic.orElseThrow(() -> new RuntimeException("Clinic not found with id: " + id));
    }

    // Yeni bir klinik ekle
    public Clinic addClinic(Clinic clinic) {
        return clinicRepository.save(clinic);
    }

    // Klinik güncelle
    public Clinic updateClinic(Integer id, Clinic updatedClinic) {
        Clinic existingClinic = getClinicById(id);
        existingClinic.setClinicName(updatedClinic.getClinicName());
        existingClinic.setClinicAddress(updatedClinic.getClinicAddress());
        // Gerekirse alt ilişkiler (doctors, beds, rooms, nurses) burada güncellenebilir.
        return clinicRepository.save(existingClinic);
    }

    // Klinik sil
    public void deleteClinic(Integer id) {
        clinicRepository.deleteById(id);
    }
}
