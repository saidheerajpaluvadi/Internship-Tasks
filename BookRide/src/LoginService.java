
import java.util.HashMap;
import java.util.Map;

import model.User;

/**
 * LoginService enables the users to login.
 * 
 * @author Dheeraj
 *
 */
public class LoginService {

	/**
	 * users is map which contains data in the form of key value pairs where key is
	 * the userName and value is the User object
	 */
	private static Map<String, User> users;

	/**
	 * Adding few users by default
	 *
	 */
	public static void initFewUsers() {
		users = new HashMap<String, User>();
		users.put("planon1", new User("Sai", 23, "planon1", "planon123"));
		users.put("planon2", new User("Sai", 23, "planon2", "planon123"));
		users.put("planon3", new User("Sai", 23, "planon3", "planon123"));
		users.put("planon4", new User("Sai", 23, "planon4", "planon123"));
	}

	/**
	 * userLogin: checks wether username and password are valid or not.
	 * 
	 * @param inputUserName username to check
	 * @param inputPassword password to check
	 * @return true if credentials are valid.
	 */
	public static User userLogin(String inputUserName, String inputPassword) {
		User currentUser;
		if (!users.containsKey(inputUserName))
			throw new RuntimeException("User name does not exist");

		currentUser = users.get(inputUserName);
		if (!currentUser.getPassword().equals(inputPassword))
			throw new RuntimeException("Invalid password");

		System.out.println("\n Logged in Successfully");
		return currentUser;

	}
}
