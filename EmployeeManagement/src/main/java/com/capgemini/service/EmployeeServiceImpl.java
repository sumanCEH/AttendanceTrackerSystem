package com.capgemini.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.entity.Employee;
import com.capgemini.exception.EmployeeAlreadyExistsException;
import com.capgemini.exception.EmployeeNotFoundException;
import com.capgemini.exception.ThisPasswordAlreadyExistException;
import com.capgemini.repository.EmployeeRepository;

import jakarta.validation.Valid;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee addEmployee(Employee employee) throws EmployeeAlreadyExistsException {

		if (employeeRepository.findById(employee.getEmployeeId()).isPresent()) {
			throw new EmployeeAlreadyExistsException("this" + employee.getEmployeeId() + "already exist");
		} else if (employeeRepository.existsByEmail(employee.getEmployeeEmail()).isPresent()) {
			throw new EmployeeAlreadyExistsException("this" + employee.getEmployeeEmail() + "already exist");
		} else {
			return employeeRepository.save(employee);
		}

	}

	@Override
	public List<Employee> fetchAllEmployee() {
		return employeeRepository.findAll();
	}

	@Override
	public Optional<Employee> fetchEmployeeById(Long employeeId) throws EmployeeNotFoundException {

		return Optional.of(employeeRepository.findById(employeeId)
				.orElseThrow(() -> new EmployeeNotFoundException("Employee Does not Exist " + employeeId)));

	}

	@Override
	public String resetPassword(Long employeeId, String newPassword)
			throws EmployeeNotFoundException, ThisPasswordAlreadyExistException {

		if (!employeeRepository.findById(employeeId).isPresent()) {
//			Employee employee2 = employeeRepository.findById(employeeId).orElseThrow(() ->
					throw new EmployeeNotFoundException("Employee not found with ID: " + employeeId);
		} else if (newPassword.equals(employeeRepository.findById(employeeId).get().getEmployeePassword())) {
			throw new ThisPasswordAlreadyExistException("this password already exist");
		}

		else {
			Employee employee2 = employeeRepository.findById(employeeId).get();
			employee2.setEmployeePassword(newPassword);
			employeeRepository.save(employee2);
			return "Password";
		}
	}
}
