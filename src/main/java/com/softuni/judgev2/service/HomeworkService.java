package com.softuni.judgev2.service;

import com.softuni.judgev2.model.entity.Homework;
import com.softuni.judgev2.model.service.HomeworkServiceModel;

public interface HomeworkService {
    void addHomework(String exercise, String gitAddress);

    HomeworkServiceModel findHomeworkForScoring();

    Homework findById(Long homeworkId);
}
