package airportSecurityState.airportStates;
import airportSecurityState.airport.Airport;
import airportSecurityState.airportStates.StateHelper;
import airportSecurityState.util.Results;
import airportSecurityState.util.MyLogger;


/*High_Risk State*/
public class High_Risk implements AirportStateI{
	/*Airport reference*/
	Airport airport;

	Results result;

	/*State Helper reference*/
	StateHelper helper;

	public void set_Result(Results res){result = res;}

	/*Constructor */
	public High_Risk(Airport newAirport){
		MyLogger.writeMessage("High_Risk(Airport)", MyLogger.DebugLevel.CONSTRUCTOR);	
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
		result.insert("Operations: 2 4 6 8 10");
	}
		
	/* toString override just return "high_risk" */
	@Override
	public String toString(){return "high_risk";}


}

