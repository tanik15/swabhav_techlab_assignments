package com.aurionpro.inheritance.accountException;

public class MinimumBalanceViolationException extends RuntimeException{
	int minimumBalance;
	public String getMessage() {
		String message = "Minimum balance must be " + minimumBalance;
		return message;
	}
	public MinimumBalanceViolationException(int minimumBalance) {
		super();
		this.minimumBalance = minimumBalance;
	}
}
