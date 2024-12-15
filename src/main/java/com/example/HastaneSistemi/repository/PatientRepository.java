package com.example.HastaneSistemi.repository;

import com.example.HastaneSistemi.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {
    @Procedure(name = "add_patient")
    void addPatient(@Param("p_first_name") String firstName,
                    @Param("p_gender") String gender,
                    @Param("p_last_name") String lastName);

}
