package com.todolist.managers;

import java.util.ArrayList;
import java.util.List;

import com.todolist.models.Task;

public class TodoManager {
    private List<Task> tasks;

    public TodoManager() {
        this.tasks = new ArrayList<>();
    }
    // Adds a new task object to our list
    public void addTask(String description) {
        tasks.add(new Task (description));
    }
    // Logic to calculate how many tasks are completed
    public int calculateTotalDone(){
        int count = 0;
        for (Task task : tasks) {
            if (task.isDone()){
                count++;
            }
        }
        return count;
    }
    // Returns the list of tasks
    public List<Task> getTasks() {
        return tasks;
    }
}
