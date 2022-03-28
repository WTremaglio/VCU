/**************************************************************************
 * Lab 8
 **************************************************************************
 * This program reads soccer statistics from an input file and prints the
 * minimum goals, maximum goals, and average shots per game.
 * ________________________________________________________________________
 * William Tremaglio
 * 03.13.2019
 * CMSC 255 Section 004
 *************************************************************************/

import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Lab-8 {
	public static void main(String[] args) throws FileNotFoundException {

		/**************************************************************************
		 * Collecting the user input.
		 *************************************************************************/
		Scanner console = new Scanner(System.in);
		System.out.print("Input file: SoccerStats.txt");
		String inputFileName = console.next();
		System.out.print("Output file: SoccerSummary.txt");
		String outputFileName = console.next();

		File inputFile = new File(inputFileName);
		Scanner in = new Scanner(inputFile);
		in.useDelimiter("\t");
		PrintWriter out = new PrintWriter(outputFileName);

		/**************************************************************************
		 * Declaring and initializing variables.
		 *************************************************************************/
		int goals;
		double average, shots, total;
		String name;

		int count = 0;
		int minValue = 1000;
		int maxValue = 0;
		double total = 0;
		String minteam = " ";
		String maxteam = " ";

		/**************************************************************************
		 * Collecting the user input and calculating the min, max, and average.
		 *************************************************************************/
		while(in.hasNext()) {
			name = in.next();
			goals = in.nextInt();

			if (goals < minValue) {
				minValue = goals;
				minteam = name;
			}

			if (goals > maxValue) {
				maxValue = goals;
				maxteam = name;
			}

			shots = in.nextDouble();
			total += shots;
			count++;
		}

		average = total / count;

		/**************************************************************************
		 * Printing statistics to the output file.
		 *************************************************************************/
		out.println("Minimum goals scored: " + minteam + " " + minValue);
		out.println("Maximum goals scored: " + maxteam + " " + maxValue);
		out.printf("Average shots per game: %.3f" , average);
		
		in.close();
		out.close();
	}
}
