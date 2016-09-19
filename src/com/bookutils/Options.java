package com.bookutils;

public class Options {
	public boolean AscendingAuthor=false;
	public boolean AscendingTitle=false;
	public boolean AscendingEdition=false;
	public boolean Author=false;
	public boolean Title=false;
	public boolean Edition=false;
	public SortAttributes sortAtrributes=SortAttributes.Author;
	
	
	public int OrderAuthor(){	
		return AscendingAuthor ? 1: (-1);
	}
	public int OrderTitle(){	
		return AscendingTitle ? 1: (-1);
	}
	public int OrderEdition(){	
		return AscendingEdition ? 1: (-1);
	}
}


