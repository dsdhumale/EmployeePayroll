package com.bridgelabz.EmployeePayrollApp.dto;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.*;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeePayrollDto {

    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$",message = "Employee name invalid!")
    public String name;
    @Min(value = 5000, message = "Min salary should be more than 5000 ")
    public long salary;
    @NotEmpty(message = "Profile pic Should not be null")
    private String profilePic;
    @NotEmpty(message = "Gender Should not be null")
    private String gender;
    @NotEmpty(message = "Notes Should not be null")
    private String notes;

    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern="dd MM yyyy")
    @NotNull(message="StartDate should not be empty")
    @PastOrPresent(message="startDate should be past or todays date")
    private LocalDate startDate;
    @NotEmpty(message = "Dept Should not be null")
    private List<String> departments;


}
