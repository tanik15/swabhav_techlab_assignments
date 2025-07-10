package com.aurionpro.inheritance.accountException;

public class OverDraftLimitReachedException extends RuntimeException {
	int overDraftLimit ;
	public OverDraftLimitReachedException(int overDraftLimit) {
		super();
		this.overDraftLimit = overDraftLimit;
	}
	public String getMessage() {
		return "OverDraftLimit is "+overDraftLimit +". Can't withdraw more than this.";
	}
}
