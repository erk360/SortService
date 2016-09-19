package com.sortingservice;
/* 	
* 	Sort Service 1.0
*	Created 18/09/2016
*	By Erick Rafael
*/
import java.net.URISyntaxException;
import java.util.Collections;
import java.util.List;

import com.bookutils.Book;
import com.bookutils.BookComparator;
import com.bookutils.Books;
import com.bookutils.Options;
import com.bookutils.SortAttributes;



public class Sorting {

	/*
	 * Receive the books and the rules, generating from these parameters the sort rules
	 * with the class BookComparator.
	 * 
	 * After comparison object was generated, makes a sort of books and find a respective sort
	 * of each item, returning the sort of books through the Ids.
	 * 
	 * Returns a String
	 */

	public String sortBooksByCriteria(Books books, Options options) throws SortServiceException, URISyntaxException{
		String resultCompare="Books ";
		
		if(options.sortAtrributes == SortAttributes.NoRules)
			throw new SortServiceException("There is no rules selected! Source: SortServiceException - Input NULL");
		
		List<Book> listBooks= books.getBooks();
		BookComparator bookComparator= new BookComparator(options); 
		
		Collections.sort(listBooks,bookComparator.getSortComparator());
		
		for(int i=0;i<listBooks.size();i++){
			resultCompare+=	listBooks.get(i).getId() + ", ";
		}
		
		return resultCompare.substring(0,resultCompare.length()-2);
	}
	
	
}
