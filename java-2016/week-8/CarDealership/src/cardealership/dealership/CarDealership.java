
package cardealership.dealership;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import cardealership.banking.*;
import cardealership.car.*;
import cardealership.clients.*;
import cardealership.exceptions.*;

public class CarDealership {

	private String dealershipName;
	private List<Car> clientCars = new ArrayList<>();
	private HashSet<Car> carsInStock = new HashSet<Car>();
	private HashMap<String, Float> priceCatalog = new HashMap<>();
	private HashMap<String, ClientAccount> clientAccounts = new HashMap<>();
	private BankAccount bankAccount;
	private ClientAccount account;

	public CarDealership(String dealershipName) {
		this.dealershipName = dealershipName;
	}

	public ClientAccount getAccount() {
		return account;
	}

	public BankAccount getBankAccount() {
		return bankAccount;
	}

	public List<Car> listAllCars() {
		return new ArrayList<Car>(carsInStock);
	}

	public void setBankAccount(BankAccount bankAccount) {
		this.bankAccount = bankAccount;
	}

	public ClientAccount getClientAccount(Client client) {
		return clientAccounts.get(client.getId());
	}

	public void addCarToStock(Car car) {
		carsInStock.add(car);
	}

	public void addCarToStock(Car car, float price) {
		carsInStock.add(car);
		priceCatalog.put(car.getChassisNumber(), price);
	}

	public void sellCarToClient(Car car, Client client)
			throws CarNotFoundException, NotEnoughFundsException, BankAccountNotFoundException {

		for (Car carFromStock : carsInStock) {
			if (carFromStock.equals(car)) {
				createAccount(car, client);
				bankAccount.updateBankAccountsForClientPurchase(client, car.getCarPrice());
				carsInStock.remove(car);
				return;
			}
		}
		if (!carsInStock.contains(car)) {
			throw new CarNotFoundException("Car not found!");
		}
	}

	public void buyCarFromClient(Car car, Client client) throws BankAccountNotFoundException {

		bankAccount.updateBankAccountsForDealershipPurchase(client, car.getCarPrice());
		addCarToStock(car);
		getClientAccount(client).removeSoldCarFromFleet(car);

	}

	private void createAccount(Car car, Client client) {
		Map<Client, List<Car>> accountOwner = new LinkedHashMap<>();
		clientCars.add(car);
		accountOwner.put(client, clientCars);
		account = new ClientAccount(accountOwner);

	}
}
