package com.example.HastaneSistemi.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer appointmentId;
    private String status;
    private String appointmentTitle;
    private String appointmentDescription;
    private LocalDate appointmentDate;
    private LocalDateTime appointmentTime;
    @ManyToOne
    @JoinColumn
    private Doctor doctor;
    @ManyToOne
    @JoinColumn
    private Patient patient;

}
