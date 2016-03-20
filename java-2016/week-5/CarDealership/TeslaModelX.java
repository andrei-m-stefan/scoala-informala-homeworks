/**
 * 
 */

/**
 * @author andreistefan
 *
 */
public class TeslaModelX extends Tesla{

	private static float fuelTank = 90;
	private static int nrGears = 2;
	private static float fuelConsumption = 6f;
	
	public TeslaModelX(String chasseNumber, float currentFuelAmmount) {
		
		super(chasseNumber, fuelTank, nrGears, fuelConsumption, currentFuelAmmount);

	}

	public float fuelPerGear(int gear){
		float fuel = 0;
		
		if(this.currentFuelAmmount <= TeslaModelX.fuelTank)
		
			switch(gear) {
			
			case 1:
				fuel = 6f;
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
			hasConsumed = this.fuelPerGear(1) * distance / 100;
			return hasConsumed;
		}
		else{
			return(fuelConsumption * distance);
		}

	}
	
}
