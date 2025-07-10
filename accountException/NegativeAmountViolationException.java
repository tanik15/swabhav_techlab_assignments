package com.aurionpro.inheritance.accountException;

public class NegativeAmountViolationException extends RuntimeException{
	int amount;
	public String getMessage() {
		return "Enter Amount is "+amount+". Amount Can't be negative";
	}
	public NegativeAmountViolationException(int amount) {
		super();
		this.amount = amount;
	}
}
