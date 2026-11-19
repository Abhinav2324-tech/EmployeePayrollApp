package com.bridgelabz.employeepayrollapp.controller;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.dto.ResponseDTO;
import com.bridgelabz.employeepayrollapp.service.IEmployeePayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Handles payroll HTTP requests and delegates payroll operations to the service.
 */
@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {

    private final IEmployeePayrollService employeePayrollService;

    @Autowired
    public EmployeePayrollController(IEmployeePayrollService employeePayrollService) {
        this.employeePayrollService = employeePayrollService;
    }

    @GetMapping({"", "/", "/get"})
    public ResponseEntity<ResponseDTO> getEmployeePayrollData() {
        return ResponseEntity.ok(new ResponseDTO(
                "Get Call Successful", employeePayrollService.getEmployeePayrollData()));
    }

    @GetMapping("/get/{empId}")
    public ResponseEntity<ResponseDTO> getEmployeePayrollDataById(
            @PathVariable("empId") int empId) {
        return ResponseEntity.ok(new ResponseDTO(
                "Get Call for ID Successful",
                employeePayrollService.getEmployeePayrollDataById(empId)));
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> addEmployeePayrollData(
            @RequestBody EmployeePayrollDTO request) {
        return ResponseEntity.ok(new ResponseDTO(
                "Created Employee Payroll Data",
                employeePayrollService.createEmployeePayrollData(request)));
    }

    @PutMapping("/update/{empId}")
    public ResponseEntity<ResponseDTO> updateEmployeePayrollData(
            @PathVariable("empId") int empId,
            @RequestBody EmployeePayrollDTO request) {
        return ResponseEntity.ok(new ResponseDTO(
                "Updated Employee Payroll Data",
                employeePayrollService.updateEmployeePayrollData(empId, request)));
    }
    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<ResponseDTO> deleteEmployeePayrollData(
            @PathVariable("empId") int empId) {
        employeePayrollService.deleteEmployeePayrollData(empId);
        return ResponseEntity.ok(new ResponseDTO("Deleted Successfully", empId));
    }
}