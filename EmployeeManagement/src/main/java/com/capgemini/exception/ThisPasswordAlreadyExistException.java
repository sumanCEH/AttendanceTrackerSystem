package com.capgemini.exception;

public class ThisPasswordAlreadyExistException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ThisPasswordAlreadyExistException(String message) {
		// TODO Auto-generated constructor stub
		super("This Password Already exist , Plz Change Your new Password");
	} 
}
