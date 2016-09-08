// Justin Chan
// July 10th, 2015
// InsertionSort.java
// This generic class will be used to sort an ArrayList of type T
// objects. The sort algorithm will stay the same, but the comparison
// method may be subject to change in subclasses.

import java.util.ArrayList;

public class InsertionSort <T>
{
	private ArrayList<T> alist;
	
	public InsertionSort (ArrayList<T> inlist)
	{
		alist = inlist;
	}
	
	// sort() is the routine that contains the actual insertion sort
	// logic/algorithm
	public ArrayList<T> sort()
	{
		T temp;
		
		// Sorting algorithm
		for (int i = 0; i < alist.size(); i++)
		{
			temp = alist.get(i);
			int j = i;
			while (j > 0 && compareTwo(alist.get(j-1), temp))
			{
				alist.set(j, alist.get(j-1));
				j--;
			}
			alist.set(j, temp);
		}
		
		return alist;
	}
	
	// compareTwo is a routine that compares two Objects.
	// It is intended that subclasses will use their own implementation.
	public boolean compareTwo(T a, T b)
	{
		return a.toString().compareTo(b.toString()) > 0;
	}
	
	// getList() is a routine that returns the current ArrayList that
	// is sorted or is yet to be sorted.
	public ArrayList<T> getList()
	{
		return alist;
	}
	
	// setList() is a routine that sets the current alist to the input
	// of the function.
	public void setList(ArrayList<T> inlist)
	{
		alist = inlist;
	}
}
