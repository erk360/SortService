package com.bookutils;
/* 	
* 	Sort Service 1.0
*	Created 18/09/2016
*	By Erick Rafael
*/

/* 
 * This class generates the comparison methods to any two books, based on the rules and 
 * attributes priority .
 * 
 * In each one, the method compare the two books using the chosen attribute and if 
 * they are different, it returns -1 or 1 (less than and greater than, respectively) to
 * the sort method and if they are equal, it returns 0 and the comparator continues and 
 * check if there is another attribute.
 * 
 * Depending on the attribute order, the result comparison is multiplied by "1" case 
 * Ascending Order or "-1" case Descending, through the "options.OrderAuthor()" method
 * in order to invert the result.
 * 
 * Returns a Int Value
 */

public final class AttributesComparator {

	private static int resultCompare=0;
	public static int Author(Book b1, Book b2, Options options){
		resultCompare = b1.getAuthor().compareTo(b2.getAuthor()) * options.OrderAuthor();
		return resultCompare;
	}
	public static int Title(Book b1, Book b2, Options options){
		resultCompare = b1.getTitle().compareTo(b2.getTitle()) * options.OrderTitle();
		return resultCompare;
	}
	public static int EditionYear(Book b1, Book b2, Options options){
		resultCompare = (b1.getEditionYear() - b2.getEditionYear()) * options.OrderEdition();
		return resultCompare;
	}
	public static int Author_Title(Book b1, Book b2, Options options){
		resultCompare = b1.getAuthor().compareTo(b2.getAuthor()) * options.OrderAuthor();
		if(resultCompare == 0)
			resultCompare = b1.getTitle().compareTo(b2.getTitle()) * options.OrderTitle();		
		return resultCompare;
	}			
	public static int Author_EditionYear(Book b1, Book b2, Options options){
		resultCompare = b1.getAuthor().compareTo(b2.getAuthor()) * options.OrderAuthor();
		if(resultCompare == 0)
			resultCompare = (b1.getEditionYear() - b2.getEditionYear()) * options.OrderEdition();
		return resultCompare;
	}
	public static int Title_Author(Book b1, Book b2, Options options){
		resultCompare = b1.getTitle().compareTo(b2.getTitle()) * options.OrderTitle();	
		if(resultCompare == 0)
			resultCompare = b1.getAuthor().compareTo(b2.getAuthor()) * options.OrderAuthor();	
		return resultCompare;
	}
	public static int Title_EditionYear(Book b1, Book b2, Options options){
		resultCompare = b1.getTitle().compareTo(b2.getTitle()) * options.OrderTitle();
		if(resultCompare == 0)
			resultCompare = (b1.getEditionYear() - b2.getEditionYear()) * options.OrderEdition();
		return resultCompare;
	}
	public static int EditionYear_Author(Book b1, Book b2, Options options){
		resultCompare =(b1.getEditionYear() - b2.getEditionYear()) * options.OrderEdition();	
		if(resultCompare == 0)
			resultCompare = b1.getAuthor().compareTo(b2.getAuthor()) * options.OrderAuthor();	
		return resultCompare;
	}
	public static int EditionYear_Title(Book b1, Book b2, Options options){
		resultCompare =(b1.getEditionYear() - b2.getEditionYear()) * options.OrderEdition();	
		if(resultCompare == 0)
			resultCompare = b1.getTitle().compareTo(b2.getTitle()) * options.OrderTitle();
		return resultCompare;
	}
	public static int Author_Title_EditionYear(Book b1, Book b2, Options options){
		resultCompare = b1.getAuthor().compareTo(b2.getAuthor()) * options.OrderAuthor();
		if(resultCompare == 0){
			resultCompare = b1.getTitle().compareTo(b2.getTitle()) * options.OrderTitle();	
			if(resultCompare == 0)
				resultCompare =(b1.getEditionYear() - b2.getEditionYear()) * options.OrderEdition();
		}	
		return resultCompare;
	}
	public static int Author_EditionYear_Title(Book b1, Book b2, Options options){
		resultCompare = b1.getAuthor().compareTo(b2.getAuthor()) * options.OrderAuthor();
		if(resultCompare == 0){
			resultCompare =(b1.getEditionYear() - b2.getEditionYear()) * options.OrderEdition();
			if(resultCompare == 0)
				resultCompare = b1.getTitle().compareTo(b2.getTitle()) * options.OrderTitle();
		}	
		return resultCompare;
	}
	public static int Title_Author_EditionYear(Book b1, Book b2, Options options){
		resultCompare = b1.getTitle().compareTo(b2.getTitle()) * options.OrderTitle();
		if(resultCompare == 0){
			resultCompare = b1.getAuthor().compareTo(b2.getAuthor()) * options.OrderAuthor();
			if(resultCompare == 0)
				resultCompare =(b1.getEditionYear() - b2.getEditionYear()) * options.OrderEdition();
		}	
		return resultCompare;
	}
	public static int Title_EditionYear_Author(Book b1, Book b2, Options options){
		resultCompare = b1.getTitle().compareTo(b2.getTitle()) * options.OrderTitle();
		if(resultCompare == 0){
			resultCompare =(b1.getEditionYear() - b2.getEditionYear()) * options.OrderEdition();
			if(resultCompare == 0)
				resultCompare = b1.getAuthor().compareTo(b2.getAuthor()) * options.OrderAuthor();
		}	
		return resultCompare;
	}
	public static int EditionYear_Author_Title(Book b1, Book b2, Options options){
		resultCompare =(b1.getEditionYear() - b2.getEditionYear()) * options.OrderEdition();
		if(resultCompare == 0){
			resultCompare = b1.getAuthor().compareTo(b2.getAuthor()) * options.OrderAuthor();
			if(resultCompare == 0)
				resultCompare = b1.getTitle().compareTo(b2.getTitle()) * options.OrderTitle();
		}	
		return resultCompare;
	}
	public static int EditionYear_Title_Author(Book b1, Book b2, Options options){
		resultCompare =(b1.getEditionYear() - b2.getEditionYear()) * options.OrderEdition();
		if(resultCompare == 0){
			resultCompare = b1.getTitle().compareTo(b2.getTitle()) * options.OrderTitle();
			if(resultCompare == 0)
				resultCompare = b1.getAuthor().compareTo(b2.getAuthor()) * options.OrderAuthor();
		}	
		return resultCompare;
	}	
}
