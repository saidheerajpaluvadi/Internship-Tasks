import java.util.List;

import model.RideDetails;
import model.User;

/**
 * Main class will take the required inputs and produces services to find a
 * ride, offer a ride to move from one location to another.
 * 
 * @author Dheeraj
 *
 */
public class Main {

	/**
	 * inpuFromConsole is used to read the user input.
	 */
	private static InputFromConsole inputFromConsole;

	/**
	 * currentUser represents the currently logged in user.
	 */
	private static User currentUser;

	/**
	 * rideService is used to offer or book a ride
	 */
	private static RideService rideService;

	public static void main(String[] args) {

		inputFromConsole = InputFromConsole.getInstance();
		rideService = new RideService();

		// Adding few users intially.
		LoginService.initFewUsers();

		// Offereing few rides intially.
		rideService.initFewOfferedRides();

		System.out.println("Welcome to Book Ride App\n\n");

		currentUser = inputFromConsole.inputLoginDetails();

		do {

			int inputChoice = inputFromConsole.inputMenuChoice();
			switch (inputChoice) {
			case 1:
				findRide();
				break;
			case 2:
				offerRide();
				break;
			case 3:
				aboutUs();
				break;
			case 4:
				System.out.println("\nThank you for using our application\n\n");
				System.exit(0);
			default:
				System.out.println("Please enter a valid choice...");
			}

		} while (true);

	}

	/**
	 * findRide is used to find a ride from one location to other
	 */
	private static void findRide() {

		List<RideDetails> availableRides;
		availableRides = inputFromConsole.inputRideDetails(currentUser, rideService.getOfferedRides());
		rideService.bookRide(availableRides);
	}

	/**
	 * offerRide is used to offer a ride from one location to other
	 */
	private static void offerRide() {
		if (rideService.isValidToOfferRide(currentUser)) {
			RideDetails rideDetails = inputFromConsole.inputOfferRideDetails(currentUser);
			rideService.addOfferRide(rideDetails);
		}

	}

	/**
	 * Decription about our application
	 */
	private static void aboutUs() {
		System.out.println("Hi, We enable various travellers to meet on one platform");
	}

}
