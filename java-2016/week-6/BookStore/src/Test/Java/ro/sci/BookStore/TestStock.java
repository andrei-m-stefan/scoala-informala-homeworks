package ro.sci.BookStore;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestStock {

	Book book = new Book();
	List<Book> stock = null;

	@Before
	public void initStock() {
		// initialize stock
		stock = new ArrayList<Book>();
		Book book1 = createNewBook("Abecedar", "education", "profu", 1000, 15d);
		stock.add(book1);

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

	@Test
	public void testStockNotNull() {
		assertNotNull(stock);
	}

	@Test
	public void testStockSize(){
		assertFalse(stock.size() == 0);
	}

	@After
	public void destroyCart() {
		stock = null;
	}

}
