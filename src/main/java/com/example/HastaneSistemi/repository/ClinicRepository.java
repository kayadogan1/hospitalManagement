package com.example.HastaneSistemi.repository;

import com.example.HastaneSistemi.model.Clinic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClinicRepository extends JpaRepository<Clinic, Integer> {
    // İstenirse burada özel sorgular tanımlanabilir
}
