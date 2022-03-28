/**************************************************************************
 * Lab 5 - Phone Selection
 **************************************************************************
 * This program tells the user what digit on the telephone corresponds to
 * the letter that they inputted.
 * ________________________________________________________________________
 * William Tremaglio
 * 02.13.2019
 * CMSC 255 Section 004
 *************************************************************************/

import java.util.Scanner;

public class PhoneSelection {
	public static void main(String[] args) {
		
		/**************************************************************************
		 * Establishing the scanner and introducing the two variables that will
		 * be used throughout the code.
		 *************************************************************************/
		Scanner scnr = new Scanner (System.in);
		char userLetter;
		int phoneNumber;
		
		/**************************************************************************
		 * Collecting the user input.
		 *************************************************************************/
		System.out.print("Enter a single letter, and I will tell you what the corresponding digit is on the telephone:");
		userLetter = scnr.next().charAt(0);
		
		/**************************************************************************
		 * Checking to see if the user input corresponds with the digit 2.
		 *************************************************************************/
		if ((userLetter == 'a') || (userLetter == 'A') || (userLetter == 'b') || (userLetter == 'B') || (userLetter == 'c') || (userLetter == 'C')) {
			phoneNumber = 2;
			System.out.print("The digit " + phoneNumber + " corresponds to the letter " + userLetter + " on the telephone.");
		}
		
		/**************************************************************************
		 * Checking to see if the user input corresponds with the digit 3.
		 *************************************************************************/
		else if ((userLetter == 'd') || (userLetter == 'D') || (userLetter == 'e') || (userLetter == 'E') || (userLetter == 'f') || (userLetter == 'F')) {
			phoneNumber = 3;
			System.out.print("The digit " + phoneNumber + " corresponds to the letter " + userLetter + " on the telephone.");
		}
		
		/**************************************************************************
		 * Checking to see if the user input corresponds with the digit 4.
		 *************************************************************************/
		else if ((userLetter == 'g') || (userLetter == 'G') || (userLetter == 'h') || (userLetter == 'H') || (userLetter == 'i') || (userLetter == 'I')) {
			phoneNumber = 4;
			System.out.print("The digit " + phoneNumber + " corresponds to the letter " + userLetter + " on the telephone.");
		}
		
		/**************************************************************************
		 * Checking to see if the user input corresponds with the digit 5.
		 *************************************************************************/
		else if ((userLetter == 'j') || (userLetter == 'J') || (userLetter == 'k') || (userLetter == 'K') || (userLetter == 'l') || (userLetter == 'L')) {
			phoneNumber = 5;
			System.out.print("The digit " + phoneNumber + " corresponds to the letter " + userLetter + " on the telephone.");
		}
		
		/**************************************************************************
		 * Checking to see if the user input corresponds with the digit 6.
		 *************************************************************************/
		else if ((userLetter == 'm') || (userLetter == 'M') || (userLetter == 'n') || (userLetter == 'N') || (userLetter == 'o') || (userLetter == 'O')) {
			phoneNumber = 6;
			System.out.print("The digit " + phoneNumber + " corresponds to the letter " + userLetter + " on the telephone.");
		}
		
		/**************************************************************************
		 * Checking to see if the user input corresponds with the digit 7.
		 *************************************************************************/
		else if ((userLetter == 'p') || (userLetter == 'P') || (userLetter == 'q') || (userLetter == 'Q') || (userLetter == 'r') || (userLetter == 'R') || (userLetter == 's') || (userLetter == 'S')) {
			phoneNumber = 7;
			System.out.print("The digit " + phoneNumber + " corresponds to the letter " + userLetter + " on the telephone.");
		}
		
		/**************************************************************************
		 * Checking to see if the user input corresponds with the digit 8.
		 *************************************************************************/
		else if ((userLetter == 't') || (userLetter == 'T') || (userLetter == 'u') || (userLetter == 'U') || (userLetter == 'v') || (userLetter == 'V')) {
			phoneNumber = 8;
			System.out.print("The digit " + phoneNumber + " corresponds to the letter " + userLetter + " on the telephone.");
		}
		
		/**************************************************************************
		 * Checking to see if the user input corresponds with the digit 9.
		 *************************************************************************/
		else if ((userLetter == 'w') || (userLetter == 'W') || (userLetter == 'x') || (userLetter == 'X') || (userLetter == 'y') || (userLetter == 'Y') || (userLetter == 'z') || (userLetter == 'Z')) {
			phoneNumber = 9;
			System.out.print("The digit " + phoneNumber + " corresponds to the letter " + userLetter + " on the telephone.");
		}
		
		/**************************************************************************
		 * Error message for any user input that didn't fall into the above
		 * categories.
		 *************************************************************************/
		else {
			System.out.println("There is no matching digit for " + userLetter + ".");
		}
	}
}
