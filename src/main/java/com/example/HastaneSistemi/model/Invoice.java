package com.example.HastaneSistemi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Invoice {//fatura
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int invoice_id;
    private String title;
    private String description;
    private int amount;

    @OneToOne
    Patient patient;


}
