package com.example.HastaneSistemi.repository;

import com.example.HastaneSistemi.model.LabResults;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LabResultsRepository extends JpaRepository<LabResults, Integer> {
    // Özel sorgular gerekirse burada eklenebilir
}
