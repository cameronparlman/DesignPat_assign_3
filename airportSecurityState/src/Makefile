all: compile

compile: 
	ant -buildfile build.xml all

run: 
	ant -buildfile build.xml run

test: 
	ant -buildfile build.xml test

#running with different DEBUG LEVELS
debug:
	ant -buildfile build.xml run -Darg0=input_folder/input-1.txt -Darg1=output_folder/outpu1.txt -Darg2=1

results: 
	ant -buildfile build.xml run  -Darg0=input_folder/input-1.txt -Darg1=output_folder/outpu1.txt -Darg2=2

changes: 
	ant -buildfile build.xml run -Darg0=input_folder/input-1.txt -Darg1=output_folder/outpu1.txt -Darg2=3

constructors: 
	ant -buildfile build.xml run -Darg0=input_folder/input-1.txt -Darg1=output_folder/outpu1.txt -Darg2=4
