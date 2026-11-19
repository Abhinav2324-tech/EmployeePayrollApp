package com.bridgelabz.employeepayrollapp.model;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;

/**
 * Represents an employee's payroll data inside the application.
 */
public class EmployeePayrollData {
    private int employeeId;
    private String name;
    private long salary;

    public EmployeePayrollData(int employeeId, String name, long salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.salary = salary;
    }

    public EmployeePayrollData(int employeeId, EmployeePayrollDTO employee) {
        this(employeeId, employee.name, employee.salary);
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public long getSalary() {
        return salary;
    }
}