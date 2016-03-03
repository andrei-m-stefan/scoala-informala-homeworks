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
	
	public Book(String title, int pageNr)
	{
		this.title = title;
		this.pageNr = pageNr;
	}
	
	public String toString()
	{
		return "\n>Title: " + title + "\n>Number of pages: " + pageNr;
	}

}
