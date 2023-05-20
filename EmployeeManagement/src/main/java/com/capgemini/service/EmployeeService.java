package com.capgemini.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.capgemini.entity.Employee;
import com.capgemini.exception.EmployeeAlreadyExistsException;
import com.capgemini.exception.EmployeeNotFoundException;
import com.capgemini.exception.ThisPasswordAlreadyExistException;

@Service
public interface EmployeeService {

	Employee addEmployee(Employee employee)throws EmployeeAlreadyExistsException;

	List<Employee> fetchAllEmployee();

	Optional<Employee> fetchEmployeeById(Long employeeId)throws EmployeeNotFoundException;

	String resetPassword(Long employeeId, String newPassword) throws EmployeeNotFoundException, ThisPasswordAlreadyExistException;

}
