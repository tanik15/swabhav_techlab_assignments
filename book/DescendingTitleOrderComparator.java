package com.aurionpro.book;

import java.util.Comparator;

public class DescendingTitleOrderComparator implements Comparator<Book>{

	@Override
	public int compare(Book o1, Book o2) {
		return o2.getTitle().compareTo(o1.getTitle());
	}

}
