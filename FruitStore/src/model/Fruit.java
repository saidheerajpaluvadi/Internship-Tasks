package model;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Fruit is used to store the details of a fruit.
 * 
 * @author Dheeraj
 *
 */
public class Fruit {

	private final long id;
	private final String name;
	private double price;
	private final FruitQuality quality;
	private final Date bestBeforeUse;

	/**
	 * Constructs the fruit with given parameters.
	 * 
	 * @param id            Unique Id given to the fruit.
	 * @param name          Name of the fruit.
	 * @param price         The price of the fruit.
	 * @param quality       The quality of fruit.
	 * @param bestBeforeUse Indicates the expiry of fruit.
	 */
	public Fruit(long id, String name, double price, FruitQuality quality, Date bestBeforeUse) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.quality = quality;
		this.bestBeforeUse = bestBeforeUse;
	}

	/**
	 * To get the name of the fruit.
	 * 
	 * @return Name of the fruit.
	 */
	public String getName() {
		return name;
	}

	/**
	 * To get the price of the fruit based on its quality.
	 * 
	 * @return the price of fruit based on quality.
	 */
	public double getPrice() {
		switch (quality) {
		case BEST:
			return price + 40;
		case MODERATE:
			return price + 20;
		case LOW:
			return price;
		default:
			System.out.println("Invalid quality");
			return 0;
		}
	}

	/**
	 * To get the Id of the fruit.
	 * 
	 * @return the id of the fruit.
	 */
	public long getId() {
		return id;
	}

	/**
	 * To get the expiry of fruit.
	 * 
	 * @return the best before use of fruits.
	 */
	public String getBestBeforeUse() {
		 SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");    
		return formatter.format(bestBeforeUse);
	}

	/**
	 * To get the quality of fruit.
	 * 
	 * @return the quality of fruit.
	 */
	public FruitQuality getQuality() {
		return quality;
	}

}
