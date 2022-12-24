package com.example.NestTaskBackend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "employee")
public class EmployeeModel {
    @Id
    @GeneratedValue()
    private int id;
    private int empCode;
    private String empName;
    private String empEmail;
    private String empPhone;
    private String designation;
    private int empSalary;
    private String username;
    private String password;

    public EmployeeModel() {
    }

    public EmployeeModel(int id, int empCode, String empName, String empEmail, String empPhone, String designation, int empSalary, String username, String password) {
        this.id = id;
        this.empCode = empCode;
        this.empName = empName;
        this.empEmail = empEmail;
        this.empPhone = empPhone;
        this.designation = designation;
        this.empSalary = empSalary;
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEmpCode() {
        return empCode;
    }

    public void setEmpCode(int empCode) {
        this.empCode = empCode;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpEmail() {
        return empEmail;
    }

    public void setEmpEmail(String empEmail) {
        this.empEmail = empEmail;
    }

    public String getEmpPhone() {
        return empPhone;
    }

    public void setEmpPhone(String empPhone) {
        this.empPhone = empPhone;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public int getEmpSalary() {
        return empSalary;
    }

    public void setEmpSalary(int empSalary) {
        this.empSalary = empSalary;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
