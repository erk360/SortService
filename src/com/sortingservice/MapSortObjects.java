package com.sortingservice;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import org.apache.commons.fileupload.FileItem;

import com.bookutils.Books;
import com.bookutils.Options;
import com.bookutils.SortAttributes;


public class MapSortObjects {
	
	private Books books=null;
	private Options options=null;
	
	public MapSortObjects(List<FileItem> inputItems) throws Exception {
		this.options=this.mapToOption(inputItems);		
	}
	
	private Options mapToOption(List<FileItem> listItem) throws Exception {
		this.options=new Options();
		
		for (FileItem item : listItem) {
			if (!item.isFormField()) {
				String UploadDir= this.checkUploadDir();
				File bookListFile=new File( UploadDir + File.separator + item.getName());
				item.write(bookListFile);	
				
				this.mapXMLFileBooks(bookListFile.getAbsolutePath());
			}
			else{
				switch(item.getFieldName()){
					case "OrderAuthor":{ this.options.AscendingAuthor = Boolean.parseBoolean(item.getString()); break;}
					case "OrderTitle":{ this.options.AscendingTitle = Boolean.parseBoolean(item.getString()); break;}
					case "OrderEdition":{ this.options.AscendingEdition = Boolean.parseBoolean(item.getString()); break;}					
					case "Author":{ this.options.Author = Boolean.parseBoolean(item.getString()); break;}
					case "Title":{ this.options.Title = Boolean.parseBoolean(item.getString()); break;}
					case "Edition":{ this.options.Edition = Boolean.parseBoolean(item.getString());break;}
					case "AttributesOrder":{ Integer aux = Integer.parseInt(item.getString()); this.options.sortAtrributes = SortAttributes.values()[aux<0 ? 15:aux]; break;}
				}
				
			}
		}
		return this.options;
	}
		
	private String checkUploadDir() throws IOException, URISyntaxException {	
		
		String currDir = (Paths.get(this.getClass().getClassLoader().getResource("").toURI()).getParent())+"/Upload";		
		File dir = new File(currDir);
		if (!dir.exists()) {
            if (!dir.mkdir()) {
                throw new IOException("Directory cannot to be created!");
            }
        }
				
		return currDir;		
	}
	
	private void mapXMLFileBooks(String xmlFile) throws IOException, SortServiceException {
		String xmlString= new String(Files.readAllBytes(Paths.get(xmlFile)));
		if(xmlString.length()<50)
			throw new SortServiceException("There is no Books to compare in this file!");
		
		InputStream inputStreamXML = new ByteArrayInputStream(xmlString.replaceAll("&", "&amp;").getBytes(Charset.forName("UTF-8")));
				
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(Books.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		    this.books= (Books)jaxbUnmarshaller.unmarshal( inputStreamXML ); 
		} catch (JAXBException e) {
			CharSequence cs = "Expected elements are <{}book>,<{}books>";
			if(e.getMessage().contains(cs))
				throw new SortServiceException("This File is not a valid XML Book File!");
			e.printStackTrace();
		}
	          
	}
	
	public Books getBooks(){		
		return this.books;
	}
	
	public Options getOptions(){
		return this.options;
	}
	
	
}
