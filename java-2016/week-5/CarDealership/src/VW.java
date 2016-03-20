/**
 * 
 */

/**
 * @author andreistefan
 *
 */
public abstract class VW extends Car{

	
	public VW(String chasseNumber, float fuelTank, String fuelType, int nrGears, float fuelConsumption,
			float currentFuelAmmount) {
		
		super(chasseNumber, fuelTank, fuelType, nrGears, fuelConsumption, currentFuelAmmount);

	}

	
	public abstract double consumptionPerDistance(double distance, int gear);
	
	
	public double cheatDevice(){
		double cheat;
		
		cheat = 0.9;
		
		return cheat;
	}
	
}
