package airportSecurityState.airport;

import airportSecurityState.util.MyLogger;
import airportSecurityState.airportStates.AirportStateI;
import airportSecurityState.airportStates.Low_Risk;
import java.util.ArrayList;
import java.util.Arrays;

/*

*/
public class Airport{
	ArrayList<String> prohibited_items = new ArrayList(Arrays.asList("gun", "nailcutter", "blade", "knife"));
	AirportStateI airportState;	

	AirportStateI low_risk;	
	AirportStateI moderate_risk;
	AirportStateI high_risk;

	//totals
	int day;
	int total_days;
	int total_traffic;
	int total_prohibited_items;


	//averages 
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
		
		//INITIALIZE STATES
		low_risk = new Low_Risk(this);
	//	moderate_risk = new Moderate_Risk(this);
	//	high_risk = new High_Risk(this);

		airportState = low_risk;
	}

	/*
	setAirportState
	*/
	void setAirportState(AirportStateI newAirportState){
		airportState = newAirportState;
	}	
	
	public AirportStateI getLowState(){return low_risk;}
	public AirportStateI getModerateState(){return moderate_risk;}
	public AirportStateI getHighState(){return high_risk;}	
	
	public void newPassenger(String passenger){
		airportState.newPassenger(passenger);
	}	
		
	/*GETTERS */
	public int getDay(){ return day;}
	public int get_total_days(){return total_days;}
	public int get_total_prohibited(){return total_prohibited_items;}
	public int get_avg_traffic(){return avg_traffic;}
	public int get_avg_prohibited_items(){return avg_prohibited_items;}
	public ArrayList<String> get_prohibited_items(){return prohibited_items;}


	/*SETTERS*/
	public void set_average_traffic(int avg_in){avg_traffic = avg_in;}
	public void setDay(int day_in){day = day_in;}
	
	//increase total days by difference in next day and current day. just incase days skip and not increment. 
	public void newDay(int day_in){
		total_days += (day_in - day);
		day = day_in;
	}

	/*METHODS*/
	public void increment_total_prohibited(){total_prohibited_items++;}
	public void increment_day(){day++;}
	public void increment_traffic(){total_traffic++;}
	public void update_averages(){
		avg_traffic = total_traffic / total_days;
		avg_prohibited_items = total_prohibited_items / total_days;
	}
	
	@Override
	public String toString(){
		return "Days: " + day + "\tProhibited_items: "+total_prohibited_items +"\t"+airportState.toString(); 		
	}
	
}

