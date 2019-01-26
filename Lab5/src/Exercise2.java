import java.util.Scanner;

/**
 * Created by Keenan on 2/4/2017.
 */
public class Exercise2 {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please enter a positive integer: ");
        int num = keyboard.nextInt();
        if(num % 2 == 0) {
            System.out.println(num + " is even");
        }else {
            System.out.println(num + " is odd");
        }
    }
}
