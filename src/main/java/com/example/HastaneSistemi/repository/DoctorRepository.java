package com.example.HastaneSistemi.repository;

import com.example.HastaneSistemi.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
    List<Doctor> findBySpeciality(String speciality);
}
