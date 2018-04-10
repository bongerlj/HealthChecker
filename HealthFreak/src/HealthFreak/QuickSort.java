package HealthFreak;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 * HeapSort class used to sort cities based on names
 */
public class QuickSort {
	/**
	 * Method used to sort ciites
	 * @param a - array of cities to sort
	 */
	public static void sort(City[] a) {
		shuffleArray(a); // Eliminate dependence on input.    // https://introcs.cs.princeton.edu/java/stdlib/ for standard libraries
		sort(a, 0, a.length - 1);
	}
	/**
	 * Method used shuffle array
	 * @param ar - array of cities to shuiffle
	 */
	static void shuffleArray(City[] ar)
	  {
	    // If running on Java 6 or older, use `new Random()` on RHS here
	    Random rnd = ThreadLocalRandom.current();
	    for (int i = ar.length - 1; i > 0; i--)
	    {
	      int index = rnd.nextInt(i + 1);
	      // Simple swap
	      City a = ar[index];
	      ar[index] = ar[i];
	      ar[i] = a;
	    }
	  }
	/**
	 * Method used to partiition cities array
	 * @param a - array of cities to sort
	 * @param lo - left index
	 * @param hi - right index
	 */
	private static int partition(City[] a, int lo, int hi){
		int i = lo;
		int j = hi +1;
		City v = a[lo];
		while(true){
			while(less (a[++i], v)){
				if (i == hi){
					break;
				}
			}
			while(less(v, a[--j])){
				if (j == lo){
					break;
				}
			}
			if (i>=j){
				break;
			}
			exch(a, i, j);
		}
		exch(a, lo, j);
		return j;
	}
	/**
	 * Method used to sort cities array
	 * @param a - array of cities to sort
	 * @param lo - left index
	 * @param hi - right index
	 */
	private static void sort(City[] a, int lo, int hi) { // See page 289 for public sort() that calls this method.
		if (hi <= lo)
			return;
		int j = partition(a, lo, hi);
		sort(a, lo, j - 1);
		sort(a, j + 1, hi);
	}
	/**
	 * Method used to determine priority city
	 * @param y - first city object
	 * @param z - second city object
	 */
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
	/**
	 * Method used to determine bigger length
	 * @param lengtha - first length
	 * @param lengthb - second length
	 */
	private static int max(int lengtha, int lengthb) {
		if (lengtha - lengthb < 0)
			return lengthb;
		else if (lengtha - lengthb > 0)
			return lengtha;
		else 
			return lengthb;
	}
	/**
	 * Method swap in place
	 * @param x cities array
	 * @param i - index of first city
	 * @param j - index of second city
	 */
	private static void exch(City[] x, int i, int j)
	{
		City temp = x[i];
		x[i] = x[j];
		x[j] = temp;
	}
}
