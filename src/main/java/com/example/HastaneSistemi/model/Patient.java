package com.example.HastaneSistemi.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Getter
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Setter
    @Column(nullable = false)
    private String firstName;
    @Setter
    @Column(nullable = false)
    private String lastName;
    @Setter
    private String gender;

    @ManyToMany
    @JoinTable(
            name = "doctor_patient",
            joinColumns = @JoinColumn(name = "patient_id"),
            inverseJoinColumns = @JoinColumn(name = "doctor_id")
    )
    private List<Doctor> doctors;

    @Setter
    @OneToMany(mappedBy = "patient")
    @JsonIgnore
    private List<Visitor> visitors;
    @Setter
    @OneToMany
    @JsonIgnore
    private List<Appointment> appointments;
    @Setter
    @OneToOne
    @JsonIgnore
    Invoice invoice;
    @Setter
    @OneToOne
    @JsonIgnore
    Prescription prescription;
    @OneToOne
    @JsonIgnore
    LabResults labResult;



}
