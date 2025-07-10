package com.aurionpro.book;

import java.util.Collections;
import java.util.Scanner;

public class BookTest {
	public static boolean isInteger(String input) {
		try {
			Integer.parseInt(input);
			return true;
		}catch(NumberFormatException exception) {
			return false;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int choice = 0;
		while (choice != 7) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("\n***Welcome to AurionPro Library***");
			System.out.println("1.Add a new Book");
			System.out.println("2.Issue a book by Id/Title");
			System.out.println("3.Display all available books");
			System.out.println("4.Display all issued books");
			System.out.println("5.Return a book");
			System.out.println("6.Sort books");
			System.out.println("7.Exit");
			choice = scanner.nextInt();
			scanner.nextLine();
			switch (choice) {
			case 1: {
				System.out.println("Enter the book title:");
				String title = scanner.nextLine();
				
				System.out.println("Enter author name");
				String author = scanner.nextLine();
				Book book = new Book(title, author);
				book.addBook(book);
				break;
			}
			case 2: {
				System.out.println("Enter the book Id/Title");
				String input = scanner.nextLine();
				if(isInteger(input)) {
					int id = Integer.parseInt(input);
					for (Book book : Book.bookList) {
						if (book.getId() == id) {
							book.setIssued(true);
							System.out.println("Book: " + book.getTitle() + " [ Id: " + book.getId() + "] is issued");
						}
					}
					break;
				}
				for (Book book : Book.bookList) {
					if (book.getTitle().equals(input)) {
						book.setIssued(true);
						System.out.println("Book: " + book.getTitle() + " [ Id: " + book.getId() + "] is issued");
					}
				}
				break;
			}
			case 3: {
				Book.showBooks();
				break;
			}
			case 4:{
				Book.showIssuedBooks();
				break;
			}
			case 5:{
				System.out.println("Enter the book Id/Title");
				String input = scanner.nextLine();
				if(isInteger(input)) {
					int bookId = Integer.parseInt(input);
					for(Book book : Book.bookList) {
						if(book.getId()==bookId) {
							book.setIssued(false);
							System.out.println("Book: " + book.getTitle() + " [ Id: " + book.getId() + "] is return");
						}
					}
					break;
				}
				for(Book book : Book.bookList) {
					if(book.getTitle().equals(input)) {
						book.setIssued(false);
						System.out.println("Book: " + book.getTitle() + " [ Id: " + book.getId() + "] is return");
					}
					
				}
				break;
			}
			case 6:{
				System.out.println("\n1.Ascending order of Author");
				System.out.println("2.Decending order of Title");
				int sortChoice = scanner.nextInt();
				if(sortChoice==1) {		
					System.out.println("Ascending order of Author");
					Collections.sort(Book.bookList);
					Book.showBooks();
					break;
				}
				if(sortChoice==2) {
					System.out.println("Decending order of Title");
					Collections.sort(Book.bookList,new DescendingTitleOrderComparator());
					Book.showBooks();
					break;
				}
				break;
			}
			case 7:{
				System.out.println("Thankyou!");
				break;
			}
			}

		}
	}
}
