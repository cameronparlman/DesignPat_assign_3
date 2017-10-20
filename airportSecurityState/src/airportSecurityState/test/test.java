package airportSecurityState.test;
import airportSecurityState.airport.Airport;
import airportSecurityState.airportStates.Low_Risk;
import airportSecurityState.airportStates.Moderate_Risk;
import airportSecurityState.airportStates.High_Risk;
import airportSecurityState.airportStates.StateHelper;


public class test{
	public static void main(String[] args){
		System.out.println("Test Driver for airport Security compile and working");
		
		/*TEST AIRPORT*/	
	
		System.out.println("TEST 1: AIRPORT");
		System.out.println("\tTEST 1A: ");
		Airport airport= new Airport();
		if(airport.getDay() != 1){
			System.out.println("\tTEST 1A FAILED");
			System.out.println("\tairport.getDay() expected 1 but was "+airport.getDay());
			System.out.println("\tthis test failing can effect the following tests");
		}	
		else{
			System.out.println("\tTEST 1A PASSED");
		}



		/*airport new day*/
		System.out.println("\tTEST 1B:");
		airport.newDay(2);
		if(airport.getDay() != 2){
			System.out.println("\tTEST 1B FAILED");
			System.out.println("\tairport.getDay() expected 2 but was "+airport.getDay());
		}
		else{
			System.out.println("\tTEST 1B PASSED");
		}
		


		System.out.println("\tTEST 1C:");
		/* airport new day skips a day */	
		airport.newDay(4);
		if(airport.getDay() != 4){ 
			System.out.println("\tTEST 1C FAILED");
			System.out.println("\tairport.getDay() expected 4 but was "+airport.getDay()); 	
		}	
		else{
			System.out.println("\tTEST 1C PASSED");
		}
		if(airport.get_total_days() != 4){
			System.out.println("\tTEST 1C FAILED");
			System.out.println("\tairport.get_total_days() expected 4 but was "+airport.get_total_days()); 	
		}	
		else{
			System.out.println("\tTEST 1C PASSED");
		}
		


		System.out.println("Test 2: AIRPORT");
				
		
	



	}
}
