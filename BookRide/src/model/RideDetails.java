package model;

/**
 * RideDetails is used to store the car details and other information
 * 
 * @author Dheeraj
 *
 */
public class RideDetails {

	private User user;
	private String carName;
	private String carType;
	private String carRegistrationNumber;
	private int noOfPassengers;
	private String fromLocation;
	private String toLocation;
	private String rideDateAndTime;

	/**
	 * Intialize the RideDetails with the given parameters.
	 * 
	 * @param user                  One who is offering or booking a ride.
	 * @param carName               The name of the car.
	 * @param carType               The type of the car (SUV,Mini,Micro etc)
	 * @param carRegistrationNumber The car registration number.
	 * @param noOfPassengers        Number of passengers.
	 * @param fromLocation          Source Location
	 * @param toLocation            Destination Location.
	 * @param rideDateAndTime       When the ride beigins.
	 */
	public RideDetails(User user, String carName, String carType, String carRegistrationNumber, int noOfPassengers,
			String fromLocation, String toLocation, String rideDateAndTime) {
		super();
		this.user = user;
		this.carName = carName;
		this.carType = carType;
		this.carRegistrationNumber = carRegistrationNumber;
		this.noOfPassengers = noOfPassengers;
		this.fromLocation = fromLocation;
		this.toLocation = toLocation;
		this.rideDateAndTime = rideDateAndTime;
	}

	/**
	 * To get the user details
	 * 
	 * @return user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * To get the name of the car.
	 * 
	 * @return the car name.
	 */
	public String getCarName() {
		return carName;
	}

	/**
	 * To get the type of the car.
	 * 
	 * @return the car type.
	 */
	public String getCarType() {
		return carType;
	}

	/**
	 * To get the registration number of the car.
	 * 
	 * @return the car registration number.
	 */
	public String getCarRegistrationNumber() {
		return carRegistrationNumber;
	}

	/**
	 * To get the number of passengers can travel in the car.
	 * 
	 * @return the number of passengers can travel
	 */
	public int getNoOfPassengers() {
		return noOfPassengers;
	}

	/**
	 * Set the number of passengers.
	 * 
	 * @param noOfPassengers Number of passengers
	 */
	public void setNoOfPassengers(int noOfPassengers) {
		this.noOfPassengers = noOfPassengers;
	}

	/**
	 * To get the source location.
	 * 
	 * @return the source location of the car.
	 */
	public String getFromLocation() {
		return fromLocation;
	}

	/**
	 * To get the destination location.
	 * 
	 * @return the destination location of the car.
	 */
	public String getToLocation() {
		return toLocation;
	}

	/**
	 * To get the ride starting date and time.
	 * 
	 * @return the ride starting date and time.
	 */
	public String getRideDateAndTime() {
		return rideDateAndTime;
	}

}
