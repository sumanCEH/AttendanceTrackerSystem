package com.capgemini.entity;

import com.capgemini.annotation.ValidPassword;

import jakarta.validation.constraints.NotEmpty;

public class ResetPasswordRequest {
	@NotEmpty(message = "Name may not be empty")
	@ValidPassword(message = "The password length must be between 8 and 30 characters.||"
			+ "The password must contain at least 1 uppercase letter.||"
			+ "The password must contain at least 1 lowercase letter.||"
			+ "The password must contain at least 1 digit character.||"
			+ "The password must contain at least 1 symbol (special character).||"
			+ "The password cannot match any word from the dictionary (e.g., \"password\", \"123456\", \"qwerty\").")
	private String newPassword;

	

	public ResetPasswordRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ResetPasswordRequest(@NotEmpty(message = "Name may not be empty") String newPassword) {
		super();
		this.newPassword = newPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	
	@Override
	public String toString() {
		return "ResetPasswordRequest [newPassword=" + newPassword + "]";
	}
}