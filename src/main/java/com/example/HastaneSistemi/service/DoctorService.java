package com.example.HastaneSistemi.service;

import com.example.HastaneSistemi.model.Doctor;
import com.example.HastaneSistemi.repository.DoctorPatientRepository;
import com.example.HastaneSistemi.repository.DoctorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

    private final  DoctorRepository doctorRepository;
    private final  DoctorPatientRepository doctorPatientRepository;
    public DoctorService(DoctorRepository doctorRepository,DoctorPatientRepository doctorPatientRepository) {
        this.doctorRepository = doctorRepository;
        this.doctorPatientRepository = doctorPatientRepository;
    }
    public void assignPatient(Integer doctorId, Integer patientId) {
        doctorPatientRepository.assignPatientToDoctor(doctorId,patientId);
    }
    public Doctor saveDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }
    public List<Doctor> saveDoctors(List<Doctor> doctors) {

        return doctorRepository.saveAll(doctors);

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
