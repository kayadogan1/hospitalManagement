package com.example.HastaneSistemi.repository;

import com.example.HastaneSistemi.model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {
    // Özel sorgular gerekirse burada tanımlanabilir
        List<Invoice> findByPatientId(Integer patientId);
}
