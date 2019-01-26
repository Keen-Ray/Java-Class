import java.text.DecimalFormat;
import java.util.Scanner;

/*
 * Created by Keenan
 * Last modified on 2/16/17
 * This program uses a position code, the number of years worked,
 * and the weekly salary to calculate the bonus for an employee.
 *
 */
public class BonusCalculator {
    public static void main(String[] args) {
        //Set the maximum amount of salary based bonus that can be given with a position code of 2
        int maxBaseBonus = 700;

        //print the Welcome
        System.out.println("Welcome, this program will help you determine what your bonus will be or if you are one"
                + " of our employees. \nPlease just follow the prompts and enter the values you are asked for.");
        System.out.println("---------------------------------------------------------------------------");

        //get the three numbers needed.
        Scanner keyIn = new Scanner(System.in);
        System.out.println("1. What is the position code your boss has assigned you? (1, 2 or 3)");
        int code = keyIn.nextInt();
        System.out.println("2. What is your weekly Salary? (example: 500)");
        int salary = keyIn.nextInt();
        System.out.println("3. How long, in years, have you worked for us? (example: 1.75)");
        double years = keyIn.nextDouble();

        //figure out the base bonus amount from the weekly salary and position code
        double bonus;
        if(code == 1) {
            bonus = salary;
        }else if(code == 2) {
            bonus = salary*2l;
            if(bonus > maxBaseBonus)
                bonus = maxBaseBonus;
        }else if(code == 3){
            bonus = salary*1.5;
        }else {
            System.out.println("ERROR: Please restart and enter a valid code.");
            bonus = -1;
        }

        //figure out the final bonus from the base bonus and the amount of year the employ worked
        if(years < 2) {
            bonus /= 2;
        }else if(years > 10) {
            bonus += 100;
        }
        // round the bonus to the nearest dollar and add a dollar sign
        DecimalFormat rounder = new DecimalFormat("$0");
        String roundedBonus = rounder.format(bonus);
        //print the final message
        System.out.println("\n-------------------------");
        System.out.println("|Your bonus will be ".toUpperCase() + roundedBonus + "|");
        System.out.println("-------------------------");
    }
}
