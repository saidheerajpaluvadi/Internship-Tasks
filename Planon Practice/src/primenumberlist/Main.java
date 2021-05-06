package primenumberlist;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		ArrayList<Integer> arrli = new ArrayList<Integer>();
		arrli.add(2);
		arrli.add(5);
		arrli.add(7);
		arrli.add(11);
		//arrli.add(12);
		
	   
		PrimeNumberList primeList = new PrimeNumberList(arrli);
		System.out.println(primeList.add(2));
		System.out.println(primeList.add(3));
		System.out.println(primeList.add(5));
		System.out.println(primeList);
		System.out.println(primeList.get(0));
		System.out.println("Index of 2 = "+primeList.indexOf(2));
		System.out.println("Last Index of 2 =  "+primeList.lastIndexOf(2));
		System.out.println("Size:"+primeList.size());
		
		//Add at an index
		primeList.add(1, 19);
		System.out.println(primeList);
		
		System.out.println("Add All at index "+primeList.addAll(3, arrli));
		System.out.println(primeList);
		
		System.out.println("Add all "+primeList.addAll(arrli));
		System.out.println(primeList);
		
		//Set at an index
		System.out.println("Old element = "+primeList.set(2, 37));
		System.out.println(primeList);
		
	}

}
