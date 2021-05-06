import model.User;

/**
 * Main class will take the required inputs and produces services to buy fruits
 * from the store.
 * 
 * @author Dheeraj
 *
 */
public class Main {

	/**
	 * inputFromConsole is used to read the user input.
	 */
	private static InputFromConsole inputFromConsole = InputFromConsole.getInstance();

	/**
	 * currentUser represents the currently logged in user.
	 */
	private static User currentUser;

	/**
	 * Shows the welcome message. Add few users and fruits to store intially.
	 * 
	 * @param args command line arguments.
	 */
	public static void main(String[] args) {
		System.out.println("Welcome to Fruit Store\n\n");

		// Adding few users intially.
		LoginService.initFewUsers();

		currentUser = inputFromConsole.inputLoginDetails();

		// Adding few fruits to the store intially.
		FruitShopService.initFruitsData();

		do {

			int inputChoice = inputFromConsole.inputMenuChoice();
			switch (inputChoice) {
			case 1:
				showFruits();
				break;
			case 2:
				viewCart();
				break;
			case 3:
				checkOut();
				break;
			case 4:
				viewOffers();
				break;
			case 5:
				System.out.println("\nThank you for using our application\n\n");
				System.exit(0);
			default:
				System.out.println("Please enter a valid choice...");
			}

		} while (true);

	}

	/**
	 * Print the offers available.
	 */
	private static void viewOffers() {
		FruitShopService.printOffers();
	}

	/**
	 * Check out will generate the bill.
	 */
	private static void checkOut() {
		FruitShopService.checkOut(currentUser);
	}

	/**
	 * It will show you the fruits selected to buy from the store.
	 */
	private static void viewCart() {
		FruitShopService.printCart(currentUser);
	}

	/**
	 * It will print the fruits available in the store and enable users to select
	 * their desired fruit.
	 */
	private static void showFruits() {
		FruitShopService.printFruits();
		FruitShopService.selectFruits(currentUser);
	}
}
