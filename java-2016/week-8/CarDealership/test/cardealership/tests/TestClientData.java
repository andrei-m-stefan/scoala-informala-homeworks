package cardealership.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cardealership.clients.Client;

public class TestClientData {

	Client client;
	
	@Before
	public void setUp(){
		client = new Client("12345", "Andrei Stefan", "#43 Tache Ionescu");
	}

	@After
	public void destroy(){
		client = null;
	}

	@Test
	public void testClientData() {
		assertNotNull(client.getId());
		assertNotNull(client.getName());
		assertNotNull(client.getAddress());
	}

}
