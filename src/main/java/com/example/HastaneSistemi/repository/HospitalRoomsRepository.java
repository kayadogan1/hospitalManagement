package com.example.HastaneSistemi.repository;

import com.example.HastaneSistemi.model.HospitalRooms;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HospitalRoomsRepository extends JpaRepository<HospitalRooms, Integer> {
    // Özel sorgular gerekiyorsa burada tanımlanabilir, örneğin:
     List<HospitalRooms> findByClinic_ClinicName(String clinicName);
}