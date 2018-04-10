package HealthFreak;
import java.io.File;

import HealthFreak.City;
import HealthFreak.Heapsort;
import HealthFreak.QuickSort;

/**
 * Search class used to search cities by name (Binary Search implementation)
 */
public class Search {
	/**
	 * Method used to search city by name
	 * @param cities - array of cities to search
	 * @param name - name of city to search
	 */
	public static City search (City[] cities, String name){
		synchronized(cities){
			QuickSort.sort(cities);
			int index = binarySearch(cities, 0, cities.length-1, name);
			if (index == -1){
				return null;
			}
			return cities[index];
		}
		
	}
	/**
	 * Method used to conduct binary search
	 * @param arr - array of cities to sort
	 * @param l - left index
	 * @param r - right index
	 * @param x - city name to search
	 */
	private static int binarySearch(City arr[], int l, int r, String x)
    {
        if (r>=l)
        {
            int mid = l + (r - l)/2;
 
            // If the element is present at the 
            // middle itself
            if (arr[mid].getCity().equals(x)){
               return mid;
            }
 
            // If element is smaller than mid, then 
            // it can only be present in left subarray
            if (less(arr[mid],x)){
            	return binarySearch(arr, mid+1, r, x);
            }
               
 
            // Else the element can only be present
            // in right subarray
            return binarySearch(arr, l, mid-1, x);
        }
 
        // We reach here when element is not present
        //  in array
        return -1;
    }
	/**
	 * Method used to determine priority city
	 * @param y - first city object
	 * @param z - second city object
	 */
	private static boolean less( City y, String z) {
		
		int lengtha = (y.getCity()).length();
		int lengthb = (z.length());
		int max = max(lengtha, lengthb);

		for (int a = 0; a < max; a++)
		{
			int b = (int) (y.getCity()).charAt(a);
			int c = (int) (z.charAt(a));
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
}
