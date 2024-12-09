package com.example.HastaneSistemi.repository;

import com.example.HastaneSistemi.model.Beds;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BedsRepository extends JpaRepository<Beds, Integer> {
    // Özel sorgular gerekirse burada tanımlanabilir
    // Örneğin: List<Beds> findByStatus(boolean status);
}
