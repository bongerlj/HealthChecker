package HealthFreak;
import java.io.File;

import HealthFreak.City;
import HealthFreak.Heapsort;
import HealthFreak.QuickSort;

public class Search {
	
	
	public static City search (City[] cities, String name){
		QuickSort.sort(cities);
		int index = binarySearch(cities, 0, cities.length-1, name);
		if (index == -1){
			return null;
		}
		return cities[index];
	}
	
	private static int binarySearch(City arr[], int l, int r, String x)
    {
        if (r>=l)
        {
            int mid = l + (r - l)/2;
 
            // If the element is present at the 
            // middle itself
            if (arr[mid].getCity() == x){
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
	private static int max(int lengtha, int lengthb) {
		if (lengtha - lengthb < 0)
			return lengthb;
		else if (lengtha - lengthb > 0)
			return lengtha;
		else 
			return lengthb;
	}
	
	
	public static void main(String[]args) {
		City[] cities = {new City("New York", 32250), new City("London", 3120),new City("Toronto", 32250),new City("Hamilton", 1250), new City("Chicago", 3250)};

		System.out.println(search(cities, "New York").getCity());
	}

}
