package cardealership.vw;

import cardealership.car.*;

abstract class Volkswagen extends Car {

	public Volkswagen(float currentFuelAmount, String chassisNumber, FuelType fuelType, int numberOfGears,
			float fuelTankCapacity, float fuelConsumptionRate) {
		super(currentFuelAmount, chassisNumber, fuelType, numberOfGears, fuelTankCapacity, fuelConsumptionRate);
	}

	public Volkswagen(String chassisNumber, Integer productionYear, float carPrice) {
		super(chassisNumber, productionYear, carPrice);
	}

}
