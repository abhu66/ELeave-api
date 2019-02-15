package com.abu.eleave.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import com.abu.eleave.model.Employee;

public interface EmployeeDao extends JpaRepository<Employee, Long>  {

	Optional<Employee> findById(Long id);
	Optional<Employee> findByUsernameAndPassword(String username, String password);
}
