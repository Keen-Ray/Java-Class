import java.util.Scanner;

/**
 * Created by Keenan on 2/4/2017.
 * Last edited on 2/9/16
 * This program uses data, supplied by the user, to help them fig
 * -ure out what time and day they want to have their doctors appointment.
 */
public class AppointmentScheduler {
    public static void main(String[] args) {

        //Setup
        Scanner inKey = new Scanner(System.in);

        //pick the day
        System.out.println("This program will help you schedule your doctors appointment.");
        System.out.println("For your next visit to our office, would you prefer Monday or Friday?");
        System.out.println("For Monday enter 'm'");
        System.out.println("For Friday, enter 'f'");
        String day = inKey.nextLine();
        //write out the full day based on the letter inputted.
        if(day.equals("m")) {
            day = "Monday";
        }else {
            day = "Friday";
        }

        //figure out the general time the want to have their appointment
        System.out.println("On " + day + ", would you prefer the morning or afternoon?");
        System.out.println("For morning, enter 'm'");
        System.out.println("For afternoon, enter 'a'");
        String genTimeOfDay = inKey.nextLine(); // gen stands for general

        // Based on the general time they picked give them a choice of specific hours
        String time, timeRange;
        if(genTimeOfDay.equals("m")) {
            genTimeOfDay = "morning";
            timeRange = " 8:00am and 11:00am,";
        }else {
            genTimeOfDay = "afternoon";
            timeRange = " 1:00pm to 4:00pm,";
        }
        System.out.println("On " + day + " " + genTimeOfDay
                + " between" + timeRange + "what time would you like?");
        time = inKey.nextLine();
        // final line
        System.out.println("Your next appointment is on " + day + " " + genTimeOfDay + " at " + time);
    }
}
