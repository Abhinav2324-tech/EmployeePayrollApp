package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;
import java.util.List;

/**
 * Defines the payroll operations the controller can call.
 */
public interface IEmployeePayrollService {

    List<EmployeePayrollData> getEmployeePayrollData();

    EmployeePayrollData getEmployeePayrollDataById(int empId);

    EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO request);

    EmployeePayrollData updateEmployeePayrollData(int empId, EmployeePayrollDTO request);

    void deleteEmployeePayrollData(int empId);

    Object updateEmployeePayrollData(EmployeePayrollDTO request);
}