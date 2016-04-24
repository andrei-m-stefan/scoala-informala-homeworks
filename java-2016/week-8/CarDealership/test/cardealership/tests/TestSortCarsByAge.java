package cardealership.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cardealership.car.Car;
import cardealership.dacia.Logan;

public class TestSortCarsByAge {

	List<Car> carList;

	@Before
	public void setUp() {
		carList = new ArrayList<Car>();
		Car car1 = new Logan("1123", 2016, 4500);
		Car car2 = new Logan("2345", 2013, 4000);
		Car car3 = new Logan("2456", 2011, 3500);

		carList.add(car1);
		carList.add(car2);
		carList.add(car3);
	}

	@After
	public void destroy() {
		carList.clear();
	}

	@Test
	public void testSortingOfCarsByAge() {
		Collections.sort(carList, Car.SORT_BY_AGE);
		for (Car car : carList) {
			System.out.println(car.productionYear);
		}
		assertTrue(carList.get(0).productionYear < carList.get(1).productionYear);
		assertTrue(carList.get(1).productionYear < carList.get(2).productionYear);
	}

}