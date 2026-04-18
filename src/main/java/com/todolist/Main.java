package com.todolist;

import com.todolist.managers.TodoManager;
import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        TodoManager manager = new TodoManager();

        // 1. Setup the Frame
        JFrame frame = new JFrame("Imane's Professional To-Do");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        
        // Use a Panel with BoxLayout to stack elements vertically in the center
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // 2. UI Components
        JLabel titleLabel = new JLabel("My Tasks Manager");
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT); // Center the label
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));

        JTextField taskInput = new JTextField();
        taskInput.setMaximumSize(new Dimension(300, 30)); // Limit width to keep it centered
        taskInput.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton addButton = new JButton("Add Task");
        addButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        // The List Model (The engine for the list)
        DefaultListModel<String> listModel = new DefaultListModel<>();
        JList<String> taskListUI = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(taskListUI);
        scrollPane.setMaximumSize(new Dimension(300, 150));
        scrollPane.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton doneButton = new JButton("Mark as Done");
        doneButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel statusLabel = new JLabel("Total Completed: 0");
        statusLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // 3. Logic - Add Button Action
        addButton.addActionListener(e -> {
            String text = taskInput.getText();
            if (!text.isEmpty()) {
                manager.addTask(text);
                listModel.addElement(text); // Add text to the UI list
                taskInput.setText("");
                statusLabel.setText("Total Completed: " + manager.calculateTotalDone());
            }
        });

        // 4. Logic - Mark as Done Action
        doneButton.addActionListener(e -> {
            int selectedIndex = taskListUI.getSelectedIndex();
            if (selectedIndex != -1) {
                manager.markTaskAsDone(selectedIndex);
                // Update UI text to show it's done
                String updatedText = listModel.getElementAt(selectedIndex) + " ✅";
                listModel.set(selectedIndex, updatedText);
                
                // Update the counter using your calculation logic
                statusLabel.setText("Total Completed: " + manager.calculateTotalDone());
            }
        });

        // 5. Adding everything to the panel (Centered)
        mainPanel.add(titleLabel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Spacer
        mainPanel.add(taskInput);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        mainPanel.add(addButton);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        mainPanel.add(scrollPane);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        mainPanel.add(doneButton);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        mainPanel.add(statusLabel);

        frame.add(mainPanel);
        frame.setLocationRelativeTo(null); // Center window on screen
        frame.setVisible(true);
    }
}