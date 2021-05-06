package maxdifferencebetweenprimes;

import java.util.ArrayList;
import java.util.List;

/**
 * PrimeNumbersGenerator class is used to generate the list of prime numbers in
 * the given range
 * 
 * @author Dheeraj
 *
 */
public class PrimeNumberUtil {
	


	/**
	 * maxDifferenceBetweenPrimes: calculate the max difeerenece between prime numbers in the given range.
	 * 
	 * @param leftBoundary  indicates the start of a range
	 * @param rightBoundary indicates the end of a range
	 * 
	 * @return max difference between prime numbers in the given range
	 */
	public static int maxDifferenceBetweenPrimes(int leftBoundary, int rightBoundary) {
		if(leftBoundary > rightBoundary) {
			int shiftBoundary = leftBoundary;
			leftBoundary = rightBoundary;
			rightBoundary = shiftBoundary;
		}
		List<Integer> primeNumbersList = new ArrayList<Integer>();
		for (int num = leftBoundary; num <= rightBoundary; num++) {
			if (isPrime(num)) {
				primeNumbersList.add(num);
			}
		}
 
		if (primeNumbersList .isEmpty()) {
			return -1;
		} else if (primeNumbersList.size() == 1)
			return 0;
		else
			return primeNumbersList.get(primeNumbersList.size() - 1) - primeNumbersList.get(0);
		
	}

	/**
	 * isPrime: checks wether given input is prime number or not.
	 * 
	 * @param inputNum number to check
	 * 
	 * @return boolean value indicates whether given number is prime or not
	 */
	public static boolean isPrime(int inputNum) {
		if (inputNum <= 1) {
			return false;
		}

		int noOfFactors = 1;
		
		for (int num = 2; num <= Math.sqrt(inputNum); num++) {
			if (inputNum % num == 0) {
				noOfFactors++;
				break;
			}
		}

		return noOfFactors == 1 ? true : false;
	}

}
