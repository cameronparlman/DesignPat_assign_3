package airportSecurityState.driver;

import airportSecurityState.util.FileProcessor;
import airportSecurityState.util.MyLogger;

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
		if(Integer.parseInt(args[2]) >= 0 && Integer.parseInt(args[2]) <= 4){	
			MyLogger.setDebugValue(Integer.parseInt(args[2]));				
		}
		else{ usage(); return;}
	}
	catch(NumberFormatException e){ System.out.println("Invalid Debug value"); return;} 


	/*ASSIGN FILE I/O NAMES*/
	String file_input_name = args[0];
	String file_output_name = args[1];	


	/* READ INPUT FILE WITH FILEPROCESSOR */
	FileProcessor fileprocessor = new FileProcessor(file_input_name);		
	String line = "";
	while(fileprocessor.hasNext()){
		line = fileprocessor.readLine();
		String delims = "[:;]+";
		String[] tokens = line.split(delims);

	}


	}//END MAIN

/* USAGE STRING */
public static void usage(){System.out.println("airportSecurityState input output debugvalue");}

}//END DRIVER CLASS 

