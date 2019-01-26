import java.util.Scanner;

/**
 * Created by Keenan on 2/25/2017.
 */
public class Loops {
    public static void main(String[] args) {
        //get input
        Scanner inKey = new Scanner(System.in);
        System.out.println("Please enter the number of people.");
        long people = inKey.nextLong();
        System.out.println("Please enter the number of slots per team");
        long slots = inKey.nextLong();
        // call method
        long options = combination_possiblities(people, slots);
        System.out.print(options);
    }
    public static long combination_possiblities(long numOfPeople, long numPerTeam) {
        long numerator = factorial(numOfPeople);
        long denominator = factorial(numPerTeam) * factorial((numOfPeople-numPerTeam));
        long numOfOptions = numerator/denominator;
        return numOfOptions;
    }
    public static long factorial(long num) {
        long counter = 1;
        long originalNum = num;
        while(counter < originalNum) {
            num = num * counter;
            counter ++;
        }
        return num;
    }
}
