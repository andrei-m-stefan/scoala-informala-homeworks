package ro.sci.BookStore;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestAddress {

	List<Address> addressList = null;
	
	@Before
	public void initAddress() {
		// initialize address
		addressList = new ArrayList<Address>();
		Address address1 = createNewAddress("Tache Ionescu", 43, "Cluj-Napoca");
		addressList.add(address1);

	}
	
	
	
	private Address createNewAddress(String street, int nr, String city) {
		Address address = new Address();
		address.setStreet(street);
		address.setNr(nr);
		address.setCity(city);
		
		return address;
	}

	
	@Test
	public void testCustomerListNotNull() {
		assertNotNull(addressList);
	}

	@Test
	public void testCustomerListSize(){
		assertTrue(addressList.size() > 0);
	}
	
	@Test
	public void testCustomerContent() {
		Address address1 = addressList.get(0);

		assertEquals("Tache Ionescu", address1.getStreet());
		assertEquals(43, address1.getNr());
		assertEquals("Cluj-Napoca", address1.getCity());
	}
	
	@After
	public void destroyCustomer() {
		addressList = null;
	}
}
