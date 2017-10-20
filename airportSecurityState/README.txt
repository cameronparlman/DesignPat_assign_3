Assuming you are in the same directory as this README

## To Clean
ant -buildfile src/build.xml clean

------------------------------------------------------------------------------------
## To Compile
ant -buildfile src/build.xml all


------------------------------------------------------------------------------------
# To Run by specifying arguments from the command line 
	run with args relative to build.xml
ant -buildfile src/build.xml run -Darg0=input_folder/input-1.txt -Darg1=output_folder/output-1.txt -Darg2=4


------------------------------------------------------------------------------------
# To Run by specifying arguments from command Line, where input files are from /home/usr/
	#! replace cameron with your user name, 
	#! change /home/cameron/input_file/input-1.txt with wherever your directory is. 
ant -buildfile src/build.xml run -Darg0=/home/cameron/input_file/input-1.txt -Darg1=/home/cameron/output_file/output-1.txt -Darg2=4


------------------------------------------------------------------------------------
# To run default args 
ant -buildfile src/build.xml run


------------------------------------------------------------------------------------
# To Test
ant -buildfile src/build.xml test


------------------------------------------------------------------------------------
#OUTPUT 
the output of the program is as follows. 
For each input line. the program will output a line of operation Ids associated with the 
	Risk State.
	the operation ids are written after the the current passenger has been processed, and the 
	Risk State has been updated. 


------------------------------------------------------------------------------------
#Makefile 
	the makefile, in the same directory as build.xml can be used to observe the compilation and 
	running procedure of the program. 
	
	the makefile supports several operations that will run with the simple input text provided with 
	the program
	
	These "makes" will set the different DebugLevels and will print accordingly 
	make run				[debug level : 0] no logging 				"RELEASE"
	make debug				[debug level : 1] log airport feilds  		"DEBUG"
	make results			[debug level : 2] currently no logging 		"RESULTS"
	make changes 			[debug level : 3] log state changes 		"STATECHANGE"		
	make constructors 		[debug level : 4] log constructors 			"CONSTRUCTOR"	

------------------------------------------------------------------------------------
## To Create TarBall for submission 
//unless tar action specified by build.xml
#first clean. 
from parent directory run
tar -cvf cameron_parlman_assign_3.tar cameron_parlman_assign3


------------------------------------------------------------------------------------

------------------------------------------------------------------------------------

"I have done this assignment completely on my own. I have not copied
it, nor have I given my solution to anyone else. I understand that if
I am involved in plagiarism or cheating I will have to sign an
official form that I have cheated and that this form will be stored in
my official university record. I also understand that I will receive a
grade of 0 for the involved assignment for my first offense and that I
will receive a grade of F for the course for any additional
offense.â€

[Date: 11/19/2017] -- Please add the date here
Cameron Parlman.


------------------------------------------------------------------------------------
#Data Structures and Complexity in terms of Big O   (Time and Space)
	other than the ArrayList in airport that contains the list of prohibited items there 
	are no significant data structures and the longest potential running function is 
	checkItem(String) which calls ArrayList .contains() having a worst possible running time of O(n)
		However i would imaging the build int contains() function has some search optimization properties 
		that makes its runtime significantly less. 

------------------------------------------------------------------------------------
##Citations 
Cay S. 		Horstmann Big Java Early Objects
O'Reilly	Head First Design Patterns


------------------------------------------------------------------------------------
##Notes while developing 
	FIGURE OUT HOW TO GET ANT TO USE JUNIT TESTS!!!!!!!!!!!!!!
		it cant be that hard! 
