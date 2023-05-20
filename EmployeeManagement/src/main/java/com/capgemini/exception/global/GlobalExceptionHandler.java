package com.capgemini.exception.global;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.capgemini.exception.EmployeeAlreadyExistsException;
import com.capgemini.exception.EmployeeNotFoundException;
import com.capgemini.exception.ThisPasswordAlreadyExistException;
import com.capgemini.payload.ErrorResponse;
import com.capgemini.payload.ValidationErrorResponse;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Object> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
		ValidationErrorResponse validationErrorResponse = new ValidationErrorResponse(HttpStatus.BAD_REQUEST,
				"Validation error", null);
		List<String> errors = ex.getBindingResult().getFieldErrors().stream().map(FieldError::getDefaultMessage)
				.collect(Collectors.toList());
		validationErrorResponse.setErrors(errors);
		return new ResponseEntity<>(validationErrorResponse, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(EmployeeAlreadyExistsException.class)
	public ResponseEntity<Object> handleEmployeeAlreadyExistsException(EmployeeAlreadyExistsException ex) {
		ErrorResponse errorResponse = new ErrorResponse(HttpStatus.CONFLICT, "Employee already exists");
		return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
	}

	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<Object> handleEmployeeNotFoundException(EmployeeNotFoundException ex) {
		ErrorResponse errorResponse = new ErrorResponse(HttpStatus.NOT_FOUND, "Employee does not exists");
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(ThisPasswordAlreadyExistException.class)
	public ResponseEntity<Object> handleThisPasswordAlreadyExistException(ThisPasswordAlreadyExistException ex) {
		ErrorResponse errorResponse = new ErrorResponse(HttpStatus.CONFLICT, "This Password Already exists");
		return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
	}


	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleException(Exception ex) {
		ErrorResponse errorResponse = new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Internal server error");
		return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
