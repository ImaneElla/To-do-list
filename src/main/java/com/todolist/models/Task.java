package com.todolist.models;  

public class Task {
    private String description;
    private boolean isDone;

    // Constructor to initialize a new task
    public Task (String description) {
        this.description = description;
        this.isDone = false;
    }

    // Method to toggle the status
    public void markAsDone() {
        this.isDone = true;
    }

    // Getter for the description
    public String getDescription() {
        return description;
    }

    // Getter for the status
    public boolean isDone() {
        return isDone;
    }







}
