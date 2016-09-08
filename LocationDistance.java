// Justin Chan
// July 10th, 2015
// LocationDistance.java
// This class will contain logic that will return a value of distance
// that represents the distance between two input coordinates of 
// latitude and longitude. It utilizes the Haversine method.

import java.lang.Math;

public class LocationDistance
{
	final int EARTH_RADIUS = 3959;	
	double dlatitude1, dlongitude1, dlatitude2, dlongitude2;

	public LocationDistance(double dla1, double dlo1, double dla2, double dlo2)
	{
		dlatitude1 = dla1;
		dlongitude1 = dlo1;
		dlatitude2 = dla2;
		dlongitude2 = dlo2;
	}
	
	public double Haversine()
	{
		double dLatitude = Math.toRadians( dlatitude2-dlatitude1 );
		double dLongitude = Math.toRadians( dlongitude2-dlongitude1 );
		double nA = Math.pow ( Math.sin( dLatitude/2.0 ), 2.0 ) + Math.cos( Math.toRadians(dlatitude1) ) * Math.cos( Math.toRadians(dlatitude2) ) * Math.pow ( Math.sin( dLongitude/2.0), 2.0 );
		double nC = 2.0 * Math.atan2( Math.sqrt(nA), Math.sqrt( 1.0 - nA ));
		double distance = EARTH_RADIUS * nC;
		return distance; 
	}
	
	public static void main (String[] args)
	{
		LocationDistance ld = new LocationDistance(37.7833, 122.4167, 40.7127, 74.0059);
		System.out.println(ld.Haversine());
	}
}
