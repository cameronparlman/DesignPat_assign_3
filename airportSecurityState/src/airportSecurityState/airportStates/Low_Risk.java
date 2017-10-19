package airportSecurityState.airportStates;
import airportSecurityState.airport.Airport;
import airportSecurityState.airportStates.StateHelper;


public class Low_Risk implements AirportStateI{
	Airport airport;
	StateHelper helper;

	/*Constructor */
	public Low_Risk(Airport newAirport){
		airport = newAirport;
		helper = new StateHelper(newAirport);
	}

	/*PARSE A NEW PASSENGER */  // could use a helper object? 
	@Override
	public void newPassenger(String passenger){
		helper.newPassenger( passenger);
	}
	
		
	/* toString override just return "low_risk" */
	@Override
	public String toString(){return "low_risk";}


}

