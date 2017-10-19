package airportSecurityState.airportStates;

import airportSecurityState.airport.Airport;

public interface AirportStateI{

	/*parse a new passenger*/
	public void newPassenger(String passenger);

	/*handle passenger unused */
	public static void handlePassenger(Airport airport, String passenger){}

	/* can use a static method to calculate averages probably can do lambda */
	public static int avg(int x, int y){ 
		return x/y;
	}

	public void assess_risk();

}
