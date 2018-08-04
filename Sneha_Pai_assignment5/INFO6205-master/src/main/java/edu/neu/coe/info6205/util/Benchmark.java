/*
 * Copyright (c) 2018. Phasmid Software
 */

package edu.neu.coe.info6205.util;

import edu.neu.coe.info6205.sort.simple.InsertionSort;
import edu.neu.coe.info6205.sort.simple.SelectionSort;
import edu.neu.coe.info6205.sort.simple.Sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.function.Function;

public class Benchmark<T> {

    public Benchmark(Function<T, Void> f) {
        this.f = f;
    }

    public double run(T t, int n) {
    	
    	
    	
    	for(int i=0;i<1000;i++)
    	{
    		f.apply(t);
    	}
    	
    	double start = System.currentTimeMillis();
    	for(int i=0;i<n;i++)
    	{
    		f.apply(t);
    	}
    	double end = 	System.currentTimeMillis();
    	
    	start = (end-start)/n;
//    	System.out.println(start);
        return start;  
    }

    private final Function<T, Void> f;

    static Integer[] arr2 = new Integer[3200];
    
    public static void main(String[] args) {
        int m = 100; // This is the number of repetitions: sufficient to give a good mean value of timing
        Integer[] array = new Integer[3200];
        
//        Random rand = new Random();
//        
//        for (int i = 0; i < 3200; i++) {
//            array[i] = rand.nextInt(3200) + 1;//Random ordered array
//        }
        
        
        for (int i = 0; i < 3200; i++) array[i] = i;
        
        int n = 2000;
        
        System.out.println("\nThe following is the result of sorting the completely sorted array:");
        for(n=200; n<=3200;n=2*n)
        {
        	benchmarkSort(array, n, "SelectionSort", new SelectionSort<>(), m);
        	benchmarkSort(array, n, "InsertionSort", new InsertionSort<>(), m);
        }
        
        //populate the array with real random data
        Collections.shuffle(Arrays.asList(array));
        
        
        System.out.println("\nThe following is the result of sorting the random array:");
        for(n=200; n<=3200;n=2*n)
        {
        	benchmarkSort(array, n, "SelectionSort", new SelectionSort<>(), m);
        	benchmarkSort(array, n, "InsertionSort", new InsertionSort<>(), m);
        }
        
        
        for (int i = 0; i < 1600; i++) array[i] = i;
        System.out.println("\nThe following is the result of sorting the partially sorted array:");
        for(n=200; n<=3200;n=2*n)
        {
        	benchmarkSort(array, n, "SelectionSort", new SelectionSort<>(), m);
        	benchmarkSort(array, n, "InsertionSort", new InsertionSort<>(), m);
        }
        
        for (int i = 0; i < 3200; i++) array[i] = array.length-i;
        System.out.println("\nThe following is the result of sorting the reverse sorted array:");
        for(n=200; n<=3200;n=2*n)
        {
        	benchmarkSort(array, n, "SelectionSort", new SelectionSort<>(), m);
        	benchmarkSort(array, n, "InsertionSort", new InsertionSort<>(), m);
        }        

        
    }

    private static void benchmarkSort(Integer[] xs, Integer n, String name, Sort<Integer> sorter, int m) {
        Function<Integer, Void> sortFunction = (x) -> {
//        	Collections.shuffle(Arrays.asList(xs));
        	arr2 = Arrays.copyOf(xs, arr2.length);
            sorter.sort(arr2, 0, x);
            return null;
        };
        Benchmark<Integer> bm = new Benchmark<>(sortFunction);
        double x = bm.run(n, m);
        System.out.println(name + ": " + x + " millisecs for n=" + n);
    }
}
