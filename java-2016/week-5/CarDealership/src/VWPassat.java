/**
 * 
 */

/**
 * @author andreistefan
 *
 */
public class VWPassat extends VW {

	private static float fuelTank = 63;
	private static String fuelType = "Petrol";
	private static int nrGears = 6;
	private static float fuelConsumption = 7.1f;
	
	public VWPassat(String chasseNumber, float currentFuelAmmount) {
	
		super(chasseNumber, fuelTank, fuelType, nrGears, fuelConsumption, currentFuelAmmount);
	}

	public float fuelPerGear(int gear){
		float fuel;
		
		switch(gear) {
			
		case 1:
			fuel = 11.2f;
			break;
		case 2:
			fuel = 10.4f;
			break;
		case 3:
			fuel = 8.8f;
			break;
		case 4:
			fuel = 8.1f;
			break;
		case 5:
			fuel = 7.2f;
			break;
		case 6:
			fuel = 7.9f;
			break;
		default:
			fuel = 0;
			break;
		}
		
		return fuel;
	}
	
	@Override
	public double consumptionPerDistance(double distance, int gear) {
		double hasConsumed;
		
		if(gear != 0){
			hasConsumed = fuelPerGear(this.getCurrentGear()) * distance / 100;
			return hasConsumed * this.cheatDevice();
		}
		else{
			return(fuelConsumption * distance * this.cheatDevice());
		}
	}
	
	
}
