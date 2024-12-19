package com.example.HastaneSistemi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Entity(name = "Appointment")
@Table(name = "appointment")
@Data
@NoArgsConstructor
@Getter
@Setter
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
    @JsonIgnore
    private Patient patient;

}
