package com.aurionpro.inheritance;

import java.util.Random;

public abstract class Account {
	private String accountNo;
	private String name;
	private int balance;
	protected String getName() {
		return name;
	}
	protected void setName(String name) {
		this.name = name;
	}
	protected int getBalance() {
		return balance;
	}
	protected void setBalance(int balance) {
		this.balance = balance;		
	}
	public abstract void deposit(int amount);
	public abstract void withdraw(int amount);
	protected Account(String name, int balance) {
		Random random = new Random();
		this.accountNo ="ICICI1000"+ (random.nextInt(100000) + 100000);
		System.out.println("\nAccount Created!\nAccount Number : "+ this.accountNo);
		this.name = name;
		this.balance = balance;
	}
	
	protected Account() {
		this("",0);
	}
}
