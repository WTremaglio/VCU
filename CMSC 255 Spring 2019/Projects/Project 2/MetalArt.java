/**************************************************************************
 * Project 2 - Metal Art
 **************************************************************************
 * This project prints the area and costs of building a model sculpture
 * based on user input for the size of the pyramids and rectangular prism.
 * ________________________________________________________________________
 * William Tremaglio
 * 02.14.2019
 * CMSC 255 Section 004
 *************************************************************************/

import java.util.Scanner;

public class MetalArt {
	public static void main(String[] args) {

		/**************************************************************************
		 * Printing program information.
		 *************************************************************************/
		System.out.println("William Tremaglio");
		System.out.println("Project 2 - MetalArt");
		System.out.println("This project displays the area and costs of building a model sculpture based on user");
		System.out.println("input for the size of the pyramids and rectangular prism.");
		System.out.println("February 14, 2019");
		System.out.println("CMSC 255 Section 004");
		
		/**************************************************************************
		 * Defining the material price as a constant and establishing the scanner.
		 *************************************************************************/
		final double MATERIAL_PRICE = 1.67;
		Scanner in = new Scanner (System.in);

		/**************************************************************************
		 * Declaration of all variables.
		 *************************************************************************/
		String sculptureName;
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
		double totalSurfaceArea;
		double totalCost;

		/**************************************************************************
		 * Collecting the user input.
		 *************************************************************************/
		System.out.print("Enter the name of the sculpture: ");
		sculptureName = in.nextLine();
		
		System.out.print("Enter the length of the base of the first pyramid (inches): ");
		firstBaseLength = in.nextDouble();
		System.out.print("Enter the height of the first pyramid (inches): ");
		firstHeight = in.nextDouble();
		
		System.out.print("Enter the length of the base of the second pyramid (inches): ");
		secondBaseLength = in.nextDouble();
		System.out.print("Enter the height of the second pyramid (inches): ");
		secondHeight = in.nextDouble();
		
		System.out.print("Enter the height of the rectangular prism (inches): ");
		prismHeight = in.nextDouble();
		System.out.print("Enter the length of the rectangular prism (inches): ");
		prismLength = in.nextDouble();
		System.out.print("Enter the width of the rectangular prism (inches): ");
		prismWidth = in.nextDouble();

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
		 * Calculating the area of the base and the slant of the second pyramid.
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
		 * Calculating the total surface area and the total cost of the metal
		 * sculpture.
		 *************************************************************************/
		totalSurfaceArea = firstSurfaceArea + secondSurfaceArea + prismSurfaceArea;
		totalCost = MATERIAL_PRICE * totalSurfaceArea;

		/**************************************************************************
		 * Printing the output to the console.
		 *************************************************************************/
		System.out.println("The " + sculptureName + " surface area calculations are:");
		System.out.printf("Surface area of the first pyramid: %,.2f square inches \n", firstSurfaceArea);
		System.out.printf("Surface area of the second pyramid: %,.2f square inches \n", secondSurfaceArea);
		System.out.printf("Surface area of the rectangular prism: %,.2f square inches \n", prismSurfaceArea);
		System.out.printf("Total surface area: %,.2f square inches \n", totalSurfaceArea);
		System.out.printf("The total cost of the material to build " + sculptureName + " is $%,.2f", totalCost);
	}
}
