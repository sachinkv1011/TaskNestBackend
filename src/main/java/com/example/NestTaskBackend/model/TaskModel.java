package com.example.NestTaskBackend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "task")
public class TaskModel {
    @Id
    @GeneratedValue()
    private int id;
    private String taskTitle;
    private String assignDate;
    private String taskDueDate;
    private String remarks;
    private String status;
    private int empId;

    public TaskModel() {
    }

    public TaskModel(int id, String taskTitle, String assignDate, String taskDueDate, String remarks, String status, int empId) {
        this.id = id;
        this.taskTitle = taskTitle;
        this.assignDate = assignDate;
        this.taskDueDate = taskDueDate;
        this.remarks = remarks;
        this.status = status;
        this.empId = empId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTaskTitle() {
        return taskTitle;
    }

    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }

    public String getAssignDate() {
        return assignDate;
    }

    public void setAssignDate(String assignDate) {
        this.assignDate = assignDate;
    }

    public String getTaskDueDate() {
        return taskDueDate;
    }

    public void setTaskDueDate(String taskDueDate) {
        this.taskDueDate = taskDueDate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }
}
