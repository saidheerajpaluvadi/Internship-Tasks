import model.User;

public class BillingService {
	
	
	/**
	 * It will calculate the effective amount to be paid. Effective amount is
	 * calculated by deducting the discount amount and user points.
	 * 
	 * @param currentUser the user who is currently Logged in.
	 * @param totalAmount the sum of prices of all the fruits selected.
	 * 
	 * @return the effective price to be paid.
	 * 
	 */
	public static double calculateEffectiveAmount(User currentUser, double totalAmount) {
		double effectiveAmount = 0.0;
		System.out.println("\nThe Total Amount = " + totalAmount);
		double discount = calculateDiscount(totalAmount);
		effectiveAmount = totalAmount - discount;
		System.out.println("\nThe discount amount = " + discount);

		System.out.println("\nPoints Available: " + currentUser.getPoints());
		
		System.out.print("Do you want to use your points [y/n]: ");
		char choice = InputFromConsole.getInstance().inputCharacter();
		if (choice == 'y')
			effectiveAmount = usePointsToDeductAmount(currentUser, effectiveAmount);
		return effectiveAmount;
	}

	/**
	 * After successfull purchase we will add 10 points to the user points for every
	 * 1000rs.
	 * 
	 * @param currentUser     The user who is logged in.
	 * @param effectiveAmount The effective amount to paid by the user.
	 */
	public static void addPointsToUser(User currentUser, double effectiveAmount) {
		int pointsToAdd = (int) effectiveAmount / 1000;
		if (pointsToAdd > 0) {
			pointsToAdd = pointsToAdd * 10;
			currentUser.addPoints(pointsToAdd);
			System.out.println("\nCongratulations " + pointsToAdd
					+ " points added to your account. You can use this points on your next visit...");
		}
	}

	/**
	 * It will deduct the effective by using the user points.
	 * 
	 * @param currentUser     the user who is currently logged in.
	 * @param effectiveAmount The effective amount to be paid by the user.
	 * 
	 * @return effectiveAmount to be paid by the user after deducting the points.
	 */
	private static double usePointsToDeductAmount(User currentUser, double effectiveAmount) {
		double userPoints = currentUser.getPoints();
		if (userPoints >= effectiveAmount) {
			userPoints = userPoints - effectiveAmount;
			currentUser.setPoints((int) userPoints);
			return 0.0;
		} else {
			effectiveAmount = effectiveAmount - userPoints;
			currentUser.setPoints(0);
			return effectiveAmount;
		}
	}

	/**
	 * Used to calculate the discount amount.
	 * 
	 * @param totalAmount The sum of selecetd fruits price.
	 * 
	 * @return effectiveAmount after deducting the discount.
	 */
	private static double calculateDiscount(double totalAmount) {
		double res = 0.0;

		if (totalAmount >= 3000)
			res = (totalAmount * 5) / 100.0;
		else if (totalAmount >= 2000)
			res = (totalAmount * 4) / 100.0;
		else if (totalAmount >= 1000)
			res = (totalAmount * 2) / 100.0;

		return res;
	}

}
