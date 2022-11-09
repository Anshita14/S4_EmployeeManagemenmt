package com.greatlearning.employeemanagment.service;

import java.util.Comparator;

import com.greatlearning.employeemanagment.model.Employee;

public class Sortbyname implements Comparator<Employee>{
	
	public int compare(Employee a,Employee b) {
	
		return a.getFname().compareTo(b.getFname());
		
		
	} 

}
