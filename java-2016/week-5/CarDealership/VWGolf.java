/**
 * 
 */

/**
 * @author andreistefan
 *
 */
public class VWGolf extends VW{

	private static float fuelTank = 50;
	private static String fuelType = "Diesel";
	private static int nrGears = 5;
	private static float fuelConsumption = 6.3f;

	
	public VWGolf(String chasseNumber, float currentFuelAmmount) {
		
		super(chasseNumber, fuelTank, fuelType, nrGears, fuelConsumption, currentFuelAmmount);
		
	}


	public float fuelPerGear(int gear){
		float fuel;
		
		switch(gear) {
			
		case 1:
			fuel = 9.6f;
			break;
		case 2:
			fuel = 8.3f;
			break;
		case 3:
			fuel = 6.3f;
			break;
		case 4:
			fuel = 5.5f;
			break;
		case 5:
			fuel = 7.2f;
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
			//hasConsumed = hasConsumed * this.cheatDevice();
			return hasConsumed * this.cheatDevice();
		}
		else{
			return(fuelConsumption * distance * this.cheatDevice());
		}
	}

}

