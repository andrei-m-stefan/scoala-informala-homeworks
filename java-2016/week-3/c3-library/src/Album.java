

public class Album extends Book
{
	public String paperQ;

	public Album()
	{
		
	}
	public Album(String name, int pageNr, String paperQ)
	{
		super(name, pageNr);
		this.paperQ = paperQ;
	}

	@Override
	public String toString()
	{
		return "\nTitle: " + super.title + "\nNumber of pages: " + super.pageNr + "\nPaper Quality: " + paperQ;
	}
	
}