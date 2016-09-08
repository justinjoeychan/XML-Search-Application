// Justin Chan
// July 10th, 2015
// XMLSearchApp.java
// This console application uses different search and sort objects to
// organize XML files. This application will allow users to find 
// specified nodes (in this class it searches for "City" nodes).

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class XMLSearchApp
{
	public void runSearch()
	{	
		// Loads all Location nodes in "Coordinates.xml" in one ArrayList
		ArrayList<Node> newlist = loadXML();
		
		// Sorts the list of Location nodes lexicographically by city
		XMLInsertionSort sorter = new XMLInsertionSort(newlist, "City");
		sorter.sort();
		
		// Text that instructs user on particular inputs
		Scanner scanner = new Scanner(System.in);
		int searcher = 0;
		int oriindex;
		int desindex;
		
		do
		{
			if (searcher == -1)
				System.out.println("\n Sorry but that city does not exist in the list. Please try again");
			System.out.println("Input Origin City =>");
			String origin = scanner.nextLine();
			XMLBinarySearch bsearch = new XMLBinarySearch(newlist, origin, "City");
			searcher = bsearch.search();
		} while (searcher == -1);
		
		oriindex = searcher;
		searcher = 0;
		
		do
		{
			if (searcher == -1)
				System.out.println("\n Sorry but the city does not exist in the list. Please try again");
			System.out.println("\nInput Destination City =>");
			String destination = scanner.nextLine();
			XMLBinarySearch bsearch = new XMLBinarySearch(newlist, destination, "City");
			searcher = bsearch.search();
		} while (searcher == -1);
		
		desindex = searcher;
		
		LocationDistance ld = new LocationDistance(Double.parseDouble(((Element)newlist.get(oriindex)).getElementsByTagName("Latitude").item(0).getTextContent()),
													Double.parseDouble(((Element)newlist.get(oriindex)).getElementsByTagName("Longitude").item(0).getTextContent()),
													Double.parseDouble(((Element)newlist.get(desindex)).getElementsByTagName("Latitude").item(0).getTextContent()),
													Double.parseDouble(((Element)newlist.get(desindex)).getElementsByTagName("Longitude").item(0).getTextContent()));
		
		System.out.println("\n\n The distance between these two cities is " + ld.Haversine());
	}
	
	public ArrayList<Node> loadXML()
	{
		XMLReader reader = new XMLReader();
		Document doc = null;
		
		try
		{
			doc = reader.ReadXML(System.getProperty("user.dir") + File.separator + "Coordinates.xml");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		NodeList nlist = reader.GetNodes(doc, "Location");
		ArrayList<Node> alist = new ArrayList<Node>();
		
		for (int i = 0; i < nlist.getLength(); i++)
		{
			Node n = nlist.item(i);
			alist.add(n);
		}
		
		return alist;
	}
	
	public static void main (String[] args)
	{
		XMLSearchApp app = new XMLSearchApp();
		app.runSearch();
	}
}
