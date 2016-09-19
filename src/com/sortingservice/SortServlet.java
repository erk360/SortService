package com.sortingservice;
/* 	
* 	Sort Service 1.0
*	Created 18/09/2016
*	By Erick Rafael
*/
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.json.JSONException;
import org.json.JSONObject;

import com.bookutils.Books;
import com.bookutils.Options;


/**
 * This class handle HTML Form containing the a rules sort selected 
 * by user, more the data XML File with the book list. 
 * Finally it response to browser client the sort result.
 */

public class SortServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SortServlet() {
        super();
    }

//  Receives a client request with the HTML Form, map XML Data to Object Books
//  and Rules to Options Object.
//  Send the mapped objects to Sort Service, which sorts the books based on
//  the rules selected by use final user.
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		boolean status=false;
		String result=null;
		
		if (isMultipart) {
			try {
				List<FileItem> items = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
				MapSortObjects objInputs= new MapSortObjects(items);			
				Books books=objInputs.getBooks();
				Options options=objInputs.getOptions();
				
				
				Sorting sort= new Sorting();						
				result=sort.sortBooksByCriteria(books, options);
				status=true;
				
			} catch (FileUploadException e) {
				result=e.getMessage();
				e.printStackTrace();
			} catch (Exception e) {
				result=e.getMessage();
				e.printStackTrace();
			}
		}
		else{
			result="Multidata content incorrect!";
		}
				
		try {
			JSONObject json= new JSONObject();
			json.put("status", status);
			json.put("result", result);
			response.getWriter().print(json.toString());
		} catch (JSONException e) {
			e.printStackTrace();
		}
			
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
	
}


	

