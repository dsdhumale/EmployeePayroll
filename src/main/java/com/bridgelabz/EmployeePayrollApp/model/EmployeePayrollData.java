package com.bridgelabz.EmployeePayrollApp.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;


@Data
@Table(name="employee_payroll_data")
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class EmployeePayrollData {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employee_id;
    private String name;
    private long salary;
    private String profilePic;
    private String gender;
    private String notes;
    private LocalDate startDate;
    @ElementCollection
    @CollectionTable(name = "payroll_department", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "department")
    private List<String> departments;

    public EmployeePayrollData(String name, long salary, String profilePic, String gender,String notes,LocalDate startDate,List<String> departments) {
        this.name = name;
        this.salary = salary;
        this.profilePic = profilePic;
        this.gender = gender;
        this.notes = notes;
        this.startDate = startDate;
        this.departments = departments;
    }

}
