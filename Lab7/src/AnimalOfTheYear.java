import java.util.Scanner;

/**
 * Created by Keenan on 2/18/2017.
 * Lasted Edited on 2/18/17
 * This program will take a year and return the zodiac animal associated with that year
 */
public class AnimalOfTheYear {
    public static void main(String[] args) {
        //Print the intro
        String intro = "Welcome, This program will take a year"
                + "and return the zodiac animal associated with that year\n";
        intro += "---------------------------------------------------------------\n";
        intro += "Please, enter the year you wish to evaluate. (example: 2014)";
        System.out.println(intro);

        //Get the users entered
        Scanner keyin = new Scanner(System.in);
        int year = keyin.nextInt();


        //this formula relates the number of the year to codes used in the switch statements
        int yearCode = (year-4)%12;
        //create a necessary variable
        String animal;

        //Figures out the animal associated with the code calculated above
        switch (yearCode) {
            case 0:
                animal = "Rat";
                break;
            case 1:
                animal = "Ox";
                break;
            case 2:
                animal = "Tiger";
                break;
            case 3:
                animal = "Rabbit";
                break;
            case 4:
                animal = "Dragon";
                break;
            case 5:
                animal = "Snake";
                break;
            case 6:
                animal = "Horse";
                break;
            case 7:
                animal = "Sheep";
                break;
            case 8:
                animal = "Monkey";
                break;
            case 9:
                animal = "Rooster";
                break;
            case 10:
                animal = "Dog";
                break;
            case 11:
                animal = "Pig";
                break;
            default:
                animal = "ERROR";
        }

        //Results print statement
        System.out.println("\nYou have selected the year of the " + animal + ".");



    }
}
