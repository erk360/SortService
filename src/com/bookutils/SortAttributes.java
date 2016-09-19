package com.bookutils;
/* 	
* 	Sort Service 1.0
*	Created 18/09/2016
*	By Erick Rafael
*/

public enum SortAttributes {
	Author(0),
	Title(1),
	EditionYear(2),
	Author_Title(3),				
	Author_EditionYear(4),
	Title_Author(5),
	Title_EditionYear(6),
	EditionYear_Author(7),
	EditionYear_Title(8),
	Author_Title_EditionYear(9),
	Author_EditionYear_Title(10),
	Title_Author_EditionYear(11),
	Title_EditionYear_Author(12),
	EditionYear_Author_Title(13),
	EditionYear_Title_Author(14),
	NoRules(15);
	
	public final int value;
	
	SortAttributes(final int value) {
	     this.value = value;
	}
}
