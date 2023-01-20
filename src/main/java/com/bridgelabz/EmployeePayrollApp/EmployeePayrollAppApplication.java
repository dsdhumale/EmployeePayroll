package com.bridgelabz.EmployeePayrollApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class EmployeePayrollAppApplication {

	public static void main(String[] args) {
		System.out.println("Welcome to Employee Payroll Service Application");
		SpringApplication.run(EmployeePayrollAppApplication.class, args);
		log.info("Logging startes.............");
		System.out.println("Started......");

	}
}
