package com.softuni.judgev2.service.impl;

import com.softuni.judgev2.model.entity.Exercise;
import com.softuni.judgev2.model.service.ExerciseServiceModel;
import com.softuni.judgev2.repository.ExerciseRepository;
import com.softuni.judgev2.service.ExerciseService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ExerciseServiceImpl implements ExerciseService {

    private final ExerciseRepository exerciseRepository;
    private final ModelMapper modelMapper;

    public ExerciseServiceImpl(ExerciseRepository exerciseRepository, ModelMapper modelMapper) {
        this.exerciseRepository = exerciseRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void addExercise(ExerciseServiceModel exerciseServiceModel) {
        exerciseRepository
                .save(modelMapper
                        .map(exerciseServiceModel, Exercise.class));
    }

    @Override
    public List<String> findAllExNames() {

        return exerciseRepository
                .findAllExerciseNames();
    }

    @Override
    public boolean checkIfIsLate(String exercise) {

        Exercise exerciseEntity = exerciseRepository
                .findByName(exercise)
                .orElse(null);

        return exerciseEntity
                .getDueDate().isBefore(LocalDateTime.now());
    }

    @Override
    public Exercise findByName(String name) {
        return exerciseRepository
                .findByName(name)
                .orElse(null);
    }
}
