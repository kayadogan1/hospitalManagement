package com.example.HastaneSistemi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Inheritance(strategy = InheritanceType.JOINED) // Veya JOINED/TABLE_PER_CLASS
@DiscriminatorColumn(name = "personel_type", discriminatorType = DiscriminatorType.STRING)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Personel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    @Column( nullable = false)
    private String Name;
    @Column( nullable = false)
    private String Surname;
    @Column( nullable = false,unique = true)
    private String identityNo;
    @Column
    private String address;
    @Column( nullable = false)
    private String title;


}
