package com.example.HastaneSistemi.controller;

import com.example.HastaneSistemi.model.Appointment;
import com.example.HastaneSistemi.service.AppointmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {
    private final AppointmentService appointmentService;
    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }
    @PostMapping
    public ResponseEntity<Appointment> createAppointment(@RequestBody Appointment appointment) {
        return ResponseEntity.ok(appointmentService.addAppointment(appointment));

    }
    @GetMapping
    public ResponseEntity<List<Appointment>> getAllAppointments() {
        return ResponseEntity.ok(appointmentService.getAllAppointment());
    }
    @GetMapping("{id}")
    public ResponseEntity<Appointment> getAppointmentById(@RequestParam Integer id) {
        return appointmentService.getAppointmentById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @PostMapping("/id")
    public ResponseEntity<Appointment> updateAppointment(@PathVariable Integer id,@RequestBody Appointment updatedAppointment) {
        return ResponseEntity.ok(appointmentService.updateAppointment(id, updatedAppointment));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAppointment(@PathVariable Integer id) {
        appointmentService.deleteAppointmentById(id);
        return ResponseEntity.noContent().build();
    }

}
