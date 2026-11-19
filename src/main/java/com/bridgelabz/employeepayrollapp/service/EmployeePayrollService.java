package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Builds payroll data for the controller without storing records yet.
 */
@Service
public class EmployeePayrollService implements IEmployeePayrollService {

    @Override
    public List<EmployeePayrollData> getEmployeePayrollData() {
        return List.of(getEmployeePayrollDataById(1));
    }

    @Override
    public EmployeePayrollData getEmployeePayrollDataById(int empId) {
        return new EmployeePayrollData(empId, "Pankaj", 30000);
    }

    @Override
    public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO request) {
        return new EmployeePayrollData(1, request);
    }

    @Override
    public EmployeePayrollData updateEmployeePayrollData(EmployeePayrollDTO request) {
        return new EmployeePayrollData(1, request);
    }

    @Override
    public void deleteEmployeePayrollData(int empId) {
        // Nothing to remove until we add in-memory storage in UC 3.
    }
}