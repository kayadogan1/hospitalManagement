package com.example.HastaneSistemi.repository;

import com.example.HastaneSistemi.model.LabTests;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LabTestRepository extends JpaRepository<LabTests, Integer> {
    // Özel sorgular gerekirse burada eklenebilir
}
