package maxdifferencebetweenprimestest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import maxdifferencebetweenprimes.PrimeNumberUtil;

class PrimeNumberUtilTest {
	

	@Test
	void testIsPrime1() {
		assertEquals(true, PrimeNumberUtil.isPrime(2),"2 is a prime number");
	}
	
	@Test
	void testIsPrime2() {
		assertEquals(false, PrimeNumberUtil.isPrime(1),"1 is neither prime nor composite");
	}
	
	@Test
	void testIsPrimeForFalseCondition() {
		assertEquals(false, PrimeNumberUtil.isPrime(-2),"All negative numbers are composite");
	}
	
	@Test
	void testMaxDifferenceBetweenPrimes1() {
		assertEquals(5,PrimeNumberUtil.maxDifferenceBetweenPrimes(10, 2),"difference between 2 and 7");
	}
	
	@Test
	void testMaxDifferenceBetweenPimes2() {
		assertEquals(0,PrimeNumberUtil.maxDifferenceBetweenPrimes(5, 5)," differenece between 5 and 5");
	}
	
	@Test
	void testMaxDifferenceBetweenPrimes3() {
		assertEquals(11,PrimeNumberUtil.maxDifferenceBetweenPrimes(15,-5),"difference between 13 and 2");
	}
	
	@Test
	void testMaxDifferenceBetweenPimes4() {
		assertEquals(0,PrimeNumberUtil.maxDifferenceBetweenPrimes(4, 6),"No prime numbers exist" );
	}
	
	@Test
	void testMaxDifferenceBetweenPimes5() {
		assertEquals(-1,PrimeNumberUtil.maxDifferenceBetweenPrimes(20,22),"No prime numbers exist" );
	}
	
	@Test
	void testMaxDifferenceBetweenPimes6() {
		assertEquals(-1,PrimeNumberUtil.maxDifferenceBetweenPrimes(-2,-4),"No prime numbers exist" );
	}
	
	

}
