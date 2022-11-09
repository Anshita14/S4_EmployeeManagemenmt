package com.greatlearning.employeemanagment.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

import com.greatlearning.employeemanagment.service.EmployeeService;

@Configuration
public class BootStrapData {

	@Autowired
	EmployeeService employeeService;
	
	@EventListener(ApplicationReadyEvent.class)
	public void insertDefaultData(ApplicationReadyEvent event) {
		employeeService.createRoleIfNotFound("ADMIN");
		employeeService.createRoleIfNotFound("USER");
		employeeService.createDefaultEmployeeAndUser();
		
	}
}
