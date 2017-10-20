package airportSecurityState.util;

import java.util.ArrayList;
import java.io.File;
import java.io.PrintWriter;

import java.io.FileNotFoundException;

import airportSecurityState.util.MyLogger;


/**
	@see studentCoursesBackup.util
*/
public class Results implements FileDisplayInterface, StdoutDisplayInterface{
	static String output_file;
	private ArrayList<String> results;	

	/**
		default constructor initializes empty ArrayList results
	*/
	public Results(){ 
		MyLogger.writeMessage("Results()" , MyLogger.DebugLevel.CONSTRUCTOR);	
		results = new ArrayList();
	}


	/**
	@param string_in is a result string that will be stored for future printing
	*/
	public void insert(String string_in){
		results.add(string_in);
	}
	

	/**
		write the contents of results(ArrayList) to the file specified by output_file
		@param output_file is the file to be written to
	*/
	public void writeToFile(String output_file){		
		try{
			PrintWriter out = new PrintWriter(output_file);
			for(String str : results){
				out.println(str);
			}
			out.close();
		}catch(FileNotFoundException e){
			System.out.println("File ("+output_file+") Not Found");
		}
	}

	public void writeToStdout(String s){
		for(String str:results){
		System.out.println(str);
		}
	}
	
	/*
		set the output_file name;		
	*/	
	public static void set_output_file(String output_name){
		output_file = output_name;
	}
}
