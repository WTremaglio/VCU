/**************************************************************************
 * Project 3 - Metal Art 2.0
 **************************************************************************
 * This project prints the area and costs of building a model sculpture
 * based on user input for the size and material used.
 * ________________________________________________________________________
 * William Tremaglio
 * 02.21.2019
 * CMSC 255 Section 004
 *************************************************************************/

import java.util.Scanner;

public class MetalChoice {
	public static void main(String[] args) {

		/**************************************************************************
		 * Printing the program information.
		 *************************************************************************/
		System.out.println("William Tremaglio");
		System.out.println("Project 2 - MetalArt");
		System.out.println("This project displays the area and costs of building a model sculpture based on user");
		System.out.println("input for the size and material used.");
		System.out.println("February 14, 2019");
		System.out.println("CMSC 255 Section 004");

		/**************************************************************************
		 * Defining the material prices as a constant and establishing the scanner.
		 *************************************************************************/
		Scanner in = new Scanner (System.in);
		final double ALUMINUM = 1.5;
		final double STEEL = 2.85;
		final double TITANIUM = 4.5;
		final double BRONZE = 8;
		final double SILVER = 12.5;
		final double GOLD = 19.99;

		/**************************************************************************
		 * Declaring the variables.
		 *************************************************************************/
		int numLetters;
		int numSculptures;
		char sculptureMaterial;
		char plateMaterial;
		double firstBaseLength;
		double firstHeight;
		double firstBaseArea;
		double firstSlantLength;
		double firstSurfaceArea;
		double secondBaseLength;
		double secondHeight;
		double secondBaseArea;
		double secondSlantLength;
		double secondSurfaceArea;
		double prismHeight;
		double prismLength;
		double prismWidth;
		double prismSurfaceArea;
		double sculptureSurfaceArea;
		double sculptureCost;
		double priceLetters = 0;
		double plateCost;
		double totalSculptureCost;
		double totalCost = 0;
		String sculptureName;
		String start;
		String userInput = "";

		/**************************************************************************
		 * Starting the program and determining the number of sculptures the
		 * customer would like to be made. Using if/else statements to set the
		 * program to terminate when the user types "quit".
		 *************************************************************************/
		while (!userInput.equals("quit")) {

			System.out.println("Type anything to start. Type quit at anytime to shutdown.");
			start = in.next();
			if (start.contains("quit")) {
				break;
			}
		
			System.out.print("Enter the amount of sculptures you would like to make: ");
			userInput = in.next();
			if (userInput.contains("quit")) {
				break;
			}
			else {
				numSculptures = Integer.parseInt(userInput);
			}

			/**************************************************************************
			 * Setting up the main while loop to run until numSculptures hits zero.
			 *************************************************************************/
			while (numSculptures != 0) {
				numSculptures--;

				/**************************************************************************
				 * Gathering the user input. Using if/else statements to set the program to
				 * terminate when the user types "quit".
				 *************************************************************************/
				in.nextLine();
				System.out.print("Enter the name of the sculpture: ");
				userInput = in.nextLine();
				if (userInput.contains("quit")) {
					break;
				}
				else {
					sculptureName = userInput;
				}
				
				System.out.print("What material would you like " + sculptureName + " to be made out of? Type 'A' for aluminum, 'S' for steel, or 'T' for titanium: ");
				userInput = in.next();
				if (userInput.contains("quit")) {
					break;
				}
				else {
					sculptureMaterial = userInput.charAt(0);
				}
				
				System.out.print("What material would you like the name plate to be made out of? Type 'B' for bronze, 'S' for silver, or 'G' for gold: ");
				userInput = in.next();
				if (userInput.contains("quit")) {
					break;
				}
				else {
					plateMaterial = userInput.charAt(0);
				}
			
				System.out.print("Enter the length of the base of the first pyramid (inches): ");
				userInput = in.next();
				if (userInput.contains("quit")) {
					break;
				}
				else {
					firstBaseLength = Double.parseDouble(userInput);
				}
				
				System.out.print("Enter the height of the first pyramid (inches): ");
				userInput = in.next();
				if (userInput.contains("quit")) {
					break;
				}
				else {
					firstHeight = Double.parseDouble(userInput);
				}
				
				System.out.print("Enter the length of the base of the second pyramid (inches): ");
				userInput = in.next();
				if (userInput.contains("quit")) {
					break;
				}
				else {
					secondBaseLength = Double.parseDouble(userInput);
				}
				
				System.out.print("Enter the height of the second pyramid (inches): ");
				userInput = in.next();
				if (userInput.contains("quit")) {
					break;
				}
				else {
					secondHeight = Double.parseDouble(userInput);
				}
			
				System.out.print("Enter the height of the rectangular prism (inches): ");
				userInput = in.next();
				if (userInput.contains("quit")) {
					break;
				}
				else {
					prismHeight = Double.parseDouble(userInput);
				}
			
				System.out.print("Enter the length of the rectangular prism (inches): ");
				userInput = in.next();
				if (userInput.contains("quit")) {
					break;
				}
				else {
					prismLength = Double.parseDouble(userInput);
				}
				
				System.out.print("Enter the width of the rectangular prism (inches): ");
				userInput = in.next();
				if (userInput.contains("quit")) {
					break;
				}
				else {
					prismWidth = Double.parseDouble(userInput);
				}

				/**************************************************************************
				 * Calculating the area of the base and the slant length of the first
				 * pyramid.
				 *************************************************************************/
				firstBaseArea = 0.5 * firstBaseLength * Math.sqrt(firstBaseLength * firstBaseLength - ((0.5 * firstBaseLength) * (0.5 * firstBaseLength)));
				firstSlantLength = Math.sqrt((0.5 * firstBaseLength) * (0.5 * firstBaseLength) + firstHeight * firstHeight);

				/**************************************************************************
				 * Calculating the surface area of the first pyramid.
				 *************************************************************************/
				firstSurfaceArea = firstBaseArea + 0.5 * (3 * firstBaseLength * firstSlantLength);

				/**************************************************************************
				 * Calculating the area of the base and the slant length of the second
				 * pyramid.
				 *************************************************************************/
				secondBaseArea = 0.5 * secondBaseLength * Math.sqrt(secondBaseLength * secondBaseLength - ((0.5 * secondBaseLength) * (0.5 * secondBaseLength)));
				secondSlantLength = Math.sqrt((0.5 * secondBaseLength) * (0.5 * secondBaseLength) + secondHeight * secondHeight);

				/**************************************************************************
				 * Calculating the surface area of the second pyramid.
				 *************************************************************************/
				secondSurfaceArea = secondBaseArea + 0.5 * (3 * secondBaseLength * secondSlantLength);

				/**************************************************************************
				 * Calculating the surface area of the prism.
				 *************************************************************************/
				prismSurfaceArea = (2 * prismLength * prismWidth) + (2 * prismLength * prismHeight) + (2 * prismWidth * prismHeight);

				/**************************************************************************
				 * Calculating the surface area of the sculpture and the number of letters
				 * in the sculpture name along with the cost of the letters.
				 *************************************************************************/
				sculptureSurfaceArea = firstSurfaceArea + secondSurfaceArea + prismSurfaceArea;
				numLetters = sculptureName.length();
				
				if (numLetters <= 5) {
					priceLetters = 19.99;
				}
				else if (numLetters <= 10) {
					numLetters = numLetters - 5;
					priceLetters = 19.99 + (numLetters * 2.5);
				}
				else if (plateMaterial == 'G') {
					numLetters = numLetters - 5;
					priceLetters = 17.99 + (numLetters * 1.85);
				}

				/**************************************************************************
				 * Calculating the price of the sculpture based on the material chosen.
				 *************************************************************************/
				if (sculptureMaterial == 'A') {
					sculptureCost = sculptureSurfaceArea * ALUMINUM;
				}
				else if (sculptureMaterial == 'S') {
					sculptureCost = sculptureSurfaceArea * STEEL;
				}
				else {
					sculptureCost = sculptureSurfaceArea * TITANIUM;
				}

				/**************************************************************************
				 * Calculating the price of the plate based on the material chosen.
				 *************************************************************************/
				if (plateMaterial == 'B') {
					plateCost = BRONZE;
				}
				else if (plateMaterial == 'S') {
					plateCost = SILVER;
				}
				else {
					plateCost = GOLD;
				}

				/**************************************************************************
				 * Adding all of the costs to the grand total and calculating the total
				 * cost of the sculpture.
				 *************************************************************************/
				totalCost = totalCost + priceLetters + sculptureCost + plateCost;
				totalSculptureCost = priceLetters + sculptureCost + plateCost;

				/**************************************************************************
				 * Printing all of the pricing information for the sculpture along with
				 * the current total cost.
				 *************************************************************************/
				System.out.printf("The pricing information for " + sculptureName + " are as follows:%n");
				System.out.printf("The cost of the sculpture purely based off of the dimensions and material: $%,.2f%n", sculptureCost);
				System.out.printf("The cost of the name plate purely off of the material: $%,.2f%n", plateCost);
				System.out.printf("The cost of the letters to be printed on the plate: $%,.2f%n", priceLetters);
				System.out.printf("The total cost of the sculpture: $%,.2f%n", totalSculptureCost);
				System.out.printf("Your current grand total: $%,.2f%n", totalCost);
			}
			
			System.out.printf("Your grand total is $%,.2f%n", totalCost);
		}
	}
}
