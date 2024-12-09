package com.example.HastaneSistemi.model;

import jakarta.persistence.*;
import lombok.*;

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
    private String appointmentTitle;
    private String appointmentDescription;
    private String appointmentDate;
    private String appointmentTime;
    @ManyToOne
    @JoinColumn
    private Doctor doctor;
    @ManyToOne
    @JoinColumn
    private Patient patient;

}
