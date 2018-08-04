package edu.neu.coe.info6205.sort.par;

import java.util.Random;

import javax.swing.text.html.MinimalHTMLWriter;

public class Main {

    public static void main(String[] args) {
  
        	    	ParSort.cutoff=2500000;
    	
    	
    	Random random = new Random(0L);
                

    	int[] array = new int[20000000];
        for (int i = 0; i < array.length; i++) array[i] = random.nextInt(20000000);

        double start = System.currentTimeMillis();
        
        ParSort.sort(array, 0, array.length-1);
        
        double end = System.currentTimeMillis();
               
//        for (int i : array) System.out.println(i);
        
        System.out.println("sorting time: "+ (end-start)+ " cut-off: "+ ParSort.cutoff+ "  Thread count: "+ ParSort.counThread);

        
        
    }
}
