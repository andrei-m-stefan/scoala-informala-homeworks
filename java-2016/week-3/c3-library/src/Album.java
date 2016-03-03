

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
		return "\n>Title: " + super.title + "\n>Number of pages: " + super.pageNr + "\n>Paper Quality: " + paperQ;
	}
	
}