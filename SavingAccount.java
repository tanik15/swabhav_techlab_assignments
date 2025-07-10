package com.aurionpro.inheritance;

import com.aurionpro.inheritance.accountException.MinimumBalanceViolationException;

public class SavingAccount extends Account{
	public static int minBalance = 1000;
	public void withdraw(int amount) {
		if(super.getBalance()-amount<minBalance) {
			throw new MinimumBalanceViolationException(minBalance);
		}
			int remainingBalance  = super.getBalance()-amount;
			System.out.println(remainingBalance);
			super.setBalance(remainingBalance); 
			int balance = super.getBalance();
			System.out.println(amount+" withdraw and Balance is "+ balance);			
			return;
		
	}
	public SavingAccount() {
		super();
	}
	public SavingAccount(String name, int balance) {
		super(name, balance);
	}
	@Override
	public void deposit(int amount) {
		super.setBalance(super.getBalance()+amount);
		System.out.println(amount + " deposited and Balance is " + super.getBalance());		
	}
	
}
