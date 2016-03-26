package ro.sci.BookStore;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestCart {

	Book book = new Book();
	List<CartEntry> cart = null;

	@Before
	public void initCart() {
		// initialize cart
		cart = new ArrayList<CartEntry>();
		CartEntry cart1 = createNewCart(book, 23);
		cart.add(cart1);

	}
	
	private CartEntry createNewCart(Book book, int qty) {
		return null;
	}

	@Test
	public void testCartNotNull() {
		assertNotNull(cart);
	}

	@Test
	public void testCartSize(){
		assertTrue(cart.size() > 0);
	}

	@After
	public void destroyCart() {
		cart = null;
	}

}
