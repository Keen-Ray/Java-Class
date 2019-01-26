import java.util.Scanner;

/**
 * Created by Keenan on 1/28/2017.
 * This Program takes a four digit number and calculates the sum of its digits.
 */
public class SummingDigits {
    public static void main(String[] args) {
        // print the intro and the prompt
        System.out.println("This Program takes a four digit number and calculates the sum of its digits.");
        System.out.print("Please Enter a 4 digit number: ");
        // get the number the user entered as a string
        Scanner inKey = new Scanner(System.in);
        String number = inKey.nextLine();
        //break up the string into each separate digit by taking each character anc converting to an int.
        int firstDigit = Character.getNumericValue(number.charAt(0));
        int secondDigit = Character.getNumericValue(number.charAt(1));
        int thirdDigit = Character.getNumericValue(number.charAt(2));
        int fourthDigit = Character.getNumericValue(number.charAt(3));
        // sum up the numbers.
        int sum = firstDigit + secondDigit + thirdDigit + fourthDigit;
        //print out the output
        System.out.println("The sum of the digits of the number " + number + " is " + firstDigit + " + "
                + secondDigit + " + " + thirdDigit + " + " + fourthDigit + " = " + sum);
    }
}
