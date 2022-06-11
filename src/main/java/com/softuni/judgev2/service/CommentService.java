package com.softuni.judgev2.service;

import com.softuni.judgev2.model.service.CommentServiceModel;

import java.util.Map;

public interface CommentService {

    void add(CommentServiceModel serviceModel, Long homeworkId);

    Double findAvgScore();

    Map<Integer, Integer> findScoreMap();
}
