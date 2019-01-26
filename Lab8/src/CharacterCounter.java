import java.util.Scanner;

/**
 * Created by Keenan on 2/25/2017.
 * Last edited 3/2/17
 * This program counts the number of time a character (proved by the user) occurs in a statement inputted by the user.
 */
public class CharacterCounter {
    public static void main(String[] args) {
        //Introduce the program to the user
        String intro = "This program counts the number of times a character appears in the statement you input\n";
        intro += "--------------------------------------------------------------------------------------\n";
        intro += "Please enter the statement you wish to evaluate:\n";
        System.out.print(intro);

        //Get the users input statement
        Scanner inKey = new Scanner(System.in);
        String statement = inKey.nextLine();

        //Get the character the user wants to count
        String prompt2 = "Please enter the character you wish to count the recurrences of:\n";
        System.out.print(prompt2);
        char character = inKey.next().charAt(0);

        //count the number of occurrences
        int numOfAppearances = countChars(statement, character);
        //print the results
        printresults(numOfAppearances, statement, character);



    }

    public static int countChars(String input, char letter) {
        int length = input.length(); //find out how long the string is
        int counter = 0;
        int numOfOccurrences = 0;
        while(counter < length) { //for every character in the string (we could use a for loop)
            if(letter == input.charAt(counter))//check and see if it matches the input character
                numOfOccurrences += 1;//if it does count that as on occurrence
            counter += 1;
        }
        return numOfOccurrences;
    }
    public static void printresults(int charCount, String stringEntered, char character ) {
        String result = "---------------------------------------------------------------------------------------\n";
        result += "The character '" + character + "' appears " + charCount
                + " times in the statement below. \n";
        result += "\"" + stringEntered + "\"\n";
        System.out.print(result);
    }
}
