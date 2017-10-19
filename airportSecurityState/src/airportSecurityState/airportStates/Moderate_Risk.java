package airportSecurityState.airportStates;
import airportSecurityState.airport.Airport;
import airportSecurityState.airportStates.StateHelper;


public class Moderate_Risk implements AirportStateI{
	Airport airport;
	StateHelper helper;

	/*Constructor */
	public Moderate_Risk(Airport newAirport){
		airport = newAirport;
		helper = new StateHelper(newAirport);
	}

	/*PARSE A NEW PASSENGER */  // could use a helper object? 
	@Override
	public void newPassenger(String passenger){
		helper.newPassenger( passenger);
	}
	
		
	/* toString override just return "Moderate_Risk" */
	@Override
	public String toString(){return "Moderate_Risk";}


}

