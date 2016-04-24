package cardealership.tests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cardealership.car.Car;
import cardealership.dacia.Logan;
import cardealership.dealership.CarDealership;
import cardealership.vw.VWGolf;

public class TestCarDealership {

	CarDealership carDealership;
	Car car1, car2;
	List<Car> cars;

	@Before
	public void setUp() {
		carDealership = new CarDealership("compexit");
		car1 = new Logan("aaaaa", 2015, 4500);
		car2 = new VWGolf("bbbbb", 2014, 8500);
		carDealership.addCarToStock(car1, 4500);
		carDealership.addCarToStock(car2, 8000);
		cars = carDealership.listAllCars();
	}

	@After
	public void destroy() {
		carDealership = null;
		cars = null;
	}

	@Test
	public void testCarDealershipListIsEmpty() {
		assertFalse(carDealership.listAllCars().isEmpty());
	}
	
	@Test
	public void testCarDealershipCarListNotEmpty() {
		assertTrue(!cars.isEmpty());
	}

	@Test
	public void testCarDealershipCarListContainsCorrectNumberOfCars() {
		assertTrue(cars.size() == 2);
	}

	@Test
	public void testExternalModificationsOnCarDealershipDoNotAffectInternalStructure() {
		cars.remove(car1);
		assertEquals(2, carDealership.listAllCars().size());
	}

}
