package HealthFreak;

public class Heapsort2 {
	
	/**
	 * Heap sort using Comparable
	 * @param x - input array
	 * @param n - size of input array
	 */
	public static void sortHeap (String [] y, int[] x, int n) {
		for (int i = n / 2; i >= 1; i--)
			sink(y, x, i, n);
		
		while (n > 1){
			swap(y, x, 1, n--);
			sink(y, x, 1, n);
		}
	}
	
	/**
	 * Helper function to ensure object maintains heap properties
	 * @param x - input array
	 * @param i - index
	 * @param n - size of input array
	 */
    private static void sink(String y[], int [] x, int i, int n) {
    	
        while (2 * i <= n) {
            int j = 2 * i;
            
            if (j < n && (x[j-1]<x[j]))
            	j++;
            
            if (x[i-1]>=(x[j-1])) 
            	break;
            
            swap (y, x, i, j);
            i = j;
        }
    }
    
	/**
	 * Helper function for swapping 2 elements
	 * @param obj - array of objects
	 * @param index1 - index of first element
	 * @param index2 - index of second element
	 */
	private static void swap(String[]  y, int [] x, int index1, int index2) {
		
		int temp = x[index1-1];
		x[index1-1] = x[index2-1];
		x[index2-1] = temp;
		
		String t = y[index1-1];
		y[index1-1] = y[index2-1];
		y[index2-1] = t;
	}

}
