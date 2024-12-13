package com.example.HastaneSistemi.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LabResults {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "result_id",nullable = false)
    private Integer ResultId;
    @Getter
    @Setter
    private String result;
    @Getter
    @Setter
    private String notes;
    @Getter
    @Setter
    @OneToOne
    LabTests labTest;

    @OneToOne
    Patient patient;

}
