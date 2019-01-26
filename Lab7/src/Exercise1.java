import java.util.Scanner;

/**
 * Created by Keenan on 2/18/2017.
 */
public class Exercise1
{
    public static void main(String[] args) {
        String menu = "enter the letter corresponding to your favorite color:\n";
        menu += "   G for green\n";
        menu += "   R for red\n";
        menu += "   b for blue\n";
        menu += "   O for orange\n";
        menu += "   Y for yellow\n";
        menu += "   P for purple\n";

        Scanner keyin = new Scanner(System.in);
        System.out.println(menu);
        char input = keyin.next().charAt(0);
        String results = "";
        switch(input) {
            case 'G':
                results = "You have entered Green\n";
                break;
            case 'R':
                results = "You have entered Red\n";
                break;
            case 'B':
                results = "You have entered Blue\n";
                break;
            case 'O':
                results = "You have entered Orange\n";
                break;
            case 'Y':
                results = "You have entered Yellow\n";
                break;
            case 'P':
                results = "You have entered Purple\n";
                break;
        }
        System.out.println(results);

    }
}
