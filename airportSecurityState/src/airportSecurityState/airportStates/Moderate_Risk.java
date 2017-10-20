package airportSecurityState.airportStates;
import airportSecurityState.airport.Airport;
import airportSecurityState.airportStates.StateHelper;
import airportSecurityState.util.Results;
import airportSecurityState.util.MyLogger;


/*Moderate_Risk State*/
public class Moderate_Risk implements AirportStateI{
	/*Airport reference*/
	Airport airport;
	
	/*Results*/
	Results result;

	/*State Helper reference*/
	StateHelper helper;

	public void set_Result(Results res){result = res;}
	
	/*Constructor */
	public Moderate_Risk(Airport newAirport){
		MyLogger.writeMessage("Moderate_Risk(Airport)", MyLogger.DebugLevel.CONSTRUCTOR);	
		airport = newAirport;
		helper = new StateHelper(newAirport);
	}

	/*PARSE A NEW PASSENGER */  
	@Override
	public void newPassenger(String passenger){
		helper.newPassenger( passenger);
	}
		
	@Override
	public void write_operation(){
		result.insert("Operations: 2 3 5 8 9");
	}


	/* toString override just return "Moderate_Risk" */
	@Override
	public String toString(){return "Moderate_Risk";}
}

