package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

/**
 * Stores employee payroll records in memory while the application runs.
 */
@Service
public  class EmployeePayrollService implements IEmployeePayrollService {

    private final List<EmployeePayrollData> employees = new ArrayList<>();
    private int nextEmployeeId = 1;

    @Override
    public synchronized List<EmployeePayrollData> getEmployeePayrollData() {
        return List.copyOf(employees);
    }

    @Override
    public synchronized EmployeePayrollData getEmployeePayrollDataById(int empId) {
        return employees.get(findEmployeeIndex(empId));
    }

    @Override
    public synchronized EmployeePayrollData createEmployeePayrollData(
            EmployeePayrollDTO request) {
        EmployeePayrollData employee = new EmployeePayrollData(nextEmployeeId++, request);
        employees.add(employee);
        return employee;
    }

    @Override
    public synchronized EmployeePayrollData updateEmployeePayrollData(
            int empId, EmployeePayrollDTO request) {
        int index = findEmployeeIndex(empId);
        EmployeePayrollData updatedEmployee = new EmployeePayrollData(empId, request);
        employees.set(index, updatedEmployee);
        return updatedEmployee;
    }

    @Override
    public synchronized void deleteEmployeePayrollData(int empId) {
        employees.remove(findEmployeeIndex(empId));
    }

    @Override
    public Object updateEmployeePayrollData(EmployeePayrollDTO request) {
        return null;
    }

    private int findEmployeeIndex(int empId) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getEmployeeId() == empId) {
                return i;
            }
        }

        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Employee not found with ID " + empId);
    }
}