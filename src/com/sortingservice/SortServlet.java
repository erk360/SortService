package com.sortingservice;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
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
 * Servlet implementation class SortServlet
 */

public class SortServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SortServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
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
	
}


	

