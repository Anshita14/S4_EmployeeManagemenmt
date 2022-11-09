package com.greatlearning.employeemanagment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import com.greatlearning.employeemanagment.model.Role;
import com.greatlearning.employeemanagment.repository.RoleRepository;
@Service
public class MiscService {
	@Autowired
	RoleRepository roleRepository;

	public boolean checkExistingRole(String parameter) {
		Role role = new Role();
		role.setRole_name(parameter);
		ExampleMatcher exampleMatcher = ExampleMatcher.matching()
				.withMatcher(parameter, ExampleMatcher.GenericPropertyMatchers.exact())
				.withIgnorePaths("role_id", "users");
		Example<Role> roleExample = Example.of(role, exampleMatcher);
		return roleRepository.exists(roleExample);
	}
}
