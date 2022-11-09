package com.greatlearning.employeemanagment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greatlearning.employeemanagment.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	
	
	
}
