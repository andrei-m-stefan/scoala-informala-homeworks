package ro.sci.BookStore;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestCustomer {

	List<Customer> customerList = null;
	
	@Before
	public void initCustomer() {
		// initialize customer
		customerList = new ArrayList<Customer>();
		Customer customer1 = createNewCustomer("Andrei Stefan", "#43 Tache Ionescu", "andrei.m.stefan@hotmail.com");
		customerList.add(customer1);

	}
	
	private Customer createNewCustomer(String name, String address, String eMail) {
		Customer customer = new Customer();
		customer.setName(name);
		customer.setAddress(address);
		customer.seteMail(eMail);
		
		return customer;
	}

	@Test
	public void testCustomerListNotNull() {
		assertNotNull(customerList);
	}

	@Test
	public void testCustomerListSize(){
		assertTrue(customerList.size() > 0);
	}
	
	@Test
	public void testCustomerContent() {
		Customer customer1 = customerList.get(0);

		assertEquals("Andrei Stefan", customer1.getName());
		assertEquals("#43 Tache Ionescu", customer1.getAddress());
		assertEquals("andrei.m.stefan@hotmail.com", customer1.geteMail());
	}
	
	@After
	public void destroyCustomer() {
		customerList = null;
	}
	
}
















