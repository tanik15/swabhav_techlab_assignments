package com.aurionpro.inheritance.accountException;

public class MinimumBalanceViolationException extends RuntimeException{
	int minimumBalance;
	public String getMessage() {
		return "Minimum balance must be " + minimumBalance;
	}
	public MinimumBalanceViolationException(int minimumBalance) {
		super();
		this.minimumBalance = minimumBalance;
	}
}
