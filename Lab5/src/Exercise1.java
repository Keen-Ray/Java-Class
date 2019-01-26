/**
 * Created by Keenan on 2/4/2017.
 */
import java.util.Scanner;

public class Exercise1 {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        String ageStr, response1, response2;
        int age;

        String intro = "This program will ask about your \n" +
                "opinion on the importance of voting. \n" +
                "It will ask your age and than ask another question \n" +
                "if you are old enough to vote. ";
        String request = "Please enter your age in whole years.";
        String question1 = "Do you feel it is important to vote in political" +
                "elections?\n" + "Enter y for yes, and n for no";
        String question2 = "Did you vote in the last presidential election?";
        String farewell = "Thank you for your response(s)!";

        System.out.println(intro);
        System.out.println(request);
        ageStr = keyboard.nextLine();
        age = Integer.parseInt(ageStr);
        System.out.println(question1);
        response1 = keyboard.nextLine();

        if (age >= 18) {
            System.out.println(question2);
            response2 = keyboard.nextLine();
        }

        System.out.println(farewell);
    }
}
