package airportSecurityState.airportStates;
import airportSecurityState.airport.Airport;
import airportSecurityState.util.Results;

public class StateHelper{
	/*Reference to the airport*/
	Airport airport;	
			
	/*StateHelper Constructor assigns reference to helper*/
	public StateHelper(Airport airport_in){
		airport = airport_in;
	}

	/*checkItem(item) :check if item is prohibited at the airport
		if prohibited  incrememnt number of observed "bad" items 
			and update the averages of airport	
	*/
	public void checkItem(String item_in){
		if(airport.get_prohibited_items().contains(item_in.toLowerCase())){
			airport.increment_total_prohibited();
			airport.update_averages();
		}	
	}

	
	/*PASSENGER PARSER*/
	/*Passenger parser also does some modifications based on info*/
	public void newPassenger(String passenger){
		String delims = "[:;]+";
		String[] tokens = passenger.split(delims);
		int day=0;
		String item = "";

		try{ //parse the day of the traveller 
			day = Integer.parseInt(tokens[1]);
			item = tokens[8];
		}
		catch(NumberFormatException exception){//!Int to int exception
			System.err.print("Number Format Exception, " + exception.getMessage());
			exception.printStackTrace();	
			System.exit(1);
		}
		
		//check if a new day 
		if(day != airport.getDay()){
			airport.newDay(day);
		}
		//incrememnt traffic 
		airport.increment_traffic();
		//check if item is prohibited 
		checkItem(item);
		//tighten or loosen security 
		tightenOrLoosenSecurity();
	}	

	
	/*tightenOrLoosenSecurity():    AKA Assess_Risk() funciton */
	public void tightenOrLoosenSecurity(){
		int avg_traffic = airport.get_avg_traffic();
		int avg_prohibited_items = airport.get_avg_prohibited_items();
	
		//check if high_risk
		if(avg_traffic >= 8 || avg_prohibited_items >= 2){
			if(!(airport.getState() instanceof High_Risk))
				airport.setAirportState(airport.getHighState());
		}		
		//check if moderate_risk;
		else if(avg_traffic >= 4 || avg_prohibited_items >=1){
			if(!(airport.getState() instanceof Moderate_Risk))
				airport.setAirportState(airport.getModerateState());
		}
		//otherwise low_risk
		else{
			if(! (airport.getState() instanceof Low_Risk))
				airport.setAirportState(airport.getLowState());
		}
		insertResult();
	}

	public void insertResult(){
		airport.getState().write_operation();
	}
	

}
