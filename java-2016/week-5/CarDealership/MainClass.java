/**
 * 
 */

/**
 * @author andreistefan
 *
 */
public class MainClass {

	public static void main(String[] args){
		
		/*Vehicle vehicle = new VWGolf("1987ddkshik289", 30); //available fuel and chassis number

		vehicle.start();

		vehicle.drive(1);

		vehicle.stop();

		Car car2 = (Car) vehicle;
		
		
		double availableFuel = car2.getCurrentFuelAmmount();
		System.out.println("Available fuel is: " + availableFuel);
		
		
		double fuelConsumedKm = car2.getAverageFuelConsumption();
		System.out.println("Current consumption: " + car2.getCurrentConsumption());
		System.out.println("Current number of km: " + car2.getCurrentKm());
		System.out.println("Average fuel consumed is: " + fuelConsumedKm);*/
		
		
		//Car car = new Car(); // Car should be a base class.

		int currentFuelAmmount = 40;

		String chasseNumber = "oiqe0934hkkadsn";

		//Car car = new Dacia(currentFuelAmmount, chasseNumber); // This should not be allowed! If I want to create a Dacia car, I will need to create an instance of a model.

		Car car = new VWGolf(chasseNumber, currentFuelAmmount); // Logan can extend from Dacia, while Dacia extends from Car

		car.start();

		car.shiftGear(1);

		car.drive(0.01);// drives 0.01 KMs

		car.shiftGear(2);

		car.drive(3);

		car.shiftGear(3);

		car.drive(100);

		car.shiftGear(4);

		car.drive(0.5);

		car.shiftGear(4);

		car.drive(0.5);

		car.shiftGear(5);

		car.drive(10);

		car.shiftGear(4);

		car.drive(0.5);

		car.shiftGear(3);

		car.drive(0.1);

		car.stop();
		
		double availableFuel = car.getCurrentFuelAmmount();
		System.out.println("Available fuel is: " + availableFuel);
		
		
		double fuelConsumedKm = car.getAverageFuelConsumption();
		System.out.println("Current consumption: " + car.getCurrentConsumption());
		System.out.println("Current number of km: " + car.getCurrentKm());
		System.out.println("Average fuel consumed is: " + fuelConsumedKm);

	}
}
