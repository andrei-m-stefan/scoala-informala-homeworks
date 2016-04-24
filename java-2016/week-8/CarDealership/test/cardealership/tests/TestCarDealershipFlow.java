package cardealership.tests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cardealership.banking.BankAccount;
import cardealership.car.Car;
import cardealership.clients.Client;
import cardealership.dacia.Duster;
import cardealership.dacia.Logan;
import cardealership.dealership.CarDealership;
import cardealership.dealership.ClientAccount;
import cardealership.exceptions.*;
import cardealership.vw.VWGolf;

public class TestCarDealershipFlow {

	CarDealership carDealership;
	BankAccount clientBankAccount;
	BankAccount carDealershipBankAccount;
	ClientAccount clientAccount;
	List<Car> stock;
	Client client;
	Car car1, car2, car3;

	@Before
	public void setUp() {

		client = new Client("12345", "Andrei Stefan", "#43 Tache Ionescu");
		clientBankAccount = new BankAccount("RO123", 10000f);
		client.setBankAccount(clientBankAccount);

		carDealership = new CarDealership("compexit");
		carDealershipBankAccount = new BankAccount("RO345", 70000f);
		carDealership.setBankAccount(carDealershipBankAccount);

		clientAccount = carDealership.getClientAccount(client);
	}

	@After
	public void destroy() {
		client = null;
		clientAccount = null;
		carDealership = null;
		carDealershipBankAccount = null;
	}


	@Test
	public void testSuccesfullCarSellingToClientFlow() {
		
		Car car1 = new Logan("1123", 2016, 4500);
		Car car2 = new Duster("2345", 2013, 5800);
		Car car3 = new VWGolf("2456", 2011, 7500);

		carDealership.addCarToStock(car1);
		carDealership.addCarToStock(car2);
		carDealership.addCarToStock(car3);

		stock = carDealership.listAllCars();
		try {
			carDealership.sellCarToClient(car1, client);
		} catch (CarNotFoundException | NotEnoughFundsException | BankAccountNotFoundException e) {		
			e.printStackTrace();
		}

		assertEquals(2, carDealership.listAllCars().size());
		assertFalse(carDealership.listAllCars().contains(car1));
		assertEquals(5500, client.getBankAccount().getBalance(), 0);
		assertEquals(74500, carDealership.getBankAccount().getBalance(), 0);
		
	}
	
}
