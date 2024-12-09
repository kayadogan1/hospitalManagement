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
    DoctorService doctorService;
    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }
    @PostMapping
    public ResponseEntity<Doctor> addDoctor(@RequestBody Doctor doctor) {
        Doctor savedDoctor= doctorService.saveDoctor(doctor);
        return ResponseEntity.ok(savedDoctor);
    }
    @GetMapping
    public ResponseEntity<List<Doctor>> getAllDoctors() {
        List<Doctor> doctors = doctorService.getAllDoctor();
        if(doctors.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(doctors);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Doctor> getDoctorById(@PathVariable Integer id) {
        return doctorService.getDoctorById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @GetMapping("/speciality/{specialty}")
    public ResponseEntity<List<Doctor>> getDoctorBySpecialty(@PathVariable String specialty) {
        List<Doctor> doctors = doctorService.getDoctorBySpeciality(specialty);
        if(doctors.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(doctors);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Doctor> deleteDoctor(@PathVariable Integer id) {
        if(doctorService.getDoctorById(id).isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        doctorService.deleteDoctorById(id);
        return ResponseEntity.ok().build();
    }
}
