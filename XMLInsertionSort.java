// Justin Chan
// XMLInsertionSort.java
// July 10th, 2015
// This class will sort an ArrayList of XML nodes lexicographically
// according to a user-input element that will serve as a way to 
// organise the data.

import java.util.ArrayList;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLInsertionSort extends InsertionSort<Node>
{
	String ELEMENT_STANDARD;	// This is the element which will serve as a standard for organizing the nodes.
	
	public XMLInsertionSort (ArrayList<Node> nlist, String element)
	{
		super(nlist);
		ELEMENT_STANDARD = element;
	}
	
	// This compareTwo routine compares the specified element text of 
	// each Node lexicographically. 
	public boolean compareTwo (Node a, Node b)
	{
		return getElementText(a).compareTo(getElementText(b)) > 0;
	}
	
	// Will return the text contained within the element specified by
	// the standard of a single Node.
	public String getElementText (Node n)
	{
		Element e = (Element) n;
		return e.getElementsByTagName(ELEMENT_STANDARD).item(0).getTextContent();
	}
}
