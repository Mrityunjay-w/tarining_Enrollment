package com.yil.trainingenrollment.model;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "trainings")
public class Training {

    @Id
    private String batch_code;

    @Column(nullable = false)
    private String name;


    private int maxEnrollments;  // Maximum allowed enrollments
    private int currentEnrollments; //current enrollments

    @OneToMany(mappedBy = "training")
    private List<Enrollment> enrollments;

}
