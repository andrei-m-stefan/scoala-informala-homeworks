package cardealership.banking;

import cardealership.clients.Client;
import cardealership.exceptions.*;

public class BankAccount {

	private String iban;
	protected float balance;

	public BankAccount(float balance) {
		super();
		this.balance = balance;
	}

	public BankAccount(String iban, float balance) {
		super();
		this.iban = iban;
		this.balance = balance;
	}

	public void transferOfFunds(Float ammount, BankAccount destinationAccount) {
		balance -= ammount;
		destinationAccount.balance += ammount;
	}

	public String getIban() {
		return iban;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	public void updateBankAccountsForClientPurchase(Client client, float carPrice)
			throws NotEnoughFundsException, BankAccountNotFoundException {

		if (client.getBankAccount() == null) {
			throw new BankAccountNotFoundException("No bank account found, please contact your bank.!");
		}
		
		
		float clientBalance = client.getBankAccount().getBalance();
		float result = clientBalance - carPrice;
		client.getBankAccount().setBalance(result);

		float dealershipBalance = getBalance() + carPrice;
		setBalance(dealershipBalance);

		if (result < 0) {
			throw new NotEnoughFundsException("Not enough funds. Please contact your bank!");
		}

	}

	public void updateBankAccountsForDealershipPurchase(Client client, float carPrice) throws BankAccountNotFoundException {

		if ((client.getBankAccount() == null)) {
			throw new BankAccountNotFoundException("No bank account found, please contact your bank.!");
		}
		
		float clientBalance = client.getBankAccount().getBalance() + carPrice;
		client.getBankAccount().setBalance(clientBalance);
		float dealershipBalance = getBalance() - carPrice;
		setBalance(dealershipBalance);
	}

}