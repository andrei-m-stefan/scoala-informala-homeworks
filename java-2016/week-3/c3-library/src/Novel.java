

public class Novel extends Book
{
	public String type;
	
	public Novel()
	{

	}
	public Novel(String name, int pageNr, String type)
	{
		super(name, pageNr);
		this.type = type;
	}

	@Override
	public String toString()
	{
		return "\n>Title: " + super.title + "\n>Number of pages: " + super.pageNr+ "\n>Genre: " + type;
	}
	
}