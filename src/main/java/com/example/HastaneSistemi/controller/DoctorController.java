package com.example.HastaneSistemi.controller;

import com.example.HastaneSistemi.model.Doctor;
import com.example.HastaneSistemi.service.DoctorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

    private final DoctorService doctorService;

    // Constructor Injection
    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }
    @PostMapping("/{doctorId}/assign-patient/{patientId}")
    public ResponseEntity<String> assignPatientToDoctor(@PathVariable Integer doctorId, @PathVariable Integer patientId){
        doctorService.assignPatient(doctorId, patientId);
        return ResponseEntity.status(HttpStatus.CREATED).body("Patient assigned to Doctor  successfully");
    }
    // Yeni doktor ekleme
    @PostMapping
    public ResponseEntity<Doctor> addDoctor(@RequestBody Doctor doctor) {
        try {
            Doctor savedDoctor = doctorService.saveDoctor(doctor);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedDoctor);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
    @PostMapping("/all")
    public ResponseEntity<List<Doctor>> addDoctors(@RequestBody List<Doctor> doctors) {
        // Doctor service sınıfından doktorları kaydediyoruz
        List<Doctor> savedDoctors = doctorService.saveDoctors(doctors);

        // Doktorlar başarıyla kaydedildiyse, HTTP 201 ile birlikte geri döneceğiz
        return ResponseEntity.status(HttpStatus.CREATED).body(savedDoctors);
    }


    // Tüm doktorları getirme
    @GetMapping
    public ResponseEntity<List<Doctor>> getAllDoctors() {
        List<Doctor> doctors = doctorService.getAllDoctor();
        if (doctors.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(doctors);
    }

    // ID'ye göre doktor getirme
    @GetMapping("/{id}")
    public ResponseEntity<Doctor> getDoctorById(@PathVariable Integer id) {
        return doctorService.getDoctorById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Uzmanlık alanına göre doktorları getirme
    @GetMapping("/speciality/{specialty}")
    public ResponseEntity<List<Doctor>> getDoctorBySpecialty(@PathVariable String specialty) {
        List<Doctor> doctors = doctorService.getDoctorBySpeciality(specialty);
        if (doctors.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(doctors);
    }

    // Doktor silme
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDoctor(@PathVariable Integer id) {
        if (doctorService.getDoctorById(id).isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        doctorService.deleteDoctorById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
