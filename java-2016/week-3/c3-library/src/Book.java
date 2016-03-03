

import java.io.Serializable;


public class Book implements Serializable
{	
	public String title;
	public int pageNr;
	
	public Book()
	{
		title = null;
		pageNr = 0;
	}
	
	public Book(String title)
	{
		
	}
	
	public Book(String title, int pageNr)
	{
		this.title = title;
		this.pageNr = pageNr;
	}
	
	public String getTitle()
	{       
		return title;
	}
	
	public void setTitle(String title)
	{
		this.title = title;
	}
	
	public String toString()
	{
		return "\n>>TITLE: " + title + "\n>Number of pages: " + pageNr;
	}

}
