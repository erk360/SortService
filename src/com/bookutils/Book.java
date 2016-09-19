package com.bookutils;
/* 	
* 	Sort Service 1.0
*	Created 18/09/2016
*	By Erick Rafael
*/

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "book")
@XmlAccessorType (XmlAccessType.FIELD)
public class Book {

    private Integer id;

    private int editionYear;
    private String author;
    private String title;

    public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
   
    public String getAuthor() {
        return author;
    }


    public void setAuthor(String author) {
        this.author = author;
    }


    public String getTitle() {
        return title;
    }


    public void setTitle(String title) {
        this.title = title;
    }
    
    public int getEditionYear() {
        return editionYear;
    }
    
    public void setEditionYear(int editionyear) {
        this.editionYear = editionyear;
    }

}