// Justin Chan
// July 10th, 2015
// XMLBinarySearch.java
// This class extends BinarySearch to work for XML Nodes. This class
// depends on a sorter class that sorts XML Node text according to a 
// standard element. This class will search for a String that matches
// with a Node's subelement.

import java.util.ArrayList;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLBinarySearch extends BinarySearch<Node, String>
{
	String ELEMENT_STANDARD;
	
	public XMLBinarySearch(ArrayList<Node> nlist, String key, String element)
	{
		super(nlist, key);
		ELEMENT_STANDARD = element;
	}
	
	public int compareTwo (String target, Node compare)
	{
		return target.compareTo(getElementText(compare));
	}
	
	public String getElementText (Node n)
	{
		Element e = (Element) n;
		return e.getElementsByTagName(ELEMENT_STANDARD).item(0).getTextContent();
	}
}
