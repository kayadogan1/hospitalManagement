package com.example.HastaneSistemi.repository;

import com.example.HastaneSistemi.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorPatientRepository extends JpaRepository<Doctor, Integer> {

    @Query(value = "CALL assign_patient_to_doctor(:p_patient_id, :p_doctor_id)", nativeQuery = true)
    void assignPatientToDoctor(@Param("p_doctor_id") Integer doctorId,
                               @Param("p_patient_id") Integer patientId);
}
