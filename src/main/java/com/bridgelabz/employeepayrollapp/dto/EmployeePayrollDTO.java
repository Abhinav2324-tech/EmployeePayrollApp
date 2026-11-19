package com.bridgelabz.employeepayrollapp.dto;

/**
 * Holds the name and salary received in a create or update request.
 */
public class EmployeePayrollDTO {
    public String name;
    public long salary;

    @Override
    public String toString() {
        return "name=" + name + ", salary=" + salary;
    }
}