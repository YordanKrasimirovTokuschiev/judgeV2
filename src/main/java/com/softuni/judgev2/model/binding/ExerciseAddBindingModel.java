package com.softuni.judgev2.model.binding;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

public class ExerciseAddBindingModel {

    @Size(min = 2, message = "Name must be minimum two characters")
    private String name;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @PastOrPresent(message = "The date cannot be in the future")
    private LocalDateTime startedOn;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @FutureOrPresent(message = "The date cannot be in the past")
    private LocalDateTime dueDate;

    public ExerciseAddBindingModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getStartedOn() {
        return startedOn;
    }

    public void setStartedOn(LocalDateTime startedOn) {
        this.startedOn = startedOn;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }
}
