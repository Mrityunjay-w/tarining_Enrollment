package com.yil.trainingenrollment.model;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "enrollments")
@Data
public class Enrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;

    @Column(unique = true)
    private String employeeId;

    private String company;
    private String country;

    @ManyToOne
    @JoinColumn(name = "training_id")
    private Training training;

    private String poc;




}
