package cardealership.car;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public abstract class Car implements Vehicle, Comparable<Car> {

	private float fuelTankCapacity;
	private float currentFuelAmount;
	private float fuelConsumptionRate;
	private float availableFuel;
	private FuelType fuelType;
	private List<Float> fuelValues = new ArrayList<Float>();

	private int gearNumber;
	private int numberOfGears;

	private String chassisNumber;

	private float distanceDriven = 0f;
	public Integer productionYear;
	private float carPrice;

	public Car(float currentFuelAmount, String chassisNumber, FuelType fuelType, int numberOfGears,
			float fuelTankCapacity, float fuelConsumptionRate) {
		this.currentFuelAmount = currentFuelAmount;
		this.chassisNumber = chassisNumber;
		this.fuelType = fuelType;
		this.numberOfGears = numberOfGears;
		this.fuelTankCapacity = fuelTankCapacity;
		this.fuelConsumptionRate = fuelConsumptionRate;
	}


	public Car(String chassisNumber, Integer productionYear, float carPrice) {
		this.chassisNumber = chassisNumber;
		this.productionYear = productionYear;
		this.carPrice = carPrice;
	}

	public static final Comparator<Car> SORT_BY_AGE = new Comparator<Car>() {

		@Override
		public int compare(Car o1, Car o2) {
			return o1.productionYear.compareTo(o2.productionYear);
		}

	};

	public Integer getProductionYear() {
		return productionYear;
	}

	public void setProductionYear(Integer productionYear) {
		this.productionYear = productionYear;
	}

	public float getCarPrice() {
		return carPrice;
	}

	public void setCarPrice(float carPrice) {
		this.carPrice = carPrice;
	}

	public float getFuelCapacity() {
		return fuelTankCapacity;
	}

	public void setFuelTankCapacity(float fuelTankCapacity) {
		this.fuelTankCapacity = fuelTankCapacity;
	}

	public float getCurrentFuelAmount() {
		return currentFuelAmount;
	}

	public void setCurrentFuelAmount(float currentFuelAmount) {
		this.currentFuelAmount = currentFuelAmount;
	}

	public abstract float getAverageFuelConsumption();

	public float getFuelConsumptionRate() {
		return fuelConsumptionRate;
	}

	public void setFuelConsumptionRate(float fuelConsumptionRate) {
		this.fuelConsumptionRate = fuelConsumptionRate;
	}

	public abstract float setConsumptionRate();

	public int getGearNumber() {
		return gearNumber;
	}

	public void shiftGear(int gearNumber) { 
		System.out.println("You changed into gear " + gearNumber);
		this.gearNumber = gearNumber;
		setConsumptionRate();
	}

	public int getNumberOfGears() {
		return numberOfGears;
	}

	public void setNumberOfGears(int numberOfGears) {
		this.numberOfGears = numberOfGears;
	}

	public FuelType getFuelType() {
		return fuelType;
	}

	public void setFuelType(FuelType fuelType) {
		this.fuelType = fuelType;
	}

	public String getChassisNumber() {
		return chassisNumber;
	}

	public double getDistanceDriven() {
		System.out.printf("You drove a total of %.2f%s%n", distanceDriven, " kilometers.");
		return distanceDriven;
	}

	public void setDistanceDriven(float distanceDriven) {
		this.distanceDriven = distanceDriven;
	}

	@Override
	public void start() {
		System.out.printf("You start the car with %.2f %s %s%s %n", getCurrentFuelAmount(), "liters of", getFuelType(),
				".");
		setCurrentFuelAmount(currentFuelAmount);
		fuelValues.clear();
	}

	@Override
	public void stop() {
		System.out.printf("You stop the car. You have used %.4f %s %s%s %n", currentFuelAmount - getAvailableFuel(),
				"liters of", getFuelType(), ".");
	}

	@Override
	public double drive(double kilometers) {
		setConsumptionRate();
		getAvailableFuel();
		System.out.println("You drive " + kilometers + " kilometers");
		return distanceDriven += kilometers;
	}

	public float getAvailableFuel() {
		float usedFuel = (float) ((distanceDriven * getAverageFuelConsumption() / 100));
		availableFuel = getCurrentFuelAmount() - usedFuel;
		return availableFuel;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((chassisNumber == null) ? 0 : chassisNumber.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Car other = (Car) obj;
		if (chassisNumber == null) {
			if (other.chassisNumber != null)
				return false;
		} else if (!chassisNumber.equals(other.chassisNumber))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Car [Chassis Number=" + chassisNumber + ", Production Year=" + productionYear + "]";
	}

}
