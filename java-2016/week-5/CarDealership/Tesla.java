/**
 * 
 */

/**
 * @author andreistefan
 *
 */
public abstract class Tesla extends Car{

	protected static String fuelType = "Electric";
	
	
	public Tesla(String chasseNumber, float fuelTank, int nrGears, float fuelConsumption, float currentFuelAmmount) {
		
		super(chasseNumber, fuelTank, fuelType, nrGears, fuelConsumption, currentFuelAmmount);
		
		
	}

	public abstract double consumptionPerDistance(double distance, int gear);
	
}
