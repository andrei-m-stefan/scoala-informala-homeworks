

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class Library implements Serializable
	{
	
	private List<Book> collection;

	public Library()
	{
		collection = new ArrayList<Book>();
	}
	
	public void addBook(Book book)
	{
		collection.add(book);
	}
	
	public boolean removeBook(String title)
	{
		for(int i = 0; i < collection.size(); i++)
		{
			Book currBook = collection.get(i);
			String currBookTitle = currBook.getTitle();
			
			if(currBookTitle.equals(title))
			{
				collection.remove(i);
				i--;
				
				return true;
			}
		}
		
		return false;
	}
	
	@Override
	public String toString() 
	{
		String total = "\n";
		/*
		for (int i=0; i<collection.size(); i++){
			Book b = collection.get(i);
			total = total + b.toString();
			
		}
		*/
		Iterator<Book> i = collection.iterator();
		while(i.hasNext())
		{
			Book b = (Book) i.next();
			total = total + b.toString();
		}
		return total;
	}

}
