package HealthFreak;

public class Heapsort {
		
		/**
		 * Heap sort using Comparable
		 * @param x - input array
		 * @param n - size of input array
		 */
		private static int cond1;
		public static void sortHeap (City [] x, int n, int cond) {
			cond1 = cond;
			for (int i = n / 2; i >= 1; i--)
				sink(x, i, n);
			
			while (n > 1){
				swap(x, 1, n--);
				sink(x, 1, n);
			}
		}
		
		/**
		 * Helper function to ensure object maintains heap properties
		 * @param x - input array
		 * @param i - index
		 * @param n - size of input array
		 */
	    private static void sink(City [] x, int i, int n) {
	    	
	        while (2 * i <= n) {
	            int j = 2 * i;
	            
	            if (j < n && (x[j-1].getCond(cond1)<x[j].getCond(cond1))) 
	            	j++;
	            
	            if (x[i-1].getCond(cond1)>=(x[j-1].getCond(cond1))) 
	            	break;
	            
	            swap(x, i, j);
	            i = j;
	        }
	    }
	    
		/**
		 * Helper function for swapping 2 elements
		 * @param obj - array of objects
		 * @param index1 - index of first element
		 * @param index2 - index of second element
		 */
		private static void swap(City [] x, int index1, int index2) {
			
			City temp = x[index1-1];
			x[index1-1] = x[index2-1];
			x[index2-1] = temp;
		}
	}