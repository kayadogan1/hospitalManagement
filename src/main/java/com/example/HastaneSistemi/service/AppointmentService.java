package com.example.HastaneSistemi.service;

import com.example.HastaneSistemi.model.Appointment;
import com.example.HastaneSistemi.repository.AppointmentRepository;
import lombok.Data;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;
import java.util.Optional;

@Service
@Data
public class AppointmentService {
    private final AppointmentRepository appointmentRepository;
    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }
    public Appointment addAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }
    public Optional<Appointment> getAppointmentById(Integer id) {
        return appointmentRepository.findById(id);
    }
    public List<Appointment> getAllAppointment() {
        return appointmentRepository.findAll();
    }
    public Appointment updateAppointment(Integer id,Appointment updatedAppointment) {
        return appointmentRepository.findById(id)
                .map(existingAppointment->{
                    existingAppointment.setAppointmentTitle(updatedAppointment.getAppointmentTitle());
                    existingAppointment.setAppointmentDate(updatedAppointment.getAppointmentDate());
                    existingAppointment.setAppointmentTime(updatedAppointment.getAppointmentTime());
                    existingAppointment.setAppointmentDescription(updatedAppointment.getAppointmentDescription());
                    return appointmentRepository.save(existingAppointment);
                })
                .orElseThrow(() ->new RuntimeException(("Appointment not found")+id));
    }
    @DeleteMapping("/id")
    public void deleteAppointmentById(Integer id) {
        appointmentRepository.deleteById(id);
    }


}
