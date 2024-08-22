package com.yil.trainingenrollment.service;


import com.yil.trainingenrollment.model.Training;
import com.yil.trainingenrollment.repository.TrainingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainingService {

    @Autowired
    private TrainingRepository trainingRepository;


    public Training saveTraining(Training training) {
        return trainingRepository.save(training);
    }

    public List<Training> getAllTrainings(){
        //System.out.println("Trainings: " + trainings);
        return trainingRepository.findAll();
    }


}
