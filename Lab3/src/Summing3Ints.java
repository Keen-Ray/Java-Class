/**
 * This program will calculate the average, and product of three four digit numbers.
 *
 * Athor:       Keenan Rhea
 * Last edit 1/26/17
 */
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Scanner;
public class Summing3Ints {
    public static void main(String[] args) {
        System.out.println("This program will calculate the average and product of three four digit numbers");
        // get the numbers from the user
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the first 4-digit number: ");
        int num1 = sc.nextInt();
        System.out.print("Enter the second 4-digit number: ");
        int num2 = sc.nextInt();
        System.out.print("Enter the third 4-digit number: ");
        int num3 = sc.nextInt();
        // add the numbers together and print out the average
        int product = num1 + num2 + num3;
        System.out.println(" " + num1);
        System.out.println(" " + num2);
        System.out.println("+" + num3);
        System.out.println("-----");
        System.out.println(product);
        // find the average
        double average = (double)product/3;
        // round the average
        DecimalFormat df = new DecimalFormat("#.##");
        //print the average
        System.out.println("\n" + "the average is: " + df.format(average));
        System.out.println("Program Terminating");
        sc.close();




    }
}
