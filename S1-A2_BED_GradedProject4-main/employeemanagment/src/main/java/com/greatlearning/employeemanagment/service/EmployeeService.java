package com.greatlearning.employeemanagment.service;

import com.greatlearning.employeemanagment.repository.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.greatlearning.employeemanagment.model.*;

@Service

public class EmployeeService {

	private Set<Employee> employee = new HashSet<>();

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	MiscService miscService;

	public Employee addEmployee(Employee employee) {
		Employee savedEmployee = employeeRepository.save(employee);
		return savedEmployee;
	}

	public List<Employee> fetchAll() {

		return employeeRepository.findAll();

	}

	public Employee fetchById(int id) {

		return employeeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid Id"));
	}

	public void deleteEmployee(int id) {

		employeeRepository.deleteById(id);
	}

	public Employee updateEmployee(int id, Employee employee) {

		Employee repEmployee = this.fetchById(id);
		repEmployee.setFname(employee.getFname());
		repEmployee.setLname(employee.getLname());
		repEmployee.setHierarchy(employee.getHierarchy());
		repEmployee.setEmail(employee.getEmail());
		employeeRepository.saveAndFlush(repEmployee);
		return repEmployee;

	}

	public Set<Employee> fetchByName(String name) {

//		List <Employee> empWithName=new ArrayList();
//		ListIterator<Employee> list=empWithName.listIterator();

		Set<Employee> empWithName = new HashSet<>();

		// Set<Employee> employee = this.fetchAll();

		for (Employee emp : employee) {
			if (emp.getFname().equals(name)) {
				empWithName.add(emp);
			}
		}
		return empWithName;
	}

	public List<Employee> fetchByOrder(String order) {
		List<Employee> employee = new ArrayList<>(employeeRepository.findAll());
		Collections.sort(employee, new Sortbyname());
		if (order.equals("asc")) {
			return employee;
		} else {
			Collections.reverse(employee);
			return employee;
		}
	}

	public void createRoleIfNotFound(String parameter) {
		Role role = new Role();
		if (miscService.checkExistingRole(parameter) == false) {
			role.setRole_name(parameter);
			roleRepository.saveAndFlush(role);
		} else {
			System.out.println("Role - ADMIN & USER Exist");
		}
	}

	public void createDefaultEmployeeAndUser() {
		if (employeeRepository.existsById(1)) {
			System.out.println("Default Employee and User Exist");
		} else {
			Employee employee = new Employee();
			User user = new User();
			Role role = roleRepository.findById(1).get();
			user.setUsername("admin");
			user.setPassword("qwerty");// securityConfig.passwordEncoder().encode(
			user.setRoles(role);
			employee.setUser(user);
			employee.setFname("Anshita");
			employee.setLname("Tripathi");
			employee.setEmail("vyh@gmail.com");
			employee.setHierarchy(1);
			System.out.println(employee);
			employeeRepository.saveAndFlush(employee);
		}
	}

}
