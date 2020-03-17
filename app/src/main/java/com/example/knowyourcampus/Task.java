package com.example.knowyourcampus;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

enum TaskType {
    QUESTION    ("Question"),
    AR          ("Augmented Reality"),
    PICTURE     ("Picture Reproduction"),
    SELFIE      ("Selfie Time");

    private String displayName;

    TaskType(String displayName) {
        this.displayName = displayName;
    }

    public String toString() {
        return displayName;
    }
}


public class Task implements Serializable {
    public static Map<TaskType, Class> typeToString = new HashMap<TaskType, Class>() {{
        put(TaskType.QUESTION, TaskQuestionIntroduction.class);
        put(TaskType.AR, TaskARIntroduction.class);
        put(TaskType.PICTURE, TaskQuestionIntroduction.class);
        put(TaskType.SELFIE, TaskQuestionIntroduction.class);
    }};

    private static Map<TaskType, Class> taskTypeToActivity = new HashMap<TaskType, Class>() {{
        put(TaskType.QUESTION, TaskQuestionIntroduction.class);
        put(TaskType.AR, TaskARIntroduction.class);
        put(TaskType.PICTURE, TaskQuestionIntroduction.class);
        put(TaskType.SELFIE, TaskQuestionIntroduction.class);
    }};


    private TaskType type;
    private Class activity;
    private String infoReward;
    private boolean isCompleted = false;

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public Task(String infoReward, TaskType type) {
        this.infoReward = infoReward;
        this.type = type;
        this.activity = taskTypeToActivity.get(type);
    }

    public String getInfoReward() {
        return infoReward;
    }
    public Class getActivity() {
        return activity;
    }
    public TaskType getType() {
        return type;
    }

}
