package com.bookutils;
/* 	
* 	Sort Service 1.0
*	Created 18/09/2016
*	By Erick Rafael
*/
import java.util.Comparator;

/* 
 * This class generates a comparator object of type Comparator<Book>, based on the priority 
 * order of attributes and calls the respective method responsible for to sort the books 
 * respecting the defined rules.
 * 
 * The comparison object is then passed to the method "Collections.sort()" in order to sort
 * the Books.
 * 
 * Returns a Comparator<Book>
 */

public class BookComparator {

	private Options options=null;	
	private Comparator<Book> sortComparator;
	
	public BookComparator(Options options){		
		this.options=options;
		
		this.sortComparator = new Comparator<Book>() {
		    public int compare(Book b1, Book b2) {
		    	
		    	switch(options.sortAtrributes){
		    		case Author: {return AttributesComparator.Author(b1,b2,options);}
		    		case Title:{return AttributesComparator.Title(b1,b2,options);}
		    		case EditionYear:{return AttributesComparator.EditionYear(b1,b2,options);}
		    		case Author_Title:{return AttributesComparator.Author_Title(b1,b2,options);}
		    		case Author_EditionYear:{return AttributesComparator.Author_EditionYear(b1,b2,options);}
		    		case Title_Author:{return AttributesComparator.Title_Author(b1,b2,options);}
		    		case Title_EditionYear:{return AttributesComparator.Title_EditionYear(b1,b2,options);}
		    		case EditionYear_Author:{return AttributesComparator.EditionYear_Author(b1,b2,options);}
		    		case EditionYear_Title:{return AttributesComparator.EditionYear_Title(b1,b2,options);}
		    		case Author_Title_EditionYear:{return AttributesComparator.Author_Title_EditionYear(b1,b2,options);}
		    		case Author_EditionYear_Title:{return AttributesComparator.Author_EditionYear_Title(b1,b2,options);}
		    		case Title_Author_EditionYear:{return AttributesComparator.Title_Author_EditionYear(b1,b2,options);}
		    		case Title_EditionYear_Author:{return AttributesComparator.Title_EditionYear_Author(b1,b2,options);}
		    		case EditionYear_Author_Title:{return AttributesComparator.EditionYear_Author_Title(b1,b2,options);}
		    		case EditionYear_Title_Author:{return AttributesComparator.EditionYear_Title_Author(b1,b2,options);}
		    		default: return 0;
		    	}
		    }
		};
		
	}

	public Options getOptions() {
		return options;
	}
	
	public Comparator<Book> getSortComparator() {
		return sortComparator;
	}
	
	
	
}
