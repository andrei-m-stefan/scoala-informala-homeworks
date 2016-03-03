import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class MainClass
 {

	static String fileName = null;
	static Library lib = new Library();
	static Scanner in = new Scanner(System.in);
	static Boolean running = true;
	static Album album = new Album();
	static Novel novel = new Novel();

	public static void main(String[] args) 
	{
		
		System.out.println("\n\t\t^*^*^*^*^*^*^* LIBRARY  CATALOG ^*^*^*^*^*^*^");
		while (running) 
		{
			System.out.println("\n\tEnter 1 to load a library."
					+ "\n\tEnter 2 to add a book to library"
					+ "\n\tEnter 3 to list all books in library"
					+ "\n\tEnter 4 to delete a book from library"
					+ "\n\tEnter 5 to save and quit"
					+ "\n\tEnter 6 to quit without saving");
			int answer = in.nextInt();
			switch (answer)
			{
			case 1:
				System.out.println("Enter the file name to load");
				loadScript(in.next());
				break;
			case 2:
				verify();
				break;
			case 3:
				System.out.println(lib.toString());
				break;
			case 4:
				//
				break;
			case 5:
				saveAndQuit();
				break;
			case 6:
				System.out.println("\n\tLibrary Catalog Terminated!!! ");
				System.exit(0);
			}
		}
		System.exit(0);
	}

	
	private static void verify()
	{
		String title;
		int pageNr;
		String type;
		String paperQ;
		
		System.out.println("\nEnter 1 for novel & 2 for album.");
		int answer = in.nextInt();
		
		System.out.println("\nEnter Title: ");
		title = in.next();

		System.out.println("\nEnter number of pages: ");
		pageNr = in.nextInt();
		
		switch (answer)
			{
			case 1:
				
				System.out.println("\nEnter genre: ");
				type = in.next();
	
				Novel n = new Novel(title, pageNr, type);
				lib.addBook(n);
				
				break;
			
			case 2:
				
				System.out.println("\nEnter paper quality: ");
				paperQ = in.next();
	
				Album a = new Album(title, pageNr, paperQ);
				lib.addBook(a);

				break;
			}
		
	}

	private static void saveAndQuit()
	{
		System.out.println("Enter file name: ");
		fileName = in.next() + ".ser";
		running = false;
		FileOutputStream fos = null;
		ObjectOutputStream out = null;
		try 
		{
			fos = new FileOutputStream(fileName);
			out = new ObjectOutputStream(fos);
			out.writeObject(lib);
			fos.close();
			out.close();
		}
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}

	}

	private static void loadScript(String name) 
	{
		FileInputStream fis = null;
		ObjectInputStream in = null;
		File file = new File(name + ".ser");
		if (file.exists())
			{
			try 
			{
				fis = new FileInputStream(file);
				in = new ObjectInputStream(fis);
				lib = (Library) in.readObject();
				fis.close();
				in.close();

			} 
			catch (IOException e)
			{
				e.printStackTrace();
			}
			catch (ClassNotFoundException e) 
			{
				e.printStackTrace();
			}

		}
		else
		{
			System.out.println("\nThe file does not exist!");
		}
	}
	
	private static void deleteBook()
	{
		//????//
	}

}
