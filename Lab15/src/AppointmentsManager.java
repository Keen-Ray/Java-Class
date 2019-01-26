import java.util.Scanner;
/**
 * Created by keenan on 4/26/17.
 * Last edited 4/26/17
 * This program keeps track of appointments. The two arrays at the top of the program are parallel.
 * One contains the time in an integer form and the other contains a description of the appointments.
 * For example the time 12:00 pm in integer form would be -12 or 1:00 would be 1 ect.
 * Finally the methods have been sorted by category the general methods come first.
 * These are methods that are called by methods only
 * The Specific methods are second. These are methods that are only called by the main method.
 */
public class AppointmentsManager {
    //these are the two parallel arrays that hold the appointment information
    public static int[] appointmentTimes = new int[24];
    public static String[] appointmentDescription = new String[24];
    //this method introduces the program
    //GENERAL METHODS
    //this method takes a string that contains the time like 1:00p and converts it to an integer
    public static int timeToInt(String time) {
        //get the hour in the string
        int numTime = Character.getNumericValue(time.charAt(0));
        if(time.charAt(1) != ':') { // if this time has two digits
            numTime += 9 +Character.getNumericValue(time.charAt(1)); //add the second digit
            //the nine is there to make the 1 that preceds the second digit equal to 10
        }
        // if the time is PM make the integer negative
        if(time.indexOf('p') > 0) // if there is a p in the time assume it is pm
            numTime = -numTime;
        return numTime;
    }
    //this method finds the index in the array based on a intager that represents the time
    public static int getIndexOfTime(int time) {
        //if the number is positive (meaning AM)
        if(time > 0) {
            if(time == 12) //12:00 am comes before 1 so I need to tell it that
                return 0;
            return time; //the index is just the time
        }else {
            if (time == -12) { //12 pm comes before the rest of the pms
                return 12;
            }
            return Math.abs(time) + 12;
        }
    }
    //SPECIFIC METHODS
    public static void greeting() {
        String intro = "This program will help you manage your appointments.\n";
        intro += "It will only manage appointments that are on the hours, though.\n";
        intro += "---------------------------------------------------------\n";
        System.out.print(intro);
    }
    //this method fills the arrays with empty data
    public static void fillArrays(){
        for(int index = 0; index < appointmentTimes.length; index++) {
            appointmentTimes[index] = 0;
            appointmentDescription[index] = "";
        }
    }
    //this displays a menu and returns the users choice out of that menu
    public static int getUsersChoice() {
        //display a menu
        String prompt = "To add an appointment enter 1.\n";
        prompt += "To delete an appointment enter 2.\n";
        prompt += "To print the appointments enter 3.\n";
        prompt += "To exit the program enter 4: ";
        System.out.print(prompt);

        //get the user's input
        Scanner inKey = new Scanner(System.in);
        return inKey.nextInt();
    }
    //this method adds an appointment to the two public arrays with the information enter by the user
    public static void addAppointment() {
        //get the time of the appointment
        Scanner inKey = new Scanner(System.in);
        String prompt = "Please enter the time of the appointment you wish to add (1:00p): ";
        System.out.print(prompt);
        int time = timeToInt(inKey.next());

        //get the name of the person that the appointment is for
        prompt = "Please enter the first and last names of person the appointment is with: ";
        System.out.print(prompt);
        inKey.nextLine(); //get rid of the last /n character
        String description = inKey.nextLine()+"\n";

        //get the description of the appointment
        prompt = "Please enter a few words describing the appointment: ";
        System.out.print(prompt);
        description += "       |" + inKey.nextLine(); // the space an bar help it to like up in the printing

        //write the description and time to the array
        int index = getIndexOfTime(time);
        appointmentTimes[index] = time;
        appointmentDescription[index] = description;

        //tell the user that the appointment has been added
        prompt = "The appointment has been added.\n";
        prompt += "----------------------------------\n";
        System.out.print(prompt);
    }

    //this method helps the user delete an appointment
    public static void deleteAppointment() {
        //get the index of the appoint he wishes to delete
        String prompt = "Please enter the time of the appointment you wish to delete (1:00p): ";
        System.out.print(prompt);
        Scanner inKey = new Scanner(System.in);
        int index = getIndexOfTime(timeToInt(inKey.next()));

        //erase the data in that location
        appointmentDescription[index] = "";
        appointmentTimes[index] = 0;

        //tell the user the appointment has been deleted
        prompt = "The appointment has been deleted\n";
        prompt += "----------------------------------\n";
        System.out.print(prompt);

    }
    // this method prints all the arrays
    public static void printAppointments() {
        //First make the headers
        String divider = "----------------------\n";
        String row ="\nTime   |Description \n" + divider;
        System.out.print(row);

        //Now compile print out row by row
        for(int index = 0; index < appointmentTimes.length; index++) { //loop through every hour
            if(appointmentTimes[index] != 0) {//if this hour has an appointment
                row = String.format("%6s |%s\n",
                        getHumanTime(appointmentTimes[index]), appointmentDescription[index]);
                row += divider; //compile a row
                System.out.print(row);
            }
        }
    }
    //this method takes an integer that represents the time and returns a human readable time
    public static String getHumanTime(int time) {
        String humanTime;
        if(time < 0)
            humanTime = Math.abs(time) + ":00p";
        else
            humanTime = time + ":00";
        return humanTime;
    }
    public static void main(String[] args) {
        //get set up
        greeting();
        fillArrays(); // this fills the arrays with empty data so that no error happens when they are read
        //run the actual program
        int usersChoice;
        do {
            usersChoice = getUsersChoice();
            switch (usersChoice) {
                case 1:
                    addAppointment();
                    break;
                case 2:
                    deleteAppointment();
                    break;
                case 3:
                    printAppointments();
                    break;
                default:
                    usersChoice = 4;
                    System.out.print("\nProgram Terminating!\n");
                    break;
            }
        } while (usersChoice != 4);
    }
}
