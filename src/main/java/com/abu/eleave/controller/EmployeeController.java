package com.abu.eleave.controller;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.abu.eleave.model.Employee;
import com.abu.eleave.repository.EmployeeDao;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	EmployeeDao employeeDao;

	@GetMapping("/employee")
	public List<Employee> getAll() {
		return employeeDao.findAll();
	}

	// controller ambil employe berdasarkan id
	/**
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/employee/{id}")
	public Employee finEmployeeById(@PathVariable long id) {
		Optional<Employee> karyawan = employeeDao.findById(id);

		if (!karyawan.isPresent())
			throw new EntityNotFoundException("id-" + id);

		return karyawan.get();
	}

	// controller login proses
	/**
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	@GetMapping("/employee/login")
	public Employee loginProcess(@RequestParam(value = "username") String username,
			@RequestParam(value = "password") String password) {
		Optional<Employee> karyawan = employeeDao.findByUsernameAndPassword(username, password);

		if (!karyawan.isPresent())
			throw new EntityNotFoundException("Username-" + username);

		return karyawan.get();
	}

	// controller add new user
	/**
	 * 
	 * @param employee
	 * @return
	 */
	@PostMapping(value = "/employee", produces = "application/json", consumes = "application/json")
	@ResponseBody
	public Employee addNewEmployee(@Valid @RequestBody Employee employee) {
		return employeeDao.save(employee);
	}

}
