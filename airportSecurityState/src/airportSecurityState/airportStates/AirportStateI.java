package airportSecurityState.airportStates;

import airportSecurityState.airport.Airport;
import airportSecurityState.util.Results;

public interface AirportStateI{
	/*parse a new passenger*/
	public void newPassenger(String passenger);
	
	public void write_operation();	
	
	public void set_Result(Results res);
		
}
