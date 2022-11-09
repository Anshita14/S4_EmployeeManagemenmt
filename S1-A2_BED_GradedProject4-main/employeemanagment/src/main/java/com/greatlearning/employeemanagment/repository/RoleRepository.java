package com.greatlearning.employeemanagment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greatlearning.employeemanagment.model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>{

}
