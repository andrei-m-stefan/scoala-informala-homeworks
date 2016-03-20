/**
 * 
 */

/**
 * @author andreistefan
 *
 */
public abstract class Car implements Vehicle{
	
	public String chasseNumber;
	public float fuelTank;
	public String fuelType;
	
	public int nrGears;
	public int currentGear;
	
	public float fuelConsumption;
	public double currentConsumption;

	public double currentKm;
	public double currentFuelAmmount;
	
	
	public Car(String chasseNumber, float fuelTank, String fuelType, int nrGears, float fuelConsumption, 
			float currentFuelAmmount){
		
		this.chasseNumber = chasseNumber;
		this.fuelTank = fuelTank;
		this.fuelType = fuelType;
		this.nrGears = nrGears;
		this.fuelConsumption = fuelConsumption;
		this.currentFuelAmmount = currentFuelAmmount;
		
		if(currentFuelAmmount == 0){
			System.out.println("Fuel tank empty! Sorry.");
			System.exit(0);
		}
	}
	
	public String getChasseNumber(){
		return chasseNumber;
	}
	
	public void setChasseNumber(String chasseNumber){
		this.chasseNumber = chasseNumber;
	}
	
	public int getCurrentGear(){
		return currentGear;
	}
	
	public void setCurrentGear(int currentGear){
		this.currentGear = currentGear;
	}
	
	public float getFuelConsumption(){
		return fuelConsumption;
	}
	
	public void setFuelConsumption(float fuelConsumption){
		this.fuelConsumption = fuelConsumption;
	}
	
	public double getCurrentConsumption(){
		return currentConsumption;
	}
	
	public void setCurrentConsumption(double fuel){
		this.currentConsumption = fuel;
	}
	
	public double getCurrentKm(){
		return currentKm;
	}
	
	public void setCurrentKm(double distanceDriven){
		this.currentKm = distanceDriven;
	}
	
	public double getCurrentFuelAmmount(){
		return currentFuelAmmount;
	}
	
	public void setcurrentFuelAmmount(double fuel){
		this.currentFuelAmmount = fuel;
	}
	
	public void remainingFuel(){
		double fuel;
		
		fuel = this.currentFuelAmmount - this.getCurrentConsumption();
		this.setcurrentFuelAmmount(fuel);
	}
	
	public abstract double consumptionPerDistance(double distance, int gear);
	
	
	
	public void start(){
		this.setCurrentConsumption(0);
		this.setCurrentKm(0);
	}
	
	public void shiftGear(int i){
		this.currentGear = i;
	}
	
	public void drive(double distance){
		double fuel;
		double distanceDriven;
		
		
		fuel = this.getCurrentConsumption() + consumptionPerDistance(distance, this.currentGear);
		this.setCurrentConsumption(fuel);
		distanceDriven = this.getCurrentKm() + distance;
		this.setCurrentKm(distanceDriven);
		
	}
	
	
	public void stop(){
		remainingFuel();
		this.setCurrentGear(0);
		
	}
	
	public double getAverageFuelConsumption(){
		double fuelConsumedPer100Km;
		
		fuelConsumedPer100Km = this.getCurrentConsumption() / this.getCurrentKm() * 100;
		return fuelConsumedPer100Km;
	}
	
		
}
