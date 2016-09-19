package com.bookutils;

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
