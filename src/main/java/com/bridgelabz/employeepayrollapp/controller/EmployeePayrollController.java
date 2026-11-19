package com.bridgelabz.employeepayrollapp.controller;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.dto.ResponseDTO;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Returns payroll responses as JSON without storing employee records yet.
 */
@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {

    @GetMapping({"", "/", "/get"})
    public ResponseEntity<ResponseDTO> getEmployeePayrollData() {
        EmployeePayrollData employee = new EmployeePayrollData(1, "Pankaj", 30000);
        return ResponseEntity.ok(new ResponseDTO("Get Call Successful", employee));
    }

    @GetMapping("/get/{empId}")
    public ResponseEntity<ResponseDTO> getEmployeePayrollData(
            @PathVariable("empId") int empId) {
        EmployeePayrollData employee = new EmployeePayrollData(empId, "Pankaj", 30000);
        return ResponseEntity.ok(new ResponseDTO("Get Call for ID Successful", employee));
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> addEmployeePayrollData(
            @RequestBody EmployeePayrollDTO request) {
        EmployeePayrollData employee = new EmployeePayrollData(1, request);
        return ResponseEntity.ok(new ResponseDTO("Created Employee Payroll Data", employee));
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseDTO> updateEmployeePayrollData(
            @RequestBody EmployeePayrollDTO request) {
        EmployeePayrollData employee = new EmployeePayrollData(1, request);
        return ResponseEntity.ok(new ResponseDTO("Updated Employee Payroll Data", employee));
    }

    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<ResponseDTO> deleteEmployeePayrollData(
            @PathVariable("empId") int empId) {
        return ResponseEntity.ok(new ResponseDTO("Deleted Successfully", empId));
    }
}