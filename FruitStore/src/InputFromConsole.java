import java.util.Scanner;

import model.User;

/**
 * InputFromConsole will reads the user input from consle using the
 * {@link Scanner} class. InputFromConsole will intantiated only once which
 * means it is a singleton class.
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
		scanner = new Scanner(System.in);
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
		System.out.println("\nMenu");
		System.out.println("1. Show Fruits");
		System.out.println("2. View Cart");
		System.out.println("3. Check Out");
		System.out.println("4. Show Offers");
		System.out.println("5. Exit");
		System.out.print("Please enter your choice [1-5]: ");
		return Integer.parseInt(scanner.nextLine());
	}

	/**
	 * Take the number input from user.
	 * 
	 * @return the number which is read.
	 */
	public int inputNumber() {
		return Integer.parseInt(scanner.nextLine());
	}

	/**
	 * Take the character input from user.
	 * 
	 * @return the character which is read.
	 */
	public char inputCharacter() {
		return scanner.nextLine().charAt(0);
	}

}
