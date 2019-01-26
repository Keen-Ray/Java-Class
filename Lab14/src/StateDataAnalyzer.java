import java.io.*;
import java.util.*;

/*
Created By Keenan Rhea
On 4/16/17
Last Edited 4/16/17
This program uses the data found in the file
State_Data.csv to give the user the state associated with one of the six options below.
1. The state with maximum land mass
2. The state with minimum land mass
3. The state with maximum population
4. The state with minimum population
5. The state with maximum average income
6. The state with minimum average income
 */
public class StateDataAnalyzer {

    private static int NUMBER_STATES = 50;

    public static String[] loadNamesFromFile(String fileName) throws Exception {
        File file = new File(fileName);
        String[] array = new String[NUMBER_STATES];

        Scanner fileScan = new Scanner(file);
        for(int row = 0; row < NUMBER_STATES; row++)
        {
            array[row] = fileScan.next();
            fileScan.nextLine();
        }
        return array;
    }

    public static double[] loadPercapitaFromFile(String fileName) throws Exception {
        File file = new File(fileName);
        double[] array = new double[NUMBER_STATES];

        Scanner fileScan = new Scanner(file);
        for(int row = 0; row < NUMBER_STATES; row++)
        {   fileScan.next();
            array[row] = fileScan.nextDouble();
            fileScan.nextLine();
        }
        return array;
    }

    public static double[] loadPopulationFromFile(String fileName) throws Exception {
        File file = new File(fileName);
        double[] array = new double[NUMBER_STATES];

        Scanner fileScan = new Scanner(file);
        for(int row = 0; row < NUMBER_STATES; row++)
        {   fileScan.next();
            fileScan.next();
            array[row] = fileScan.nextDouble();
            fileScan.nextLine();
        }
        return array;
    }


    public static double[] loadLandSizeFromFile(String fileName) throws Exception {
        File file = new File(fileName);
        double[] array = new double[NUMBER_STATES];

        Scanner fileScan = new Scanner(file);
        for(int row = 0; row < NUMBER_STATES; row++)
        {   fileScan.next();
            fileScan.next();
            fileScan.next();
            array[row] = fileScan.nextDouble();
        }
        return array;
    }
    //this method will take an array of numbers and return the index of the largest number in the array
    public static int findMaxIndex(double[] array) {
        int maxIndex = 0; //this keeps track of the index of the largest number seen so far
        double largestNum = array[0]; //this keeps track of the largest number seen so far
        for(int i = 0; i < array.length; i++) {
            if(largestNum < array[i]) { //if this is bigger than the largest num seen so far
                maxIndex = i;
                largestNum = array[i];
            }
        }
        return maxIndex;
    }
    //this method will take an array of numbers and return the index of the smallest number in the array
    public static int findMinIndex(double[] array) {
        int minIndex = 0; //this keeps track of the index of the smallest number seen so far
        double smallestNum = array[0]; //this keeps track of the smallest number seen so far
        for(int i = 0; i < array.length; i++) {
            if(smallestNum > array[i]) { //if the current item is smaller than the smallest num seen so far
                minIndex = i;
                smallestNum = array[i];
            }
        }
        return minIndex;
    }
    //this method introduces the program
    public static void displayGreeting() {
        String intro = "This program will use the file State_Data.csv to find the state with the particular characteristic \n" +
                "that you choose below\n";
        intro += "----------------------------------------------------------------------\n";
        System.out.print(intro);
    }
    public static int getUsersOption() {
        //tell the user what is going on
        String prompt = "The Program can find the following States for you:\n";
        prompt += "1. The state with maximum land mass\n" +
                  "2. The state with minimum land mass\n" +
                  "3. The state with maximum population\n" +
                  "4. The state with minimum population\n" +
                  "5. The state with maximum average income\n" +
                  "6. The state with minimum average income\n" +
                  "7. Enter 7 to Quit\n";
        prompt += "Please enter the number for the state you wish to find: ";
        System.out.print(prompt);

        //get the users input
        Scanner inKey = new Scanner(System.in);
        return inKey.nextInt();
    }

    public static void main(String[] args) throws Exception {
        //Start off the program
        displayGreeting();
        String fileName = "State_Data.csv";
        String terMessage = "\nStop value entered " +
                "\nProgram Terminating!\n";

        //get the values from the file
        String[] stateNames    = loadNamesFromFile(fileName);
        double[] percapitaData = loadPercapitaFromFile(fileName);
        double[] populationData   = loadPopulationFromFile(fileName);
        double[] landSizeData  = loadLandSizeFromFile(fileName);

        //variables used in the loop
        int usersOption = getUsersOption(),
                index = 0;
        String fullOption = "", // this holds the human readable type of data that the user picked user picked
                result; //this holds the output that the user reads

        if(usersOption == 7)//make sure the user hasn't already terminated
            System.out.print(terMessage);

        while(usersOption != 7) { //stop it the user enter 7
            switch (usersOption) { //find the index of the state that the user is looking for
                case 1:
                    index = findMaxIndex(landSizeData);
                    fullOption = "maximum land mass";
                    break;
                case 2:
                    index = findMinIndex(landSizeData);
                    fullOption = "minimum land mass";
                    break;
                case 3:
                    index = findMaxIndex(populationData);
                    fullOption = "maximum population";
                    break;
                case 4:
                    index = findMinIndex(populationData);
                    fullOption = "minimum population";
                    break;
                case 5:
                    index = findMaxIndex(percapitaData);
                    fullOption = "maximum average income";
                    break;
                case 6:
                    index = findMinIndex(percapitaData);
                    fullOption = "minimum average income";
                    break;
                default:
                    System.err.print("ERROR!!!!");
            }
            result =  "---------------------------------------------------------------------\n";
            result += "The state with the " + fullOption + " is " + stateNames[index] + ".\n";
            result += String.format("Land Mass: %s Population: %s Average Income: %s \n",
                    landSizeData[index], populationData[index], percapitaData[index]);
            result +=  "---------------------------------------------------------------------\n";
            System.out.print(result);
            usersOption = getUsersOption();

            if(usersOption == 7)//make sure the user hasn't already terminated
                System.out.print(terMessage);
        }

    }

}
