package com.sortingservice;

import java.io.File;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

import com.bookutils.Book;
import com.bookutils.BookComparator;
import com.bookutils.Books;
import com.bookutils.Options;
import com.bookutils.SortAttributes;

public class Sorting {


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
