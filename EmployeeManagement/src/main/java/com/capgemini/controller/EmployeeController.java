package com.capgemini.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.entity.Employee;
import com.capgemini.entity.ResetPasswordRequest;
import com.capgemini.exception.EmployeeAlreadyExistsException;
import com.capgemini.exception.EmployeeNotFoundException;
import com.capgemini.exception.ThisPasswordAlreadyExistException;
import com.capgemini.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/home")
	public ResponseEntity<String> home() {
		return ResponseEntity.ok("Welcome To Employee Management DashBoard");
	}

	@PostMapping("/add")
	public ResponseEntity<Employee> addEmployee(@Valid @RequestBody Employee employee)
			throws EmployeeAlreadyExistsException {
		Employee employee1 = employeeService.addEmployee(employee);
		return ResponseEntity.status(HttpStatus.CREATED).body(employee1);
	}

	@GetMapping("/get/all")
	public ResponseEntity<List<Employee>> getAllCourse() {
		List<Employee> allEmployee = employeeService.fetchAllEmployee();
		return ResponseEntity.ok(allEmployee);
	}

	// Get course by id
	@GetMapping("/get/{employeeId}")
	public ResponseEntity<Optional<Employee>> getEmployeeById(@PathVariable Long employeeId)
			throws EmployeeNotFoundException {
		Optional<Employee> employee = employeeService.fetchEmployeeById(employeeId);
		// return ResponseEntity.ok(employee);
		return ResponseEntity.status(HttpStatus.FOUND).body(employee);
	}

	@PatchMapping("/{employeeId}/reset-password")
	public ResponseEntity<String> resetPassword(@PathVariable Long employeeId,
			@Valid @RequestBody ResetPasswordRequest resetPasswordRequest)
			throws EmployeeNotFoundException, ThisPasswordAlreadyExistException {

		employeeService.resetPassword(employeeId, resetPasswordRequest.getNewPassword());
		return ResponseEntity.status(HttpStatus.OK).body("Password reset successfully");

	}

}
