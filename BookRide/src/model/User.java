package model;

/**
 * User will handle the user details.
 * 
 * @author dheeraj
 *
 */
public class User {

	private String firstName;
	private int age;
	private String userName;
	private String password;

	/**
	 * Intialize the User with given parameters.
	 * 
	 * @param firstName First Name of the User.
	 * @param age       Age of the User.
	 * @param userName  user name to login.
	 * @param password  password for a user to login.
	 */
	public User(String firstName, int age, String userName, String password) {
		this.firstName = firstName;
		this.age = age;
		this.userName = userName;
		this.password = password;
	}

	/**
	 * To get the First name of a user.
	 * 
	 * @return {@code firstName} of a user.
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * To get the age of a user.
	 * 
	 * @return {@code age} of a user.
	 */
	public int getAge() {
		return age;
	}

	/**
	 * To get the user name of a user.
	 * 
	 * @return {@code userName} of a user.
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * To get the password of a user.
	 * 
	 * @return {@code password} of a user.
	 */
	public String getPassword() {
		return password;
	}
}
