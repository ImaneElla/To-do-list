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
    // Logic to remove a task by its index (position in the list)
    public void removeTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
        }
    }
    public List<String> getTaskDescriptions() {
    List<String> descriptions = new ArrayList<>();
    for (Task t : tasks) {
        descriptions.add(t.getDescription());
    }
    return descriptions;
}
// Logic to toggle a task as completed using its position
public void markTaskAsDone(int index) {
    if (index >= 0 && index < tasks.size()) {
        // We get the task from the list and use the method we built in the Task model
        tasks.get(index).markAsDone();
    }
}
}
