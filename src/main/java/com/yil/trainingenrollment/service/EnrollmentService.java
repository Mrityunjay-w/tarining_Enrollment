package com.yil.trainingenrollment.service;


import com.yil.trainingenrollment.model.Enrollment;
import com.yil.trainingenrollment.model.Training;
import com.yil.trainingenrollment.repository.EnrollmentRepository;
import com.yil.trainingenrollment.repository.TrainingRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class EnrollmentService {

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Autowired
    private TrainingRepository trainingRepository;

    public boolean saveEnrollment(Enrollment enrollment) {

        Training training = enrollment.getTraining();

        // Reload the training from the database to ensure we have the latest state
        Training persistedTraining = trainingRepository.findById(training.getBatch_code())
                .orElseThrow(() -> new IllegalArgumentException("Invalid training ID"));

        // Check if the training batch is full
        if (persistedTraining.getCurrentEnrollments() >= persistedTraining.getMaxEnrollments()) {
            return false;  // Enrollment not allowed
        }

        // Increment the current enrollments count
        persistedTraining.setCurrentEnrollments(persistedTraining.getCurrentEnrollments() + 1);

        // Save the updated training entity
        trainingRepository.save(persistedTraining);

        // Save the enrollment
        enrollmentRepository.save(enrollment);

        return true;
    }

    public List<Enrollment> getAllEnrollments() {
        return enrollmentRepository.findAll();
    }


}
