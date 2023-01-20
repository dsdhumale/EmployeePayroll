package com.bridgelabz.EmployeePayrollApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bridgelabz.EmployeePayrollApp.model.EmployeePayrollData;


@Repository
public interface EmployeePayrollRepo extends JpaRepository<EmployeePayrollData, Integer>{
    @Query(value="select * from employee_payroll_data,employee_department where employee_id=id and departments=:departments",nativeQuery=true)
    List<EmployeePayrollData> findEmployeePayrollByData(String departments);
}
