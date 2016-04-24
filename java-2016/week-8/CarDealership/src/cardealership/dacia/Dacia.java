package cardealership.dacia;

import cardealership.car.*;

abstract class Dacia extends Car {

	public Dacia(float currentFuelAmount, String chassisNumber, FuelType fuelType, int numberOfGears,
			float fuelTankCapacity, float fuelConsumptionRate) {
		super(currentFuelAmount, chassisNumber, fuelType, numberOfGears, fuelTankCapacity, fuelConsumptionRate);
	}

	public Dacia(String chassisNumber, Integer productionYear, float carPrice) {
		super(chassisNumber, productionYear, carPrice);
	}

}
