//ROMAN SOKOLOVSKI
//ASSIGNMENT2
//CISC124
//10185440 14rs95


package cisc124;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.util.Scanner;


public class Assn2_14rs95 {
	
	public static void readFile() throws IOException{
		
		Double[][] finalArray = new Double[1000][8];//empty array of 1000 arrays each of len 8
		Scanner scanner = new Scanner(new File("/Users/Roman/Documents/workspace/cisc124/Logger (1).csv"));//put ur path here
		String line = "";
		int row = 0;
		
		while (scanner.hasNextLine()) {
			line = scanner.nextLine();
			String[] arrayOfLine = line.split(",");//gets the first line of code and gets rid of , 
			
			for (int x = 0; x < arrayOfLine.length; x++) {
				finalArray[row][x] = Double.parseDouble(arrayOfLine[x]);//iterates thru above array and adds to final 2d array
		} 
			
		row++;
		
		} 
		
		writeFile(finalArray); //sends created 2d array to write/math method
		scanner.close();
		System.out.println("File created! check workplace folder for 'Report.txt' ");
		}
	
	
	public static void writeFile(Double[][] data) throws IOException{ //math and writer method
		
		PrintWriter writer = new PrintWriter(new FileWriter("Report.txt", true)); //this uses the writer class to write in a txt file
		writer.println("Motor Use Summary:");//whenever you see writer.println(words here) this is what is being written in txt file
		
		
		for (int iter=1; iter<8; iter++)	{ 
			Double startTime = 0.0; 
			Double endTime = 0.0; 
			Double avgnum = 0.0; 
			Double totalAmps = 0.0; 
			Double motorIters = 0.0; 
			boolean didRun = false; 
			boolean isActive = false; 
			
			for (Double[]i : data) { //finds if motor ran
				if (i[iter] >= 1.0) { 
					didRun = true;
				} 
			}
			
			if (didRun == false){ //if motor didnt run 
				writer.println("\t");
				writer.println("Error!!!: Motor " + iter + " didnt run.");
			} else {
				writer.println("\t");
				writer.println("Motor "+ iter +":");
			}
			
			for (Double[] array1 : data) { //iterates though array
				if (array1[iter] >= 1.0) {
					isActive = true;
				}
				while (isActive == true) {
					if (startTime == 0.0) {
						startTime = array1[0];
						totalAmps = array1[iter];
						motorIters+=1;
					} else {
						endTime = array1[0];
						totalAmps += array1[iter];
						motorIters+=1;
						avgnum = (totalAmps/motorIters);
					}
					isActive = false;									
				}
				
				if (isActive == false) {
					//printf is used below to efficiently write/display results
					if (startTime != 0.0 && endTime != 0.0 && array1[iter] < 1.0) {
						if (avgnum > 8.0) {
							writer.printf("***Current Exceeded!: %.3f amps, starting at %.0f seconds, to %.0f seconds.", avgnum, startTime, endTime);
							writer.println("\t");
							startTime = 0.0;
							endTime = 0.0;
							motorIters = 0.0;
							avgnum = 0.0;
							totalAmps = 0.0;
						} else {
							writer.printf("%.3f amps, starting at %.0f seconds, to %.0f seconds.", avgnum, startTime, endTime);
							writer.println("\t");
							startTime = 0.0;
							endTime = 0.0;
							motorIters = 0.0;
							avgnum = 0.0;
							totalAmps = 0.0;
						}
						
					} else {
						continue;
					}
				}
			}
		}
		writer.close();
	}		
	
	public static void main(String[] args) throws IOException {
		System.out.println("Motor Analyzer 1.0");
		readFile();
	}
}

