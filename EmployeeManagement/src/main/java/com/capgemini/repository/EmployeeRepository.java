package com.capgemini.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capgemini.entity.Employee;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
		
	@Query("SELECT e FROM Employee e WHERE e.employeeEmail = ?1")
    Optional<Employee> existsByEmail(String employeeEmail);



}
