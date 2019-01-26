import java.util.Random;
import java.util.Scanner;

/**
 * This Program lets you play rock, paper, scissors with your computer through the console.
 * Created by Keenan Rhea
 * Last edited on 4/6/17
 */
public class RPS_Game {
    public static String stop = "quit"; // the string that is assigned when the user enter q
    public static void main(String[] args) {
        //tell the user what is going on.
        greeting();
        int numOfGames = 3; //the number of games before a summary is shown

        //variables used in the inner loop
        int numOfTiedGames = 0, numOfCompWon = 0, numOfUserWon = 0;
        //These are all pre-made strings to add to the results
        String userWon = "You win!\n\n", compWon = "You lose!\n\n", tie = "That's a tie.\nSorry, no one wins!\n\n";
        String RtoP = "Paper wraps rock!\n", RtoS = "Rock crushes scissors!\n",
                StoP = "Scissors cut paper!\n";
        //These are just so I don't have to hard code the if statments
        String rock = "rock", paper = "paper"; //there is no need for paper as it is always in the else statement
        //these hold the input and the output of the inner loop
        String usersSelection = stop, computerSelection, result;
        // these are used in the outer loop
        String results;
        int gamesCounter = 1; // keeps track of the games played

        do {
            for (int gameNum = 1; gameNum <= numOfGames; gameNum++) {
                result = ""; //A string to keep track of who won
                //get the  two choices
                usersSelection = expandToFullWord(enterPlayersChoice(gamesCounter));
                computerSelection = expandToFullWord(generateComputersChoice());

                //break out the inner loop and go directaly to the outer loop when the user decides to quit
                if(usersSelection.equals(stop))
                    break;
                //tell the rest of the program that another round has been played
                gamesCounter++;

                //add first few lines the the results
                result += "For game #" + gameNum + "\n";
                result += "You played '" + usersSelection + "' and ";
                result += "the computer played '" + computerSelection + "'\n";

                //find out who won
                if (computerSelection.equals(rock)) {
                    if (usersSelection.equals(rock)) {
                        result += tie;
                        numOfTiedGames++;

                    } else if (usersSelection.equals(paper)) {
                        result += RtoP + userWon;
                        numOfUserWon++;
                    } else {
                        result += RtoS + compWon;
                        numOfCompWon++;
                    }
                } else if (computerSelection.equals(paper)) {
                    if (usersSelection.equals(rock)) {
                        result += RtoP + compWon;
                        numOfCompWon++;
                    } else if (usersSelection.equals(paper)) {
                        result += tie;
                        numOfTiedGames++;
                    } else {
                        result += StoP + userWon;
                        numOfUserWon++;
                    }
                } else {
                    if (usersSelection.equals(rock)) {
                        result += RtoS + userWon;
                        numOfUserWon++;
                    } else if (usersSelection.equals(paper)) {
                        result += StoP + compWon;
                        numOfCompWon++;
                    } else {
                        result += tie;
                        numOfTiedGames++;
                    }
                }
                //add a pretty line to separate games
                result += "----------------------------------------------------\n";
                //print out a summary of this game and go to the next
                System.out.print(result);

            }
            //make a string representing the final totals
            results = "-------------------------------------\n";
            results += "|For a total of " + gamesCounter + " game(s),          |\n";
            results += "|There was " + numOfTiedGames + " tie(s)                 |\n";
            results += "|There was " + numOfUserWon + " win(s) for you         |\n";
            results += "|There was " + numOfCompWon + " win(s) for the computer|\n";
            results += "-------------------------------------\n";
            //print the string
            System.out.print(results);
        }while(!usersSelection.equals(stop));
    }
    public static void greeting() {
        // This method explains the program to the user
        String greeting = "This program lets you play rock paper scissors with your computer.\n";
        greeting += "Then the computer will tell you the score tally at the end of every three games.\n";
        greeting += "----------------------------------------------------------------------\n";
        System.out.print(greeting);
    }
    public static char enterPlayersChoice(int gameNumber) {
        // This method gets the users choice of rock paper or scissors.
        // First ask the user for their input
        String prompt = "Please enter your selection for game #" + gameNumber + ".\n";
        prompt += "Enter:\n";
        prompt += "\t'R' for rock,\n";
        prompt += "\t'P' for paper,\n";
        prompt += "\t'S' for scissors (or Q to stop): ";
        System.out.print(prompt);

        // get the users input
        Scanner inKey = new Scanner(System.in);
        char selection = inKey.nextLine().toUpperCase().charAt(0);

        //print a line just to make things pretty
        String line = "----------------------------------------------------\n";
        System.out.print(line);
        return selection;
    }
    public static char generateComputersChoice() {
        //This method decides if the computer will play Rock, Paper, or Scissors
        //first get a Random number to help us decide what our decision will be
        Random randomGenerator = new Random();
        int selector = randomGenerator.nextInt(119)+1;//the one excludes the possibility of a 0

        //Make the decision based on the number
        char choice;
        if(selector <= 40)
            choice = 'S';
        else if(selector < 80)
            choice = 'R';
        else
            choice = 'P';

        return choice;
    }
    public static String expandToFullWord(char character) {
        //this method expands a character to it's full string value
        String fullWord;
        switch (character) {
            case 'S': fullWord = "scissors";
                break;
            case 'R': fullWord = "rock";
                break;
            case 'Q': fullWord = stop;
                break;
            default: fullWord = "paper";
                break;
        }
        return fullWord;
    }

}
