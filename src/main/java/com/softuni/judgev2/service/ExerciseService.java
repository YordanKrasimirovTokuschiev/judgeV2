package com.softuni.judgev2.service;

import com.softuni.judgev2.model.entity.Exercise;
import com.softuni.judgev2.model.service.ExerciseServiceModel;

import java.util.List;

public interface ExerciseService {
    void addExercise(ExerciseServiceModel exerciseServiceModel);

    List<String> findAllExNames();

    boolean checkIfIsLate(String exercise);

    Exercise findByName(String name);
}
