

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
		return "\nTitle: " + super.title + "\nNumber of pages: " + super.pageNr+ "\nGenre: " + type;
	}
	
}