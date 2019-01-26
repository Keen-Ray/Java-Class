/*
 * Keenan Rhea
 * This program gets an array of numbers from an input file (specified by the user).
 * Then calculates the average and standard deviation for those numbers.
 * Last Edited on 4/13/17
 */

import java.util.*;
import java.io.*;

public class STDcalculator {

    /**
     * This method loads an array of decimal numbers from a file
     * @param fileName the file name containing decimal numbers, one per line
     * @return returns and array of doubles contained in file
     * @throws Exception associated with IO:  FileNotFound or IO exceptions
     */
    public static double[] loadNumberFromFile(String fileName) throws Exception
    {
        File inFile = new File(fileName);
        Scanner inScan = new Scanner(inFile);
        double [] numbers = new double[100];
        int numberCounter = 0;
        while(inScan.hasNext())
        {
            numbers[numberCounter] = inScan.nextDouble();
            numberCounter++;
        }
        inScan.close();
        return numbers;
    }

    /**
     * This method takes an array of double and returns the average
     * @param numbers array of numbers
     * @return average of array taken as argument
     */
    public static double averageNumbers(double[] numbers)
    {
        double sum = 0;
        for(int dex =0; dex < numbers.length; dex++)
        {
            sum += numbers[dex];
        }
        return sum/numbers.length;
    }
    /**
     * This method takes an array of doubles and returns the standard deviation of the array
     * @param values array of numbers
     * @return the standard deviation of the numbers in the array
     */
    public static double calculateSTD (double[] values) {
        //variables needed in the loop
        double mean = averageNumbers(values);
        double numerator = 0; //holds the sum of the squared differences which is the numerator in the top
        // this calculates the value of the number in the numerator in the formula for standard deviation
        for(double currentNum : values) {
            numerator += Math.pow(currentNum-mean, 2);
        }
        //finish out the formula
        double STD = Math.sqrt(numerator/values.length);
        return STD;
    }

    public static String enterFileName()
    {
        //The scope of this scanner object is only within this method
        Scanner keyboard = new Scanner(System.in);

        String prompt = "Enter the filename for file\ncontaining decimal numbers!";
        System.out.println(prompt);

        String fName = keyboard.nextLine();

        return fName;
    }

    /**
     * This method displays an introduction to the program
     */
    public static void displayGreeting()
    {
        String greeting = "This program will calculate the average of numbers\n"+
                "loaded from a file containing one decimal number per line.\n"+
                "First you will be asked to enter the file name, then\n"+
                "the average will be displayed.\n";
        System.out.println(greeting);
    }

    public static void main(String[] args) throws Exception
    {
        displayGreeting();
        String numberFileName = enterFileName();
        double[] decNumbers = loadNumberFromFile(numberFileName);
        double numAverage = averageNumbers(decNumbers);
        double standardDeviation = calculateSTD(decNumbers);

        String results = String.format("The average of the numbers in file: %s\n" +
                "is %.3f and the standard deviation: %.3f" +
                "\n\nProgram terminating.", numberFileName, numAverage, standardDeviation);

        System.out.println(results);
    }
}
