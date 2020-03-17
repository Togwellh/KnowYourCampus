package com.example.knowyourcampus;

enum TaskType {
    QUESTION,
    AR,
    PICTURE,
    SELFIE
}

public class Task {
    private TaskType type = null;
    private String infoReward;

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    private boolean isCompleted = false;

    public Task(String infoReward, TaskType type) {
        this.infoReward = infoReward;
    }

    public String getInfoReward() {
        return infoReward;
    }

    public void setInfoReward(String infoReward) {
        this.infoReward = infoReward;
    }
}
