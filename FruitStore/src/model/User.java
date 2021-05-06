package model;

import java.util.LinkedHashMap;
import java.util.Map;

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
	private int points;
	private Map<Long,Integer> cart;

	/**
	 * Intialize the User with given parameters.
	 * 
	 * @param firstName First Name of the User.
	 * @param age       Age of the User.
	 * @param userName  user name to login.
	 * @param password  password for a user to login.
	 * @param points 	points are useful to decrease the billing amount. 
	 */
	public User(String firstName, int age, String userName, String password,int points) {
		this.firstName = firstName;
		this.age = age;
		this.userName = userName;
		this.password = password;
		this.points = points;
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

	/**
	 * To get the points of the user.
	 * 
	 * @return the points of the user.
	 */
	public int getPoints() {
		return points;
	}
	
	/**
	 * To set the points for the user
	 * 
	 * @param points points to be set.
	 */
	public void setPoints(int points) {
		this.points = points;
	}

	/**
	 * To add the points for the user
	 * 
	 * @param points points to be added.
	 */
	public void addPoints(int points) {
		this.points += points;
	}

	/**
	 * Cart is used to store the fruits selecetd by the user.
	 * 
	 * @return the list of fruits selected by the user.
	 */
	public Map<Long, Integer> getCart() {
		if (cart == null)
			cart = new LinkedHashMap<Long,Integer>();
		return cart;
	}

	/**
	 * To set the user cart
	 * 
	 * @param cart The cart details to be set.
	 */
	public void setCart(Map<Long, Integer> cart) {
		this.cart = cart;
	}

}
