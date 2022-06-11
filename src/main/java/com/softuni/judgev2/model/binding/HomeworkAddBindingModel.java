package com.softuni.judgev2.model.binding;

import javax.validation.constraints.Pattern;

public class HomeworkAddBindingModel {

    private String exercise;

    @Pattern(regexp = "https:\\/\\/github\\.com\\/.+", message = "Enter valid git address")
    private String gitAddress;

    public HomeworkAddBindingModel() {
    }

    public String getExercise() {
        return exercise;
    }

    public void setExercise(String exercise) {
        this.exercise = exercise;
    }

    public String getGitAddress() {
        return gitAddress;
    }

    public void setGitAddress(String gitAddress) {
        this.gitAddress = gitAddress;
    }
}
