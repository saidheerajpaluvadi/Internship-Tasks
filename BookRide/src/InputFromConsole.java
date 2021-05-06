import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import model.RideDetails;
import model.User;

/**
 * InputFromConsole will reads the user input from consle using the
 * {@link Scanner} class.
 * 
 * @author Dheeraj
 *
 */
public class InputFromConsole {
	
	private static InputFromConsole inputFromConsole;

	/**
	 * scanner is used to take inputs from the user.
	 */
	private Scanner scanner;

	/**
	 * Intialize the scanner object.
	 */
	private InputFromConsole() {
		this.scanner = new Scanner(System.in);
	}
	
	/**
	 * It is used get the instance of this class.
	 * 
	 * @return {@link InputFromConsole} instance.
	 */
	public static InputFromConsole getInstance() {
		if (inputFromConsole == null) {
			inputFromConsole = new InputFromConsole();
		}
		return inputFromConsole;
	}

	/**
	 * Take the user login details.
	 * 
	 * @return User if the provides details are valid.
	 */
	public User inputLoginDetails() {
		
		System.out.println("Login\n");
		System.out.print("Enter your user name: ");
		String inputUserName = scanner.nextLine();

		System.out.print("Enter your Password: ");
		String inputPassword = scanner.nextLine();

		return LoginService.userLogin(inputUserName, inputPassword);
	}

	/**
	 * Display the services provides by our application.
	 * 
	 * @return option chooses=d by the user.
	 */
	public int inputMenuChoice() {
		System.out.println("Menu");
		System.out.println("1. Find a ride");
		System.out.println("2. Offer a ride");
		System.out.println("3. About Us");
		System.out.println("4. Exit");
		System.out.print("Please enter your choice [1-4]: ");
		return Integer.parseInt(scanner.nextLine());
	}

	/**
	 * Take details to offer a particular ride.
	 * 
	 * @param currentUser The user who is offering the ride.
	 * @return {@link RideDetails} which contains ride information.
	 */
	public RideDetails inputOfferRideDetails(User currentUser) {

		System.out.print("Enter your Car name: ");
		String inputCarName = scanner.nextLine();

		System.out.print("Enter your Car type: ");
		String inputCarType = scanner.nextLine();

		System.out.print("Enter your Car registration number: ");
		String inputCarRegistrationNumber = scanner.nextLine();

		System.out.print("Enter fo number of passengers you want to offer: ");
		int inputNoOfPassengers = Integer.parseInt(scanner.nextLine());

		System.out.print("Enter From Location: ");
		String inputFromLocation = scanner.nextLine();

		System.out.print("Enter To Location: ");
		String inputToLocation = scanner.nextLine();

		String inputRideDateAndTime;
		while (true) {
			System.out.print("Enter Date and time of your journey in this format [dd/MM/yyyy HH:mm:ss]: ");
			inputRideDateAndTime = scanner.nextLine();
			if (isValidDate(inputRideDateAndTime))
				break;
		}

		return new RideDetails(currentUser, inputCarName, inputCarType, inputCarRegistrationNumber, inputNoOfPassengers,
				inputFromLocation, inputToLocation, inputRideDateAndTime);

	}

	/**
	 * Check whether the date is valid or not
	 * 
	 * @param inputDate string to be checked.
	 * @return true if the string is valid.
	 */
	public static boolean isValidDate(String inputDate) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		dateFormat.setLenient(false);
		try {
			dateFormat.parse(inputDate.trim());
		} catch (ParseException pe) {
			return false;
		}
		return true;
	}

	/**
	 * Takes the input to find a ride from one location to other and searches for
	 * any rides are available. If rides are available returns the list of ride
	 * details
	 * 
	 * @param currentUser  The user who is searching for a ride.
	 * @param offeredRides The list of rides offer by various users.
	 * @return The list of rides available from source to destination.
	 */
	public List<RideDetails> inputRideDetails(User currentUser, List<RideDetails> offeredRides) {
		System.out.print("Enter From Location: ");
		String inputFromLocation = scanner.nextLine();

		System.out.print("Enter To Location: ");
		String inputToLocation = scanner.nextLine();

		System.out.println("\nSearching rides to " + inputToLocation + "...\n");

		List<RideDetails> availableRides = offeredRides.stream()
				.filter((x) -> !(x.getUser().getUserName().equals(currentUser.getUserName()))
						&& x.getFromLocation().equalsIgnoreCase(inputFromLocation)
						&& x.getToLocation().equalsIgnoreCase(inputToLocation) && x.getNoOfPassengers() > 0)
				.collect(Collectors.toList());
		return availableRides;
	}

	/**
	 * Take the number input from user.
	 * 
	 * @return the number which is read.
	 */
	public int inputNumber() {

		return Integer.parseInt(scanner.nextLine());
	}


}
