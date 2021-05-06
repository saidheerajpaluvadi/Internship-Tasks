import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.BookingDetails;
import model.RideDetails;
import model.User;

/**
 * RideService is used to offer or book a ride from one location to another
 * location.
 * 
 * @author Dheeraj
 *
 */
public class RideService {

	/**
	 * offeredRides is the list of rides offered by various users.
	 */
	private List<RideDetails> offeredRides;

	/**
	 * bookings is the list of bookings done by the various users.
	 */
	private List<BookingDetails> bookings = new ArrayList<BookingDetails>();

	/**
	 * Offereing few rides by default.
	 */
	public List<RideDetails> initFewOfferedRides() {
		offeredRides = new ArrayList<RideDetails>();
		offeredRides.add(new RideDetails(new User("Sai", 23, "planon1", "planon123"), "Swift", "Mini", "TS 20 A1234", 3,
				"Hyderabad", "Vizag", "05/05/2021 10:30:00"));
		offeredRides.add(new RideDetails(new User("Sai", 23, "planon2", "planon123"), "i10", "Mini", "TS 20 A4567", 3,
				"Hyderabad", "Warangal", "05/05/2021 11:30:00"));
		return offeredRides;
	}

	/**
	 * getOfferedRides: List of rides offered by various users till now.
	 * 
	 * @return offeredRides List of rides offered
	 */
	public List<RideDetails> getOfferedRides() {
		return offeredRides;
	}

	/**
	 * isValidToOfferRide: Checks wether a user can offer a ride or not.
	 * 
	 * @param currentUser The user who is currently logged in.
	 * @return true if eligible to offer a ride.
	 */
	public boolean isValidToOfferRide(User currentUser) {
		if (offeredRides.stream().filter((x) -> x.getUser().getUserName().equals(currentUser.getUserName()))
				.count() == 1)
			throw new UnsupportedOperationException("You already offered one ride. Cannot offer now");
		else
			return true;

	}

	/**
	 * addOfferRide: Adds a ride to the list of Offered rides.
	 * 
	 * @param rideDetails Ride to be added into the list.
	 * @return true if ride added successfully.
	 */
	public boolean addOfferRide(RideDetails rideDetails) {
		System.out.println("Your ride from " + rideDetails.getFromLocation() + " to " + rideDetails.getToLocation()
				+ " at " + rideDetails.getRideDateAndTime() + " is offered successfully...");
		return offeredRides.add(rideDetails);

	}

	/**
	 * bookRide: It will display the available rides and enables the users to choose
	 * one of them.
	 * 
	 * @param availableRides List of ride details which are available now.
	 */
	public void bookRide(List<RideDetails> availableRides) {
		if (availableRides.isEmpty())
			System.out.println("Sorry, could not find any ride...\n");
		else {

			printRideDetails(availableRides);

			System.out.println("\nEnter the S.no for which you want to book: ");
			int inputSerialNo = InputFromConsole.getInstance().inputNumber();

			if (inputSerialNo > availableRides.size())
				throw new RuntimeException("Please enter a valid serial number");

			RideDetails ride = availableRides.get(inputSerialNo - 1);

			System.out.println("Enter the number of passengers you want to book:");
			int inputNoOfPassengers = InputFromConsole.getInstance().inputNumber();

			if (ride.getNoOfPassengers() >= inputNoOfPassengers)
				ride.setNoOfPassengers(ride.getNoOfPassengers() - inputNoOfPassengers);
			else
				throw new RuntimeException(inputNoOfPassengers + " seats are not available for your selected ride");

			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			Date date = new Date();
			String currentDateTime = formatter.format(date);

			bookings.add(new BookingDetails(currentDateTime, ride));

			System.out.println("Your ride from " + ride.getFromLocation() + " to " + ride.getToLocation()
					+ " is booked on " + currentDateTime);
		}

	}

	/**
	 * It will print the available ride details.
	 * 
	 * @param availableRides List of ride details which are available now.
	 */
	private void printRideDetails(List<RideDetails> availableRides) {
		int counter = 1;
		System.out.format("%3s\t%10s\t%3s\t%10s\t%s\t%10s\t%s\n", "S.no", "CarOwner", "Age", "CarName", "CarType",
				"Seats Available", "RideDate");
		for (RideDetails ride : availableRides) {
			User rideProvider = ride.getUser();
			System.out.format("%3s\t%10s\t%3s\t%10s\t%s\t%10s\t%s\n", counter, rideProvider.getFirstName(),
					rideProvider.getAge(), ride.getCarName(), ride.getCarType(), ride.getNoOfPassengers(),
					ride.getRideDateAndTime());

			counter++;
		}
	}

}
