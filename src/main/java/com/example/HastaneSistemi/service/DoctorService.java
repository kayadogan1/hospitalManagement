package com.example.HastaneSistemi.service;

import com.example.HastaneSistemi.model.Doctor;
import com.example.HastaneSistemi.repository.DoctorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

    DoctorRepository doctorRepository;
    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }
    public Doctor saveDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }
    public List<Doctor> getAllDoctor() {
        return doctorRepository.findAll();
    }
    public List<Doctor> getDoctorBySpeciality(String speciality) {
        return doctorRepository.findBySpeciality(speciality);
    }
    public Optional<Doctor> getDoctorById(int id) {
        return doctorRepository.findById(id);
    }
    public void deleteDoctorById(int id) {
        doctorRepository.deleteById(id);
    }

}
