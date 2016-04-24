package cardealership.tests;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import cardealership.banking.*;

public class TestBankAccount {

	BankAccount bankAccount;
	
	@Before
	public void setUp(){
		bankAccount = new BankAccount(50000f);
	}
	
	@After
	public void destroy(){
		bankAccount = null;
	}
	

	@Test
	public void testBankAccount() {
		assertEquals(50000f, bankAccount.getBalance(), 0);
	}

}
