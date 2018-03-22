package sortPack;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class QuickSort {

	public static void sort(City[] a) {
		shuffleArray(a); // Eliminate dependence on input.    // https://introcs.cs.princeton.edu/java/stdlib/ for standard libraries
		sort(a, 0, a.length - 1);
	}
	
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
	
	private static void sort(City[] a, int lo, int hi) { // See page 289 for public sort() that calls this method.
		if (hi <= lo)
			return;
		int lt = lo, i = lo + 1, gt = hi;
		City v = a[lo];
		while (i <= gt) {
			
			if (less (a[i], v))
				exch(a, lt++, i++);
			else if (!(less (a[i], v)))
				exch(a, i, gt--);
			else
				i++;
		} // Now a[lo..lt-1] < v = a[lt..gt] < a[gt+1..hi].
		sort(a, lo, lt - 1);
		sort(a, gt + 1, hi);
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
    
	private static void exch(City[] x, int i, int j)
	{
		City temp = x[i];
		x[i] = x[j];
		x[j] = temp;
	}
}
