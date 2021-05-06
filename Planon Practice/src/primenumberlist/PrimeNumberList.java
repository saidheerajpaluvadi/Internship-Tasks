package primenumberlist;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.UnaryOperator;

/**
 * {@code PrimeNumberList} class will uses the features of ArrayList. It will
 * stores prime numbers.
 * 
 * @author Dheeraj
 *
 */
public class PrimeNumberList extends ArrayList<Integer> {

	private static final long serialVersionUID = 1L;

	/**
	 * Default constructer calls the ArrayList();
	 */
	public PrimeNumberList() {
		super();
	}

	/**
	 * Passes the intial capacity to ArrayList contructer.
	 * 
	 * @param size intial capacity of the {@code PrimeNumberList}
	 */
	public PrimeNumberList(int size) {
		super(size);
	}

	/**
	 * Adds the collection of integers to {@code PrimeNumberList} by passing
	 * collection to ArrayList constructer.
	 * 
	 * @param collection collection of integers
	 */
	public PrimeNumberList(Collection<Integer> collection) {
		addAll(size(), collection);
	}

	/**
	 * Adds element to the list only if it is prime
	 * 
	 * @throws UnsupportedOperationException if the element is not a prime number.
	 */
	@Override
	public boolean add(Integer element) {
		if (isPrime(element))
			return super.add(element);
		else
			throw new UnsupportedOperationException("Cannot add the given element, "+element+" is a composite number");
	}

	/**
	 * adds the element at given index if the element is a prime number.
	 * 
	 * @throws UnsupportedOperationException if the element is not a prime number.
	 */
	@Override
	public void add(int index, Integer element) {
		if (isPrime(element))
			super.add(index, element);
		else
			throw new UnsupportedOperationException("Cannot add the given element, "+element+" is a composite number");
	}

	/**
	 * Adds the collection to the {@code PrimeNumberList} at a specified index, if
	 * all the elements in the collection are prime numbers.
	 * 
	 * @throws UnsupportedOperationException if the element in the collection is not
	 *                                       a prime number.
	 */
	@Override
	public boolean addAll(int index, Collection<? extends Integer> collection) {
		for (Integer element : collection) {
			if (!isPrime(element))
				throw new UnsupportedOperationException("Cannot add the collection, "+element+" is a composite number");
		}
		return super.addAll(index, collection);
	}

	/**
	 * Adds the collection to the {@code PrimeNumberList} at the end, if all the
	 * elements in the collection are prime numbers.
	 * 
	 * @throws UnsupportedOperationException if the element in the collection is not
	 *                                       a prime number.
	 */
	@Override
	public boolean addAll(Collection<? extends Integer> collection) {
		/*
		 * for (Integer element : collection) { if (!isPrime(element)) throw new
		 * UnsupportedOperationException("Cannot add given collection"); } return
		 * super.addAll(collection);
		 */
		return addAll(size(), collection);

	}

	/**
	 * replace the element at given index if the element is a prime number.
	 * 
	 * @throws UnsupportedOperationException if the element is not a prime number.
	 */
	@Override
	public Integer set(int index, Integer element) {
		if (isPrime(element))
			return super.set(index, element);
		else
			throw new UnsupportedOperationException("Cannot set the given element, "+element+" is a composite number");
	}

	/**
	 * Replacing the elements with certain operation is not allowed because we can
	 * have only prime number in the {@code PrimeNumberList}
	 * 
	 * @throws UnsupportedOperationException if the element is replaced by
	 *                                       performing any operation.
	 */
	@Override
	public void replaceAll(UnaryOperator<Integer> operator) {
		throw new UnsupportedOperationException("Cannot replace the elements");
	}

	/**
	 * isPrime: checks wether given input is prime number or not.
	 * 
	 * @param element number to check
	 * 
	 * @return boolean value indicates whether given number is prime or not
	 */
	public boolean isPrime(Integer element) {
		if (element <= 1) {
			return false;
		}

		for (int num = 2; num <= Math.sqrt(element); num++) {
			if (element % num == 0) {
				return false;
			}
		}

		return true;
	}

}
