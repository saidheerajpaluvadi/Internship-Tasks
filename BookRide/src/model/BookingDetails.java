package model;

/**
 * Booking details is used to store the bookings made by the user
 * 
 * @author dheeraj
 *
 */
public class BookingDetails {

	private String bookingDateAndTime;
	private RideDetails rideDetails;

	/**
	 * Initialize the booking details with given parameters.
	 * 
	 * @param bookingDateAndTime Date and time when the booking was made.
	 * @param rideDetails Details of the ride.
	 */
	public BookingDetails(String bookingDateAndTime, RideDetails rideDetails) {
		this.bookingDateAndTime = bookingDateAndTime;
		this.rideDetails = rideDetails;
	}

	/**
	 * To get the ride details of a particular booking
	 * 
	 * @return details of the ride.
	 */
	public RideDetails getRideDetails() {
		return rideDetails;
	}
	
	/**
	 * To get when the booking was made.
	 * 
	 * @return the date and time when the booking is made.
	 */
	public String getBookingDateAndTime() {
		return bookingDateAndTime;
	}

}
