import java.util.Scanner;

/**
 * Created by Keenan on 3/4/2017.
 */
public class CollectingDataDemo {
    public static void main(String[] args) {
        String greeting = "You are throwing a party and want to invite all your friends.\n\n" +
                "This program will ask you to enter the names of all your friends \n" +
                "and will then display the list after the entry is complete.\n";
        System.out.println(greeting);

        String friendNames = "";
        String input = "";
        String enterPrompt = "Enter the name of the friends you would like\n" +
                "to invite to your party (enter Q to display final list)\n";

        System.out.println(enterPrompt);

        Scanner keyboard = new Scanner(System.in);

        // set to negative one because the loop runs once before
        int friendCounter = -1;

        //  Loop to enter friends names
        do {
            input = keyboard.nextLine();
            friendNames += input + "\n";
            friendCounter++;

        } while (!input.toUpperCase().equals("Q"));

        //  WHAT IS THE PURPOSE OF THIS LINE OF CODE ????
        //  If you do not know, comment it out and run the program again and
        //  Compare the results.  You might need to compare this several
        //  times, by commenting this line in and out.
        friendNames = friendNames.substring(0, friendNames.length() - 2);

        String results = "You have added " + friendCounter + " friends to the list"
                + "\nThe list is as follows:\n\n" + friendNames + "\n" + "Party on!!\n";
        System.out.println(results);
    }

}
