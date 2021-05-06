import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import model.Fruit;
import model.FruitQuality;
import model.User;

/**
 * FruitShopService will provide serives like printing the fruits available in
 * store, selecting the fruits required, generating the bill,calculating the
 * effective price and showing the cart.
 * 
 * @author Dheeraj
 *
 */
public class FruitShopService {

	/**
	 * fruits is map whose key value is Id of the fruit and value is the
	 * {@link Fruit} It will keep track of fruits avilable in the store.
	 */
	private static Map<Long, Fruit> fruits = new HashMap<Long, Fruit>();

	/**
	 * InputFromConsole is used to take the inputs from user.
	 */
	private static InputFromConsole inputFromConsole = InputFromConsole.getInstance();

	/**
	 * Intializing few fruits.
	 * 
	 * @throws ParseException
	 */
	public static void initFruitsData() {
		SimpleDateFormat myFormat = new SimpleDateFormat("dd/MM/yyyy");

		try {
			fruits.put((long) 1, new Fruit(1, "Mango", 100.0, FruitQuality.BEST, myFormat.parse("16/05/2021")));
			fruits.put((long) 2, new Fruit(2, "Mango", 100.0, FruitQuality.MODERATE, myFormat.parse("11/05/2021")));
			fruits.put((long) 3, new Fruit(3, "Apple", 120.0, FruitQuality.MODERATE, myFormat.parse("10/05/2021")));
			fruits.put((long) 4, new Fruit(4, "Guava", 40.0, FruitQuality.BEST, myFormat.parse("12/05/2021")));
			fruits.put((long) 5, new Fruit(5, "pineapple", 100.0, FruitQuality.LOW, myFormat.parse("12/05/2021")));
		} catch (ParseException e) {

			e.printStackTrace();
		}
	}

	/**
	 * Print the fruit available in the store.
	 */
	public static void printFruits() {
		System.out.println("\nFruits Available in our store: \n");
		System.out.format("%5s\t%10s\t%10s\t%10s\t%10s\n", "Id", "Name", "Quality", "Price", "Best Before Use");
		for (Fruit fruit : fruits.values()) {
			System.out.format("%5s\t%10s\t%10s\t%10s\t%10s\n", fruit.getId(), fruit.getName(), fruit.getQuality(),
					fruit.getPrice(), fruit.getBestBeforeUse());

		}
		System.out.println();
	}

	/**
	 * Enables the users to select the desired fruit.
	 * 
	 * @param currentUser the one who is selecting fruits.
	 */
	public static void selectFruits(User currentUser) {
		Map<Long, Integer> userCart = currentUser.getCart();
		char choice;
		do {
			System.out.print("Enter the Id of fruit you want to select: ");
			long selectedId = inputFromConsole.inputNumber();

			if (!fruits.containsKey(selectedId))
				throw new RuntimeException("Please enter a valid fruit Id");

			System.out.println("Enter the quantity: ");
			int quantity = inputFromConsole.inputNumber();

			if (userCart.containsKey(selectedId))
				userCart.put(selectedId, userCart.get(selectedId) + quantity);
			else
				userCart.put(selectedId, quantity);

			System.out.println("Added " + fruits.get(selectedId).getName() + " to cart successfully...");

			System.out.print("\nDo you want to add more [y/n]: ");
			choice = inputFromConsole.inputCharacter();
		} while (choice == 'y');

	}

	/**
	 * Print the fruits selected by the user.
	 * 
	 * @param currentUser the user who is logged in.
	 */
	public static void printCart(User currentUser) {
		System.out.println("\n Cart\n");
		Map<Long, Integer> userCart = currentUser.getCart();
		if (userCart.size() == 0) {
			System.out.println("Your cart is empty...");
		} else {
			System.out.format("%5s\t%10s\t%10s\t%5s\n", "Id", "Name", "Quantity", "Price");
			for (Long id : userCart.keySet()) {
				Fruit fruit = fruits.get(id);
				double price = fruit.getPrice() * userCart.get(id);
				System.out.format("%5s\t%10s\t%10s\t%5s\n", id, fruit.getName(), userCart.get(id), price);
			}
		}
	}

	/**
	 * To generate the invoice. On succesful purchase it will add points to the
	 * user.
	 * 
	 * @param currentUser the user who is logged in.
	 */
	public static void checkOut(User currentUser) {
		System.out.println("\n Invoice Details\n");
		Map<Long, Integer> userCart = currentUser.getCart();

		if (userCart.size() == 0) {
			System.out.println("Your cart is empty...");
		} else {
			double totalAmount = 0.0;
			System.out.format("%5s\t%10s\t%10s\t%10s\t%10s\t%10s\t%10s\n", "Id", "Name", "Quality", "Best Before Use",
					"Price", "Quantity", "Total Price");
			for (Long id : userCart.keySet()) {
				Fruit fruit = fruits.get(id);
				double price = fruit.getPrice() * userCart.get(id);
				totalAmount += price;
				System.out.format("%5s\t%10s\t%10s\t%10s\t%10s\t%10s\t%10s\n", id, fruit.getName(), fruit.getQuality(),
						fruit.getBestBeforeUse(), fruit.getPrice(), userCart.get(id), price);
			}

			double effectiveAmount = BillingService.calculateEffectiveAmount(currentUser, totalAmount);
			System.out.println("\nThe Effective Total Amount = " + effectiveAmount);

			BillingService.addPointsToUser(currentUser, effectiveAmount);
		}

		currentUser.setCart(null);
		System.out.println("\nThank you for using our application");
		System.exit(0);
	}


	/**
	 * Display the offer details.
	 */
	public static void printOffers() {
		System.out.println("\nOffers Available are:\n");
		System.out.println("If Total Price is >= 1000 then discount = 2%");
		System.out.println("If Total Price is >= 2000 then discount = 4%");
		System.out.println("If Total Price is >= 3000 then discount = 5%");
		System.out.println("On every purcahse of 1000rs 10 points will be added to your account ");
		System.out.println();
	}

}
