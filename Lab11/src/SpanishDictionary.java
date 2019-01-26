import java.io.*;
import java.util.Scanner;

/**
 * This program will take an English word and give you a Spanish words.
 * Created by keenan on 3/29/17.
 * Last edited on 3/29/17
 */
public class SpanishDictionary {
    public static void main(String[] args) throws Exception {
        char stopper = 'Q';
        //open the file for reading
        final String FILENAME = "/home/keenan/IdeaProjects/Lab11/src/spanishDictionary.csv";
        File inFile = new File(FILENAME);

        //print out the intro
        String intro = "This program will take an English word and give you a Spanish words.\n";
        intro += "----------------------------------------------------------\n";
        intro += "Please enter the word you wish to have translated (or q to quit): ";
        System.out.print(intro);

        //get the users input
        Scanner inKey = new Scanner(System.in);
        String inputtedEnglishWord = inKey.nextLine();

        //declare some variables needed for the loop
        String dicEnglishWord, spanishWord = "", output;
        Boolean spanishWordFound;

        //continue until the user enter q
        while(isEqualTo(stopper, inputtedEnglishWord)) {
            //reopen the file to start at the top
            Scanner fileReader = new Scanner(inFile);

            //this will be changed to true if the inner loop find the wanted value in the input file
            spanishWordFound = Boolean.FALSE;

            //this loop searches through the entire file or until it finds the English word inputted
            while(fileReader.hasNext()) {
                //read the current english word from the file
                dicEnglishWord = fileReader.next();
                // check the current word and see if it matches the inputted word
                if (dicEnglishWord.toUpperCase().equals(inputtedEnglishWord.toUpperCase())) {
                    //get the corresponding spanish word from the file
                    spanishWord = fileReader.next();
                    //tell the outer loop that the word has been found
                    spanishWordFound = Boolean.TRUE;
                    break;
                } else {
                    //skip the current spanish word
                    fileReader.next();
                }
            }
            //if the word inputted was found in the dictionary
            if(spanishWordFound) {
                output = "\nThe English word " + inputtedEnglishWord.toLowerCase() + " is the word " + spanishWord +
                        " in Spanish\n\n";
                output += "Please enter the next word you wish to have translated (or q to quit): ";
            }else {
                output = "\n Sorry, the inputted word could not be found.\n\n";
                output += "Please enter a different word you wish to have translated (or q to quit): ";
            }
            System.out.print(output);

            //Close the file
            fileReader.close();
            //get the users next input
            inputtedEnglishWord = inKey.nextLine();
        }
        System.out.print("The program has been terminated.\n");
    }
    public static boolean isEqualTo(char stopper, String input) {
        if(input.length() == 1 && input.toUpperCase().charAt(0) == stopper) {
            return Boolean.FALSE;
        } else {
            return Boolean.TRUE;
        }
    }

}
