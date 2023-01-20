package com.bridgelabz.EmployeePayrollApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.EmployeePayrollApp.dto.EmployeePayrollDto;
import com.bridgelabz.EmployeePayrollApp.exception.EmployeePayrollException;
import com.bridgelabz.EmployeePayrollApp.model.EmployeePayrollData;
import com.bridgelabz.EmployeePayrollApp.repository.EmployeePayrollRepo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmployeePayrollService implements IEmployeePayrollService {

    @Autowired
    EmployeePayrollRepo employeePayrollRepo;

    @Override
    public EmployeePayrollData createDetails(EmployeePayrollDto employeePayrollDto) {
        EmployeePayrollData employeeData = new EmployeePayrollData(employeePayrollDto.getName(),
                employeePayrollDto.getSalary(), employeePayrollDto.getProfilePic(),
                employeePayrollDto.getGender(), employeePayrollDto.getNotes(), 
                employeePayrollDto.getStartDate(), employeePayrollDto.getDepartments());
        System.out.println("testing employee data" + employeeData);
        return employeePayrollRepo.save(employeeData);
    }

    @Override
    public EmployeePayrollData getDetailsById(int id) throws EmployeePayrollException {
        EmployeePayrollData employeeData = employeePayrollRepo.findById(id).orElseThrow(()-> new EmployeePayrollException("Employee payroll data not found for id "+id));
            return employeeData;   
    }

    @Override
    public List<EmployeePayrollData> getAllDetails() {
        return employeePayrollRepo.findAll();
    }

    @Override
    public EmployeePayrollData updateDetails(int id, EmployeePayrollDto employeePayrollDto) throws EmployeePayrollException {
        EmployeePayrollData eData = employeePayrollRepo.findById(id).orElseThrow(()-> new EmployeePayrollException("Employee payroll data not found for id "+id));
        eData.setName(employeePayrollDto.getName());
        eData.setSalary(employeePayrollDto.getSalary());
        eData.setProfilePic(employeePayrollDto.getProfilePic());
        eData.setGender(employeePayrollDto.getGender());
        eData.setNotes(employeePayrollDto.getNotes());
        eData.setStartDate(employeePayrollDto.getStartDate());
        eData.setDepartments(employeePayrollDto.getDepartments());

        return employeePayrollRepo.save(eData);

    }

    @Override
    public void deleteDetailsById(int id) {
        employeePayrollRepo.deleteById(id);
    }

    @Override
    public List<EmployeePayrollData> getEmployeePayrollByDepartment(String departments) {
        return employeePayrollRepo.findEmployeePayrollByData(departments);
    }
}
