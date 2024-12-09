package com.example.HastaneSistemi.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Entity
@DiscriminatorValue("NURSE")
@NoArgsConstructor
@AllArgsConstructor
public class Nurse extends Personel {

    @ManyToOne
    private Clinic clinic;


}
