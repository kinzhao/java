package trivera.core;

public class Airport {

	public void checkIn(Passenger passenger) {

		// Using the 'if' statement, check the frequent flyer miles of the passenger
		// When the Frequent Flyer mileage of the passenger is zero, print "New
		// Passenger", else print "Frequent Flyer"
		if (passenger.getFrequentFlyerMiles() == 0) {
			System.out.println("New Passenger");
		} else {
			System.out.println("Frequent Flyer");
		}

		// Print out the passenger name and Frequent Flyer mileage
		System.out.println("Passenger " + passenger.getName() + " has " + passenger.getFrequentFlyerMiles() + " miles");

		// Using the switch statement print out the Member Level
		// The member level is defined as 'int memberLevel' within the Passenger class
		// 1 = Bronze
		// 2= Silver
		// 3 = Gold
		switch (passenger.getMemberLevel()) {
		case 1:
			System.out.println("Bronze Member");
			break;
		case 2:
			System.out.println("Silver Member");
			break;
		case 3:
			System.out.println("Gold Member");
			break;
		}

		//Print an empty line
		System.out.println("");
	}
}
