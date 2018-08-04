package edu.neu.coe.info6205.sort.simple;

import static edu.neu.coe.info6205.sort.simple.Helper.less;
import static edu.neu.coe.info6205.sort.simple.Helper.swap;

public class InsertionSort<X extends Comparable<X>> implements Sort<X> {
    @Override
    public void sort(X[] xs, int from, int to) {
        // TODO implement selection sort
    	for(int i=from;i<to;i++)
    	{	
    		
    		for(int j=i;j>from;j--)
    		{
    			if(less(xs[j],xs[j-1]))
    			{
    				
    				swap(xs, j, j-1);
    			}
    			else 
    				break;
    		}
    	}    	
    	
    }
}



