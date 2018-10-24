package com.ceribit.android.testingwithtoys.Models;

public class Task {
    private String title;
    private String description;
    int resourceID;

    public Task(String title, String description){
        this.title = title;
        this.description = description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return title + ":" + description;
    }
}
