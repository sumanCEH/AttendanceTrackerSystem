package com.capgemini.entity;

import com.capgemini.annotation.ValidPassword;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Pattern.Flag;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "Employee-Table")
public class Employee {

	@Id
	@NotNull(message = "Employee ID may not be null")
	private Long employeeId;

	@NotEmpty(message = "Name may not be empty")
	@Size(min = 2, max = 32, message = "Name must be between 2 and 32 characters long")
	private String employeeName;

	@Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}",
            flags = Pattern.Flag.CASE_INSENSITIVE)
	@NotEmpty(message = "Email may not be empty")
	private String employeeEmail;

	@NotEmpty(message = "Name may not be empty")
	@Size(min = 2, max = 32, message = "Name must be between 2 and 32 characters long")
	private String superVisorName;

	@NotEmpty(message = "Name may not be empty")
	@Size(min = 2, max = 32, message = "Name must be between 2 and 32 characters long")
	private String managerName;

	@NotEmpty(message = "Name may not be empty")
	@ValidPassword(message = "The password length must be between 8 and 30 characters.||"
			+ "The password must contain at least 1 uppercase letter.||"
			+ "The password must contain at least 1 lowercase letter.||"
			+ "The password must contain at least 1 digit character.||"
			+ "The password must contain at least 1 symbol (special character).||"
			+ "The password cannot match any word from the dictionary (e.g., \"password\", \"123456\", \"qwerty\").")
	private String employeePassword;

	@NotEmpty(message = "Role may not be empty")
	private String role;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Employee(@NotNull(message = "Employee ID may not be null") Long employeeId,
			@NotEmpty(message = "Name may not be empty") @Size(min = 2, max = 32, message = "Name must be between 2 and 32 characters long") String employeeName,
			@Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}", flags = Flag.CASE_INSENSITIVE) @NotEmpty(message = "Email may not be empty") String employeeEmail,
			@NotEmpty(message = "Name may not be empty") @Size(min = 2, max = 32, message = "Name must be between 2 and 32 characters long") String superVisorName,
			@NotEmpty(message = "Name may not be empty") @Size(min = 2, max = 32, message = "Name must be between 2 and 32 characters long") String managerName,
			@NotEmpty(message = "Name may not be empty") String employeePassword,
			@NotEmpty(message = "Role may not be empty") String role) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employeeEmail = employeeEmail;
		this.superVisorName = superVisorName;
		this.managerName = managerName;
		this.employeePassword = employeePassword;
		this.role = role;
	}



	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeeEmail() {
		return employeeEmail;
	}

	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}

	public String getSuperVisorName() {
		return superVisorName;
	}

	public void setSuperVisorName(String superVisorName) {
		this.superVisorName = superVisorName;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public String getEmployeePassword() {
		return employeePassword;
	}

	public void setEmployeePassword(String employeePassword) {
		this.employeePassword = employeePassword;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", employeeEmail="
				+ employeeEmail + ", superVisorName=" + superVisorName + ", managerName=" + managerName
				+ ", employeePassword=" + employeePassword + ", role=" + role + "]";
	}

}
