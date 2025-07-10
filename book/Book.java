package com.aurionpro.book;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class Book implements Comparable<Book>{
	private int id;
	private String title;
	private boolean isIssued;
	private String author;
	public static ArrayList<Book> bookList = new ArrayList<>();
	static HashSet<Integer> bookIds = new HashSet<>();

	public void addBook(Book book) {
		bookList.add(book);
	}

	public static void showBooks() {
		for (Book book : bookList) {
			if (!book.isIssued) {
				System.out.println(book);
			}
		}
	}
	public static void showIssuedBooks() {
		for (Book book : bookList) {
			if (book.isIssued) {
				System.out.println(book);
			}
		}
	}

	public int getId() {
		return id;
	}

	public void setId() {
		boolean flag = true;
		Random random = new Random();
		while (flag) {
			int id = random.nextInt(999) + 1000;
			if (bookIds.add(id)) {
				this.id = id;
				flag=false;
				break;
			}
		}
	}

	public String getTitle() {
		return title;
	}

	public Book(String title,  String author) {
		super();
		setId();
		this.title = title;
		this.isIssued = false;
		this.author = author;
	}

	@Override
	public String toString() {
		return "[id=" + id + ", title=" + title + ", author=" + author + "]";
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isIssued() {
		return isIssued;
	}

	public void setIssued(boolean isIssued) {
		this.isIssued = isIssued;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public int compareTo(Book o) {
		return this.author.compareTo(o.author);
	}

}
