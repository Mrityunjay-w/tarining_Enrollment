package com.yil.trainingenrollment.repository;

import com.yil.trainingenrollment.model.Enrollment;
import com.yil.trainingenrollment.model.Training;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainingRepository extends JpaRepository<Training, String> {
}
