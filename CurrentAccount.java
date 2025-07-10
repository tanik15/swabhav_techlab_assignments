package com.aurionpro.inheritance;

import com.aurionpro.inheritance.accountException.OverDraftLimitReachedException;

public class CurrentAccount extends Account{
	public  int overDraftLimit = 50000;
	public int overDraftBalance = 50000;
	@Override
	public void withdraw(int amount) {
		int balance = super.getBalance();
		
		if(balance>=amount) {
			int remainingBalance  = balance-amount;
			super.setBalance(remainingBalance); 
			return;
		}
		if((balance + overDraftBalance)<amount){
			throw new OverDraftLimitReachedException(overDraftLimit);
		}
		overDraftBalance -= (amount- balance);
		System.out.println("OverDraft Balance: "+ overDraftBalance);
		super.setBalance(0);
	}
	protected int getOverDraftBalance() {
		return overDraftBalance;
	}
	public CurrentAccount() {
		super();
	}
	public CurrentAccount(String name, int balance) {
		super(name, balance);
	}
	@Override
	public void deposit(int amount) {
		super.setBalance(super.getBalance()+amount);
		System.out.println(amount + " deposited and Balance is " + super.getBalance());
	}
	
}
