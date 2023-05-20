package com.capgemini.exception;


public class EmployeeNotFoundException extends RuntimeException {


	private static final long serialVersionUID = 1L;

//	public EmployeeNotFoundException(String message) {
//		super("Employee Does not exist");
//	}

	private final String errorMessage;

    public EmployeeNotFoundException(String message) {
        super("Employee not exist ");
        this.errorMessage = message;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
