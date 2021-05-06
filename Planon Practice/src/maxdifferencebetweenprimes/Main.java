package maxdifferencebetweenprimes;

import java.util.Scanner;

/**
 * Main class will take the inputs and produces the output as difference between
 * the highest prime and lowest prime in the given range.
 * 
 * @author Dheeraj
 *
 */
public class Main {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int noOfTests = sc.nextInt();
			while (noOfTests > 0) {
				int leftBoundary = sc.nextInt();
				int rightBoundary = sc.nextInt();

				System.out.println(PrimeNumberUtil.maxDifferenceBetweenPrimes(leftBoundary, rightBoundary));

				

				noOfTests--;
			}
		}

	}
	
	

}
