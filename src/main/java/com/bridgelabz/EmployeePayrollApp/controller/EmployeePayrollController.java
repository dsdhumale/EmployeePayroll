package com.bridgelabz.EmployeePayrollApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.EmployeePayrollApp.dto.EmployeePayrollDto;
import com.bridgelabz.EmployeePayrollApp.dto.ResponseDto;
import com.bridgelabz.EmployeePayrollApp.model.EmployeePayrollData;
import com.bridgelabz.EmployeePayrollApp.service.IEmployeePayrollService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {

    @Autowired
    IEmployeePayrollService employeePayrollService;

    // API for creating employee payroll data
    @PostMapping("/add")
    public ResponseEntity<ResponseDto> create(@Valid @RequestBody EmployeePayrollDto employeePayrollDto) {
        ResponseDto response = new ResponseDto("Employee Payroll Data Created Successfully",
                employeePayrollService.createDetails(employeePayrollDto));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // API for fetching particular employee payroll data by id
    @GetMapping("/get/{id}")
    public ResponseEntity<ResponseDto> getDetailById(@PathVariable int id) {
        ResponseDto response = new ResponseDto("Employee Payroll Data fetched Successfully ",
                employeePayrollService.getDetailsById(id));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // API for fetching all employee payroll data
    @GetMapping("/getall")
    public ResponseEntity<ResponseDto> getAllDetails() {
        ResponseDto response = new ResponseDto("All Employee Payroll Data fetched Successfully ",
                employeePayrollService.getAllDetails());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // API for delete particular employee payroll data by id
    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDto> deleteDetailById(@PathVariable int id) {
        employeePayrollService.deleteDetailsById(id);
        ResponseDto response = new ResponseDto("Employee Payroll Data deleted Successfully ",
                true);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // API for Update particular employee payroll data by id
    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseDto> create(@PathVariable int id,
            @Valid @RequestBody EmployeePayrollDto employeePayrollDto) {
        ResponseDto response = new ResponseDto("Employee Payroll Data Updated Successfully",
                employeePayrollService.updateDetails(id, employeePayrollDto));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("department/{departments}")
    public ResponseEntity<ResponseDto> getEmployeePayrollDataByDepartment(@PathVariable String departments) {
        ResponseDto response=new ResponseDto("successfully fetched payroll data by department "+departments,employeePayrollService.getEmployeePayrollByDepartment(departments));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
