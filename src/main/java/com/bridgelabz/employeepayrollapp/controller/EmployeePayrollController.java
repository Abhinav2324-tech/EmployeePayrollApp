package com.bridgelabz.employeepayrollapp.controller;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Handles the five payroll REST operations for Section 1 UC 2.
 * Returns confirmation messages without storing employee records yet.
 */
@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {

    @GetMapping({"", "/", "/get"})
    public ResponseEntity<String> getEmployeePayrollData() {
        return ResponseEntity.ok("Get Call Success");
    }

    @GetMapping("/get/{empId}")
    public ResponseEntity<String> getEmployeePayrollData(
            @PathVariable("empId") int empId) {
        return ResponseEntity.ok("Get Call Success for ID " + empId);
    }

    @PostMapping("/create")
    public ResponseEntity<String> addEmployeePayrollData(
            @RequestBody EmployeePayrollDTO employee) {
        return ResponseEntity.ok("Created Employee Payroll Data for " + employee);
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateEmployeePayrollData(
            @RequestBody EmployeePayrollDTO employee) {
        return ResponseEntity.ok("Updated Employee Payroll Data for " + employee);
    }

    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<String> deleteEmployeePayrollData(
            @PathVariable("empId") int empId) {
        return ResponseEntity.ok("Delete Call Success for ID " + empId);
    }
}