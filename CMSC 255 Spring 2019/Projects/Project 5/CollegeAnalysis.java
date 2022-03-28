/**************************************************************************
 * Project 5 - College Analysis
 **************************************************************************
 * This program takes in data about college admissions from a file and
 * organizes it into an output file.
 * ________________________________________________________________________
 * William Tremaglio
 * 03.31.2019
 * CMSC255 Section 004
 *************************************************************************/

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class CollegeAnalysis {
    public static void main(String[] args) throws FileNotFoundException {

        /**************************************************************************
         * Calling printHeading method.
         *************************************************************************/
        printHeading();

        /**************************************************************************
         * Setting up the scanner and PrintWriter to read the input file and write
         * to the outpute file.
         *************************************************************************/
        Scanner console = new Scanner(System.in);
        System.out.print("Input file: ");               // Asking the user for the input file
        String inputFileName = console.next();          // Assigning inputFileName to the user's input
        System.out.print("Output file: ");              // Asking the user for the output file
        String outputFileName = console.next();         // Assigning outputFileName to the user's input
        System.out.print("Input Number of lines: ");    // Asking the user for the number of entries in the input file
        String lines = console.next();                  // Making lines equal to the user's input
        int numLines = Integer.parseInt(lines);         // Converting lines into an Integer

        File inputFile = new File(inputFileName);
        File outputFile = new File(outputFileName);

        /**************************************************************************
         * Calling parseData method.
         *************************************************************************/
        parseData(inputFile, outputFile, numLines);
    }


    /**************************************************************************
     * printHeading prints the program information.
     *************************************************************************/
    public static void printHeading() {
        System.out.println("William H Tremaglio");
        System.out.println("College Analysis");
        System.out.println("This program takes in data about college admissions from a file and organizes it into an");
        System.out.println("output file.");
        System.out.println("March 31, 2019");
        System.out.println("CMSC 255 Section 004");
        System.out.print("\n");
    }

    /**************************************************************************
     * parseData takes data from the input file and organizes it into the
     * output file.
     *************************************************************************/
    public static void parseData(File inputFile, File outputFile, int numLines) throws FileNotFoundException {

        /**************************************************************************
         * Declaring/Initializing Scanner and PrintWriter.
         *************************************************************************/
        Scanner in = new Scanner(inputFile);
        PrintWriter out = new PrintWriter(outputFile);

        /**************************************************************************
         * Skipping the header line.
         *************************************************************************/
        String line = in.nextLine();

        /**************************************************************************
         * Making an array for the institutions and each nationality.
         *************************************************************************/
        String input[] = new String[11];
        String institution[] = new String[numLines];    // Making a String based array for the institution names
        int population[] = new int[numLines];           // Making an integer based array for the populations
        double white[] = new double[numLines];          // Making a double based array for percentage of the population
                                                        // that is White
        double black[] = new double[numLines];          // Making a double based array for the percentage of the
                                                        // population that is Black/African American
        double hispanic[] = new double[numLines];       // Making a double based array for the percentage of the
                                                        // population that is Hispanic
        double asian[] = new double[numLines];          // Making a double based array for the percentage of the
                                                        // population that is Asian
        double indian[] = new double[numLines];         // Making a double based array for the percentage of the
                                                        // population that is American Indian or Alaskan Native
        double hawaiian[] = new double[numLines];       // Making a double based array for the percentage of the
                                                        // population that is Native Hawaiian or other Pacific Islander
        double more[] = new double[numLines];           // Making a double based array for the percentage of the
                                                        // population that classifies as more than one nationality
        double alien[] = new double[numLines];          // Making a double based array for the percentage of the
                                                        // population that is a nonresident or alien
        double unidentified[] = new double[numLines];   // Making a double based array for the percentage of the
                                                        // population that is unidentified

        /**************************************************************************
         * Organizing the data into arrays.
         *************************************************************************/
        int i = 0;
        while (i < numLines) {
            line            = in.nextLine();
            input           = line.split("\t");                 // Splitting the String by tabs
            institution[i]  = input[0];                         // Assigning array institution to input[0]
            population[i]   = Integer.parseInt(input[1]);       // Assigning array population to input[1]
            white[i]        = Double.parseDouble(input[2]);     // Assigning array white to input[2]
            black[i]        = Double.parseDouble(input[3]);     // Assigning array black to input[3]
            hispanic[i]     = Double.parseDouble(input[4]);     // Assigning array hispanic to input[4]
            asian[i]        = Double.parseDouble(input[5]);     // Assigning array asian to input[5]
            indian[i]       = Double.parseDouble(input[6]);     // Assigning array indian to input[6]
            hawaiian[i]     = Double.parseDouble(input[7]);     // Assigning array hawaiian to input[7]
            more[i]         = Double.parseDouble(input[8]);     // Assigning array more to input[8]
            alien[i]        = Double.parseDouble(input[9]);     // Assigning array alien to input[9]
            unidentified[i] = Double.parseDouble(input[10]);    // Assigning array unidentified input[10]
            i++;
        }

        /**************************************************************************
         * Assigning findHighest and findAverage methods to variables and calling
         * displayData using those variables.
         *************************************************************************/
        String highest = findHighest(institution,white);
        double average = findAverage(white);
        displayData("White",highest,average,out);

        highest = findHighest(institution,black);
        average = findAverage(black);
        displayData("Black/African American",highest,average,out);

        highest = findHighest(institution,hispanic);
        average = findAverage(hispanic);
        displayData("Hispanic",highest,average,out);

        highest = findHighest(institution,asian);
        average = findAverage(asian);
        displayData("Asian",highest,average,out);

        highest = findHighest(institution,indian);
        average = findAverage(indian);
        displayData("American Indian or Alaska Native",highest,average,out);

        highest = findHighest(institution,hawaiian);
        average = findAverage(hawaiian);
        displayData("Native Hawaiian or other Pacific Islander",highest,average,out);

        highest = findHighest(institution,more);
        average = findAverage(more);
        displayData("students who associate with two or more classifications",highest,average,out);

        highest = findHighest(institution,alien);
        average = findAverage(alien);
        displayData("non resident/alien",highest,average,out);

        highest = findHighest(institution,unidentified);
        average = findAverage(unidentified);
        displayData("unidentified",highest,average,out);

        in.close();
        out.close();
    }

    /**************************************************************************
     * findHighest combs through the arrays to find the highest percentage of
     * each nationality.
     *************************************************************************/
    public static String findHighest(String[] institution, double[] data) {
        String highest;
        int i = 0;
        int current = 0;

        while (i < data.length) {
            if (data[i] > data[current]) {
                current = i;
            }

            i++;
        }

        highest=institution[current];
        return highest;
    }

    /**************************************************************************
     * findAverage combs through the arrays to find the perecentage of students
     * of each nationality.
     *************************************************************************/
    public static double findAverage(double[] data) {
        double average = 0;
        int i = 0;

        while (i < data.length) {
            average = average + data[i];
            i++;
        }

        average = average / data.length;
        return average;
    }

    /**************************************************************************
     * displayData prints the results to the output file.
     *************************************************************************/
    public static void displayData(String text, String highest, double average, PrintWriter out) {
        out.println("The institution with the highest " + text + " population is: ");
        out.println(highest + " and the average " + text);
        out.print("population is: ");
        out.printf("%.2f\n",average);
        out.print("\n");
    }
}
