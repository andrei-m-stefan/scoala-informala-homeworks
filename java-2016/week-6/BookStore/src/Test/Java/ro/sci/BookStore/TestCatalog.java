package ro.sci.BookStore;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestCatalog {

	// declare catalog
	List<Book> catalog = null;

	@Before
	public void initCatalog() {
		// initialize catalog
		catalog = new ArrayList<Book>();
		Book book1 = createNewBook("Abecedar", "education", "profu", 1000, 15d);
		catalog.add(book1);

	}

	@Test
	public void testCatalogSize() {
		assertNotNull(catalog);
		assertTrue(catalog.size() > 0);
	}

	@Test
	public void testCatalogContent() {
		Book firstBook = catalog.get(0);

		assertEquals("Abecedar", firstBook.getTitle());
	}

	private Book createNewBook(String title, String genre, String author, int isbn, double price) {
		Book book = new Book(isbn);
		book.setAuthor(author);
		book.setGenre(genre);
		book.setPrice(price);
		book.setTitle(title);
		book.setWeight(200);
		return book;
	}

	@After
	public void destroyCatalog() {
		catalog = null;
	}
}
