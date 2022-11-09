package com.greatlearning.employeemanagment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greatlearning.employeemanagment.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
