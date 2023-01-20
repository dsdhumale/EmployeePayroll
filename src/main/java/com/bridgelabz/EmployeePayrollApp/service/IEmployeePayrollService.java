package com.bridgelabz.EmployeePayrollApp.service;

import java.util.List;

import com.bridgelabz.EmployeePayrollApp.dto.EmployeePayrollDto;
import com.bridgelabz.EmployeePayrollApp.model.EmployeePayrollData;

public interface IEmployeePayrollService {
    
    public EmployeePayrollData createDetails(EmployeePayrollDto employeePayrollDto);

    public EmployeePayrollData getDetailsById(int id);

    public List<EmployeePayrollData> getAllDetails();

    public EmployeePayrollData updateDetails(int id,EmployeePayrollDto employeePayrollDto);

    public void deleteDetailsById(int id);

    public List<EmployeePayrollData> getEmployeePayrollByDepartment(String departments);

}
