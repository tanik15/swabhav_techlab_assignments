package com.aurionpro.inheritance;

import java.util.Scanner;

import com.aurionpro.inheritance.accountException.MinimumBalanceViolationException;
import com.aurionpro.inheritance.accountException.NegativeAmountViolationException;
import com.aurionpro.inheritance.accountException.OverDraftLimitReachedException;

public class AccountTest {

	public static void setUpCurrentAccount(Scanner scanner) {
		System.out.println("Enter your name");
		String name = scanner.nextLine();
		System.out.println("Deposit Balance .Minimum must be 1000");
		int balance = scanner.nextInt();
		try {
		CurrentAccount currentAccount = new CurrentAccount(name, balance);
		currentAccountMenu(currentAccount, scanner);
		}catch(NegativeAmountViolationException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void currentAccountMenu(CurrentAccount account, Scanner scanner) {
		int choice = 0;
		while (choice != 5) {
			System.out.println("1.Check Balance");
			System.out.println("2.Deposit");
			System.out.println("3.Withdraw");
			System.out.println("4.OverDraftBalance");
			System.out.println("5.Exit");
			choice = scanner.nextInt();
			if (choice == 1) {
				System.out.println("Balance : " + account.getBalance());
				continue;
			}
			if (choice == 2) {
				System.out.println("Enter Amount to deposit");
				try {
					int amount = scanner.nextInt();
					if (amount < 0) {
						throw new NegativeAmountViolationException(amount);
					}
					account.deposit(amount);
				} catch (NegativeAmountViolationException e) {
					System.out.println(e.getMessage());
				}catch (Exception e) {
					System.out.println("Something went wrong");
				}
				scanner.nextLine();
				continue;
			}
			if (choice == 3) {
				System.out.println("Enter Amount to Withdraw");
				try {
					int amount = scanner.nextInt();
					if (amount < 0) {
						throw new NegativeAmountViolationException(amount);
					}
					account.withdraw(amount);
				} catch (OverDraftLimitReachedException e) {
					System.out.println(e.getMessage());
				} catch (NegativeAmountViolationException e) {
					System.out.println(e.getMessage());
				}catch (Exception e) {
					System.out.println("Something went wrong");
				}
				scanner.nextLine();
				continue;
			}
			if (choice == 4) {
				System.out.println("OverdraftBalance is " + account.getOverDraftBalance());
			}
			if (choice == 5) {
				return;
			}
		}

	}

	public static void savingAccountMenu(SavingAccount account, Scanner scanner) {
		int choice = 0;
		while (choice != 5) {
			System.out.println("1.Check Balance");
			System.out.println("2.Deposit");
			System.out.println("3.Withdraw");
			System.out.println("4.Exit");
			choice = scanner.nextInt();
			if (choice == 1) {
				System.out.println("Balance : " + account.getBalance());
				continue;
			}
			if (choice == 2) {
				try {
					System.out.println("Enter Amount to deposit");
					int amount = scanner.nextInt();
					if (amount < 0) {
						throw new NegativeAmountViolationException(amount);
					}
					account.deposit(amount);
				} catch (NegativeAmountViolationException e) {
					System.out.println(e.getMessage());
				}
				catch (Exception e) {
					System.out.println("Something went wrong");
				}
				scanner.nextLine();
				continue;
			}
			if (choice == 3) {
				try {
					System.out.println("Enter Amount to Withdraw");
					int amount = scanner.nextInt();
					scanner.nextLine();
					if (amount < 0) {
						throw new NegativeAmountViolationException(amount);
					}
					account.withdraw(amount);
				} catch (MinimumBalanceViolationException e) {
					System.out.println(e.getMessage());
				}catch(NegativeAmountViolationException e) {
					System.out.println(e.getMessage());
				}
				catch (Exception e) {
					System.out.println("Something went wrong");
				}
				continue;
			}

			if (choice == 4) {
				return;
			}
		}
	}

	public static void setUpSavingAccount(Scanner scanner) {
		System.out.println("Enter your name");
		String name = scanner.nextLine();
		System.out.println("Deposit Balance .Minimum must be 1000");
		int balance = scanner.nextInt();
		scanner.nextLine();
		while (balance < 1000) {
			System.out.println("Deposit Balance .Minimum must be 1000");
			balance = scanner.nextInt();
		}
		SavingAccount savingAcc = new SavingAccount(name, balance);
		savingAccountMenu(savingAcc, scanner);
	}

	public static void takeChoice(Scanner scanner) {
		int choice = 0;
		while (choice != 3) {
			System.out.println("Create Account");
			System.out.println("1.Saving Account");
			System.out.println("2.Current Account");
			System.out.println("3.Exit");
			choice = scanner.nextInt();
			scanner.nextLine();
			if (choice == 1) {
				setUpSavingAccount(scanner);
				continue;
			}
			if (choice == 2) {
				setUpCurrentAccount(scanner);
				continue;
			}
			if (choice == 3) {
				System.out.println("Thankyou!");
				return;
			}
		}

	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		takeChoice(scanner);
	}

}
