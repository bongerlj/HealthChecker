package HealthFreak;

import HealthFreak.City;

public class SortCond {

	
	private int partition(City[] x, int low, int high, int a)
    {
		City pivot = x[high]; 
        int i = (low-1); // index of smaller element
        for (int j=low; j<high; j++)
        {
            // If current element is smaller than or
            // equal to pivot
            if (x[j].getCond(a) <= pivot.getCond(a))
            {
                i++;
 
                // swap cond[i] and cond[j]
                City temp = x[i];
                x[i] = x[j];
                x[j] = temp;
            }
        }
 
        // swap cond[i+1] and cond[high] (or pivot)
        City temp = x[i+1];
        x[i+1] = x[high];
        x[high] = temp;
 
        return i+1;
    }
 
 
    /* The main function that implements QuickSort()
      cond[] --> Array to be sorted,
      low  --> Starting index,
      high  --> Ending index */
    public void sort(City[] x, int low, int high, int a)
    {
    		
        if (low < high)
        {
            /* pi is partitioning index, cond[pi] is 
              now at right place */
            int pi = partition(x, low, high, a);
 
            // Recursively sort elements before
            // partition and after partition
            sort(x, low, pi - 1, a);
            sort(x, pi + 1, high, a);
        }
    }
    
    public void quicksort(City[] x, int a)
	{
		int low = 0, high = x.length;
		sort(x, low, high, a);
	}
}
