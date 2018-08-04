package edu.neu.coe.info6205.sort.par;

import java.util.Arrays;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ForkJoinPool;

class ParSort {
	public static int counThread;
    public static int cutoff;
    

    
    public static void sort(int[] array, int from, int to) {
        int size = to - from + 1;
        int mid = from + (to - from)/2;
        if (size < cutoff|| counThread>20) 
        	{
        		System.out.println("cut-off: "+ (to-from+1));
        		Arrays.sort(array, from, to+1);
        	}
        else {
    
        	CompletableFuture<int[]> parsort1 = parsort(array, from, mid);
        	
        	
            CompletableFuture<int[]> parsort2 = parsort(array, mid+1, to);


            CompletableFuture<int[]> parsort = 
            		parsort1.thenCombine(parsort2, (xs1, xs2) -> {
                    	int[] result = new int[xs1.length + xs2.length];
                    	merge(array, result, from);
                        return result;
                    });

            parsort.whenComplete((result, throwable) -> {           	

            	
            	
            }); 
            parsort.join();
        }
    }
  public static void merge(int[] a, int[] aux, int lo){
    	
    	int auxMid = (aux.length-1)/2 ;
    	int auxHi = aux.length-1;
    	int i=0, j= auxMid +1;
    	
    	for(int k=0,l=lo;k<aux.length;k++)
    	{
    		aux[k] = a[l++];
    	}
    	
    	for(int k=lo; k<lo + aux.length; k++)
    	{
    		if(i>auxMid) a[k] = aux[j++];
    		else if(j>auxHi)  a[k] = aux[i++];
    		else if(aux[j] < aux[i]) a[k] = aux[j++];
    		else      a[k] = aux[i++];
    	}
    	
    }

    private static CompletableFuture<int[]> parsort(int[] array, int from, int to) {
        return CompletableFuture.supplyAsync(
                () -> {

                	counThread++;
                    int[] result = new int[to - from + 1];
                    if(to>from)
    					sort(array, from, to);
                    return result;
                } 
        );
    }
    
  
    
    
}
