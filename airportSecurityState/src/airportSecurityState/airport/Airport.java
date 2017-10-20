package airportSecurityState.airport;

import airportSecurityState.util.Results;
import airportSecurityState.util.MyLogger;
import airportSecurityState.airportStates.AirportStateI;
import airportSecurityState.airportStates.Low_Risk;
import airportSecurityState.airportStates.Moderate_Risk;
import airportSecurityState.airportStates.High_Risk;
import java.util.ArrayList;
import java.util.Arrays;


/*
Airport class, is context of the state pattern, 
	
*/
public class Airport{
	Results result;
	/* CURRENT STATE OF THE AIRPORT */
	AirportStateI airportState;	

	/* STATES OF THE AIRPORT */
	AirportStateI low_risk;	
	AirportStateI moderate_risk;
	AirportStateI high_risk;

	/*LIST OF PROHIBITED ITEMS */
	ArrayList<String> prohibited_items = new ArrayList(Arrays.asList("gun", "nailcutter", "blade", "knife"));

	/*AIRPORT FIELDS*/
	int day;
	int total_days;
	int total_traffic;
	int total_prohibited_items;

	/*AVERAGES*/
	int avg_traffic;
	int avg_prohibited_items;	

	
	/*
		Airport Constructor;
	*/	
	public Airport(){
		MyLogger.writeMessage("Airport()", MyLogger.DebugLevel.CONSTRUCTOR);
		day = 1;
		total_days = 1;
		total_traffic = 0;
		total_prohibited_items = 0;	
		avg_traffic = 0;
		avg_prohibited_items = 0;
		result = new Results();
		
		//INITIALIZE STATES
		low_risk = new Low_Risk(this);
		moderate_risk = new Moderate_Risk(this);
		high_risk = new High_Risk(this);

		airportState = low_risk;
	
		low_risk.set_Result(result);
		moderate_risk.set_Result(result);
		high_risk.set_Result(result);
	}

		
	
	

			
	/*GETTERS */
	/*-----------------------------------------------*/

	/*getDay() :get the current day*/
	public int getDay(){ return day;}

	/*get_total_days() :get the total number of days passed */
	public int get_total_days(){return total_days;}

	/*get_total_prohibited() :get the total number of prohibited items observed*/
	public int get_total_prohibited(){return total_prohibited_items;}

	/*get_avg_traffic() :get the average traffic observed*/
	public int get_avg_traffic(){return avg_traffic;}

	/*get_avg_prohibited_items() :get the average # of prohibited items seen*/
	public int get_avg_prohibited_items(){return avg_prohibited_items;}

	/*getState() :get the current state of the airport*/
	public AirportStateI getState(){ return airportState;}

	/*get_prohibited_items() :get the list of prohibited items*/
	public ArrayList<String> get_prohibited_items(){return prohibited_items;}

	/*getLowState() :get the low_risk State */
	public AirportStateI getLowState(){return low_risk;}

	/*getModerateState() :get the moderate_risk State*/
	public AirportStateI getModerateState(){return moderate_risk;}

	/*getHighState() :get the high_risk State*/
	public AirportStateI getHighState(){return high_risk;}	


	
	/*SETTERS*/
	/*-----------------------------------------------*/

	/*setDay(): */
	public void setDay(int day_in){day = day_in;}


	/*set_average_traffic(): */
	public void set_average_traffic(int avg_in){avg_traffic = avg_in;}

	
	/*increment_total_prohibited(): increase number of prohibited items observed*/
	public void increment_total_prohibited(){total_prohibited_items++;}


	/*increment_day(): increments day.. this may be unused*/
	public void increment_day(){day++;}


	/*increment_traffic(): increases the number of travelers observed*/
	public void increment_traffic(){total_traffic++;}


	/*METHODS*/
	/*-----------------------------------------------*/
	/*newPassenger
		pass a string representation of a passenger to the current state
	*/
	public void newPassenger(String passenger){
		airportState.newPassenger(passenger);
	}	


	/*update_average(): updates the current averages */
	public void update_averages(){
		avg_traffic = total_traffic / total_days;
		avg_prohibited_items = total_prohibited_items / total_days;
	}
	

	/*newDay():
		increase total days by difference in next day and current day. 
		just incase days skip and not increment. 
	*/
	public void newDay(int day_in){
		total_days += (day_in - day);
		day = day_in;
	}


	/*setAirportState*/
	public void setAirportState(AirportStateI newAirportState){
		/*MyLogger write message*/
		MyLogger.writeMessage("StateChange:"+airportState.toString()+" -> "+newAirportState.toString(), MyLogger.DebugLevel.STATECHANGE);
		airportState = newAirportState;
	}	



	@Override
	public String toString(){
		return "Days: " + day + "\tProhibited_items: "+total_prohibited_items +"\t"+airportState.toString()+"\tavg_traffic: "+avg_traffic+"\tavg_proh_it: "+avg_prohibited_items; 		
	}



	//public void 
	public  void write_results(String output_file){
		result.writeToFile(output_file);
	}
	
}

