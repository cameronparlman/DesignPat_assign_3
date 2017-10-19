package airportSecurityState.driver;

import airportSecurityState.util.FileProcessor;
import airportSecurityState.util.MyLogger;
import airportSecurityState.airport.Airport;

/** runs the airportSecurityState program 
@author cameron parlman
@author cparlma1@binghamton.edu
@version 0.1
@since 0.0
*/
public class Driver{
	public static void main(String[] args){

	/*COMMAND LINE VERIFICATION */
	/*Verify number of arguments*/
	if(args.length != 3){ usage();return;}
	else{}	


	/*VERIFY DEBUG LEVEL */
	try{
		int debugval = Integer.parseInt(args[2]);
		if(debugval >= 0 && debugval<= 4){	
			MyLogger.setDebugValue(Integer.parseInt(args[2]));				
		}
		else{throw new IllegalArgumentException("Invalid Debug Value");}
	}
	catch(NumberFormatException exception){ 
		System.err.println("Invalid Debug value: " + exception.getMessage());
		exception.printStackTrace();
		System.exit(1);
	} 
	catch(IllegalArgumentException exception){
		System.err.println(exception.getMessage());
		exception.printStackTrace();
		System.exit(1);
	}
	


	/*ASSIGN FILE I/O NAMES*/
	String file_input_name = args[0];
	String file_output_name = args[1];	

	Airport airport = new Airport();

	/* READ INPUT FILE WITH FILEPROCESSOR */
	FileProcessor fileprocessor = new FileProcessor(file_input_name);		
	String line = "";
	while(fileprocessor.hasNext()){
		line = fileprocessor.readLine();
		MyLogger.writeMessage(airport.toString(), MyLogger.DebugLevel.DEBUG);
		airport.newPassenger(line);	
		 //String delims = "[:;]+";
         //String[] tokens = line.split(delims);

		//for(String e : tokens){System.out.print(e+", ");}
		//	System.out.println("");
	 
	}


	}//END MAIN

/* USAGE STRING */
public static void usage(){System.out.println("airportSecurityState input output debugvalue");}

}//END DRIVER CLASS 

