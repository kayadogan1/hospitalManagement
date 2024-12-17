package com.example.HastaneSistemi.model;
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
            name = "doctor_patient", // Ortak tablo adı
            joinColumns = @JoinColumn(name = "patient_id"), // Doctor tarafındaki sütun
            inverseJoinColumns = @JoinColumn(name = "doctor_id") // Doctor tarafındaki sütun
    )
    private List<Doctor> doctors;

    @Setter
    @OneToMany(mappedBy = "patient")
    private List<Visitor> visitors;
    @Setter
    @OneToMany
    private List<Appointment> appointments;
    @Setter
    @OneToOne
    Invoice invoice;
    @Setter
    @OneToOne
    Prescription prescription;
    @OneToOne
    LabResults labResult;



}
