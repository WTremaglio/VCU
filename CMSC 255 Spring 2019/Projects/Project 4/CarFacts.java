/**************************************************************************
 * Project 4 - Car Facts
 **************************************************************************
 * This program takes in data about cars from a file, calculates statistics
 * about each car, and outputs it to another file.
 * ________________________________________________________________________
 * William Tremaglio
 * 03.14.2019
 * CMSC 255 Section 004
 *************************************************************************/

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class CarFacts {
    public static void main(String[] args) throws FileNotFoundException {

        /**************************************************************************
         * Printing program information.
         *************************************************************************/
        System.out.println("William Tremaglio");
        System.out.println("Car Fact Data");
        System.out.println("This program takes in data about cars from a file, calculates statistics about each car,");
        System.out.println("and outputs it to another file.");
        System.out.println("March 14, 2019");
        System.out.println("CMSC 255 Section 004");
        System.out.print("\n");

        /**************************************************************************
         * Calling inputData method.
         *************************************************************************/
        inputData();
    }

    public static void inputData() throws FileNotFoundException {

        /**************************************************************************
         * Setting up the scanner and PrintWriter to read the input file and write
         * to the outpute file.
         *************************************************************************/
        Scanner console = new Scanner(System.in);
        System.out.print("Input file: ");
        String inputFileName = console.next();
        System.out.print("Output file: ");
        String outputFileName = console.next();

        File inputFile = new File(inputFileName);
        Scanner in = new Scanner(inputFile);
        in.useDelimiter("\t");
        PrintWriter out = new PrintWriter(outputFileName);

        /**************************************************************************
         * Declaring the variables.
         *************************************************************************/
        String makeModel;
        int numMiles;
        double tankSize;
        int price;
        double drivabilityScore;

        String makeModelBestMileage = null;
        double bestMileage = 100.0;

        String makeModelLowestPrice = null;
        int lowestPrice = 1000000;

        String makeModelBestValue = null;
        double bestValue = 0.0;

        /**************************************************************************
         * This while loop collects the data from the input file until it reaches
         * the end [(in.hasNext)]
         *************************************************************************/
        while (in.hasNext()) {

            /**************************************************************************
             * Collecting the data from the file.
             *************************************************************************/
            makeModel = in.next();
            numMiles = in.nextInt();
            tankSize = in.nextDouble();
            price = in.nextInt();
            drivabilityScore = in.nextDouble();
            in.nextLine();

            double mileageRating = calcMileageRating(numMiles, tankSize);
            double overallValue = calcOverallValue(mileageRating,price,drivabilityScore);

            /**************************************************************************
             * Checking for the best mileage rating, lowest rating, lowest price, and
             * best overall value.
             *************************************************************************/
            if (mileageRating < bestMileage) {
                makeModelBestMileage = makeModel;
                bestMileage = mileageRating;
            }
            if (price < lowestPrice) {
                makeModelLowestPrice = makeModel;
                lowestPrice = price;
            }
            if (overallValue > bestValue) {
                makeModelBestValue = makeModel;
                bestValue = overallValue;
            }

            /**************************************************************************
             * Calling displayData method.
             *************************************************************************/
            displayData(makeModel,mileageRating,overallValue,out);
        }

        /**************************************************************************
         * Printing the best mileage rating, lowest price, and best overall value
         * to the output file.
         *************************************************************************/
        out.print("The car with the best gas mileage rating is " + makeModelBestMileage + " with a rating of: ");
        out.printf("%.2f%n", bestMileage);

        out.println("The car with the best price is " + makeModelLowestPrice + " with a price of: " + lowestPrice);

        out.print("The car with the best overall value is " + makeModelBestValue + " with a rating of: ");
        out.printf("%.2f%n", bestValue);

        in.close();
        out.close();
    }

    /**************************************************************************
     * calcMileageRating calculates the mileage rating of a car.
     *************************************************************************/
    public static double calcMileageRating(int numMiles, double tankSize){
        double resultMileage = numMiles / tankSize;
        return resultMileage;
    }

    /**************************************************************************
     * calcOverallValue calculates the overall value of a car.
     *************************************************************************/
    public static double calcOverallValue(double mileageRating, double price, double drivabilityScore) {
        double resultValue = 0.35 * mileageRating + 0.4 * price + 0.25 * drivabilityScore;
        return resultValue;
    }

    /**************************************************************************
     * displayData prints all of the data to the output file.
     *************************************************************************/
    public static void displayData(String makeModel, double mileageRating, double overallValue, PrintWriter out) {
        out.printf("%-20s%10.2f mpg Value: %.2f%n", makeModel, mileageRating, overallValue);
    }
}
