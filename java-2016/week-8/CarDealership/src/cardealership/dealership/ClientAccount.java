package cardealership.dealership;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import cardealership.car.*;
import cardealership.clients.Client;

public class ClientAccount {

	private Map<Client, List<Car>> clientAccount;

	public ClientAccount(Map<Client, List<Car>> clientAccount) {
		this.clientAccount = clientAccount;
	}

	public Map<Client, List<Car>> getAccounts() {
		return clientAccount;
	}

	public List<Car> myFleet() {
		List<Car> fleet = null;

		for (Map.Entry<Client, List<Car>> entry : clientAccount.entrySet()) {
			fleet = entry.getValue();
		}
		return fleet;
	}

	public List<Car> myFleet(Comparator<Car> sortByAge) {
		List<Car> sortedFleet = new ArrayList<>();
		for (List<Car> list : clientAccount.values()) {
			sortedFleet.addAll(list);
		}
		Collections.sort(sortedFleet, Car.SORT_BY_AGE);
		return sortedFleet;
	}

	public void removeSoldCarFromFleet(Car car) {
		List<Car> fleet = myFleet();
		if (fleet.contains(car)) {
			fleet.remove(car);
		}
	}

}
