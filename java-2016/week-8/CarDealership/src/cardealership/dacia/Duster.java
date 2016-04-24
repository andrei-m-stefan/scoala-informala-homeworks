package cardealership.dacia;

import cardealership.car.*;
import java.util.ArrayList;

public class Duster extends Dacia {

	private static final float FUEL_TANK_LEVEL = 60f;
	private static final float FUEL_CONSUMPTION_RATE = 6.6f;
	private static final int NUMBER_OF_GEARS = 6;
	private static final FuelType FUEL_TYPE = FuelType.DIESEL;

	private ArrayList<Float> values = new ArrayList<Float>();

	private float averageFuelConsumption;

	public Duster(float currentFuelAmount, String chassisNumber) {
		super(currentFuelAmount, chassisNumber, FUEL_TYPE, NUMBER_OF_GEARS, FUEL_TANK_LEVEL, FUEL_CONSUMPTION_RATE);
	}

	public Duster(String chassisNumber, Integer productionYear, float carPrice) {
		super(chassisNumber, productionYear, carPrice);
	}

	@Override
	public float setConsumptionRate() {

		switch (getGearNumber()) {
		case 1:
			averageFuelConsumption = (float) (FUEL_CONSUMPTION_RATE + 0.25);
			values.add(averageFuelConsumption);
			break;
		case 2:
			averageFuelConsumption = (float) (FUEL_CONSUMPTION_RATE + 0.2);
			values.add(averageFuelConsumption);
			break;
		case 3:
			averageFuelConsumption = (float) (FUEL_CONSUMPTION_RATE + 0.17);
			values.add(averageFuelConsumption);
			break;
		case 4:
			averageFuelConsumption = (float) (FUEL_CONSUMPTION_RATE + 0.14);
			values.add(averageFuelConsumption);
			break;
		case 5:
			averageFuelConsumption = (float) (FUEL_CONSUMPTION_RATE + 0.11);
			values.add(averageFuelConsumption);
			break;
		case 6:
			averageFuelConsumption = (float) (FUEL_CONSUMPTION_RATE + 0.1);
			values.add(averageFuelConsumption);
			break;
		default:
			averageFuelConsumption = (float) FUEL_CONSUMPTION_RATE;
			values.add(averageFuelConsumption);
			break;
		}
		return averageFuelConsumption;
	}

	public float getAverageFuelConsumption() {
		float sumOfAverageFuelConsumption = 0f;
		for (int i = 0; i < values.size(); i++) {
			sumOfAverageFuelConsumption += values.get(i);
		}
		return sumOfAverageFuelConsumption / values.size();
	}

	@Override
	public int compareTo(Car o) {
		return compareTo(o);
	}

	@Override
	public String toString() {
		return "Duster [Chassis Number=" + super.getChassisNumber() + ", Production Year=" + super.getProductionYear()
				+ "]";
	}

}
