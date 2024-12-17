package com.example.HastaneSistemi.repository;

import com.example.HastaneSistemi.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {
    @Query(value = "CALL delete_appointment(:p_appointment_id)", nativeQuery = true)
    void deleteByAppointmentId(@Param("p_appointment_id") Integer appointmentId);
}
