package HealthFreak;

import HealthFreak.City;

public class Heapsort {

	/**
	 * Heap sort using Comparable
	 * @param x - input array
	 * @param n - size of input array
	 */
	public static void sortHeap (City[] x) {
		
		int n = x.length;
		for (int i = n / 2; i >= 1; i--)
			sink( x, i, n);
		
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
	private static void sink(City[] x, int i, int n) {

		while (2 * i <= n) {
			int j = 2 * i;

			
			if (j < n && less(x[j-1], x[j]))
				j++;

			if (!less(x[j-1], x[j]))
				break;

			swap(x, i, j);
			i = j;
		}
	}
	
	private static boolean less( City y, City z) {
			
		int lengtha = (y.getCity()).length();
		int lengthb = (z.getCity()).length();
		int max = max(lengtha, lengthb);

		for (int a = 0; a < max; a++)
		{
			int b = (int) (y.getCity()).charAt(a);
			int c = (int) (z.getCity()).charAt(a);
			if (b < c)
			{
				return true;
			}
			if (b >= c)
			{
				return false;
			}
		}
		return false;
	}
	
	private static int max(int lengtha, int lengthb) {
		if (lengtha - lengthb < 0)
			return lengthb;
		else if (lengtha - lengthb > 0)
			return lengtha;
		else 
			return lengthb;
	}
    
	/**
	 * Helper function for swapping 2 elements
	 * @param obj - array of objects
	 * @param index1 - index of first element
	 * @param index2 - index of second element
	 */
	private static void swap(Object[] obj, int index1, int index2) {
		
		Object temp = obj[index1-1];
		obj[index1-1] = obj[index2-1];
		obj[index2-1] = temp;
	}
	
	
}
