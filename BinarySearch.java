// Justin Chan
// July 10th, 2015
// BinarySearch.java
// This class is generic in that it will take an ArrayList of Type T
// and search it using the Binary Search algorithm.

import java.util.ArrayList;

public class BinarySearch<T, E>
{
	ArrayList<T> alist;	// a sorted list that will be searched
	E key;				// the target Object that will be found.
	
	public BinarySearch (ArrayList<T> inlist, E inkey)
	{
		alist = inlist;
		key = inkey;
	}
	
	// search() is a routine that returns the index the Object key was
	// found in the ArrayList.
	public int search()
	{
		int lo = 0;
		int hi = alist.size() - 1;
		while (lo <= hi)
		{
			int mid = lo + (hi - lo) / 2;
			if (compareTwo(key, alist.get(mid)) < 0)
				hi = mid - 1;
			else if (compareTwo(key, alist.get(mid)) > 0)
				lo = mid + 1;
			else 
				return mid;
		}
		return -1;
	}
	
	// compareTwo() is a routine that is meant to be overridden by 
	// child classes. The comparison method should depend on the Object
	// T.
	public int compareTwo(E target, T compare)
	{
		return 0;
	}
	
	// getter routine for the ArrayList
	public ArrayList<T> getList()
	{
		return alist;
	}
	
	// setter routine for the ArrayList
	public void setList(ArrayList<T> inlist)
	{
		alist = inlist;
	}
}
