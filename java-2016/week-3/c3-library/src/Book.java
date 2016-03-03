import java.io.Serializable;


public class Book implements Serializable
{	
	private String title;
	private int pageNr;
	
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
	
	@Override
	public String toString(){
		return "\nTitle: " + title + "\nNumber of pages: " + pageNr;
	}

}
