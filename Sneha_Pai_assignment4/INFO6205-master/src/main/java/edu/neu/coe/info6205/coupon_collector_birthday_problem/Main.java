package edu.neu.coe.info6205.coupon_collector_birthday_problem;

import static edu.neu.coe.info6205.coupon_collector_birthday_problem.Helper.hash;

import java.lang.reflect.Array;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
		
		
		int coupon_count=0;
		Double count =0.0;
		int nodeCount=0;
		
		for(int slots=10000;slots<110000;slots+=10000) {
			count = (double) slots;
			int[] arr = new int[slots+1];
			
			Random r = new Random();
			int hashCountSum=0;

			for(int k=0;k<20;k++) {
			double randomValue=0.0;
			int index=0;
			int hashCount=0;
			
			while(arr[index]<2)
			{
				randomValue = 0.0 + (count - 0.0) * r.nextDouble();
				index = hash(slots, randomValue);			
				hashCount++;
				arr[index]++;
			}	
			hashCountSum+=hashCount;
			java.util.Arrays.fill(arr, 0);

			}
			System.out.println();
			System.out.println("slot count: "+slots);
			System.out.println("number of hashes when the fist collision occurred: "+hashCountSum/20 );
			System.out.println("expected number of hashes before the fist collision: "+ Math.sqrt(3.14*slots/2) );
			}
		
		
		
	

		for(coupon_count=10000;coupon_count<110000;coupon_count+=10000) {
		nodeCount=0;
		for(int k=0;k<10;k++)
		{
		SeparateChainingHT<Double, Integer> ht = new SeparateChainingHT<>(coupon_count);

		count = (double) coupon_count;
		Random r = new Random();
		
		
		int i=0;
		double randomValue=0.0;
		
		while(SeparateChainingHT.chainCount!=coupon_count)
		{
			randomValue = 0.0 + (count - 0.0) * r.nextDouble();

			ht.put(randomValue, i++);

		}	

		nodeCount+=SeparateChainingHT.nodeCount;
		SeparateChainingHT.nodeCount = 0;
		SeparateChainingHT.chainCount = 0;

		}
	
		System.out.println("coupon count: "+count);
		
		System.out.println("number of throws after when all bins/slots are filled: "+ nodeCount/10);
		
		double expThrows = count * Math.log(count);
	
		System.out.println("Expected throws before all the slots are filled: "+ expThrows);
		System.out.println();
		}
		

		
		

		


	}

}
