package airportSecurityState.airportStates;
import airportSecurityState.airport.Airport;
import airportSecurityState.airportStates.StateHelper;
import airportSecurityState.util.Results;
import airportSecurityState.util.MyLogger;


/*Low_Risk State*/
public class Low_Risk implements AirportStateI{
	/*Airport reference*/
	Airport airport;

	Results result;

	/*State Helper reference*/
	StateHelper helper;
	
	public void set_Result(Results res){result = res;}

	/*Constructor */
	public Low_Risk(Airport newAirport){
		MyLogger.writeMessage("Low_Risk(Airport)", MyLogger.DebugLevel.CONSTRUCTOR);	
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
		result.insert("Operations: 1 3 5 7 9");
	}
		

		
	/* toString override just return "low_risk" */
	@Override
	public String toString(){return "low_risk";}


}

