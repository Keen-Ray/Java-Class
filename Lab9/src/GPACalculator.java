import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Created by Keenan on 3/4/2017.
 * This program Calculates a student's overall GPA from their credit hours and their credit hours.
 */
public class GPACalculator {
    public static void main(String[] args) {
        //introduce the program
        String intro = "This program calculates several students' overall GPAs from"
                + "their credit hours and their grades.\n";
        intro += "--------------------------------------------------\n";
        System.out.print(intro);

        //Create the needed variables for the loop
        //Prompts
        String gradePrompt = "Please enter grade of the course (enter Q to quit entering this students grades): ";
        String hoursPrompt = "Please enter the number of credit hours that course had: ";
        String namePrompt = "Please enter the students name (enter Q to quit and see results): ";
        //Scanner
        Scanner inKey = new Scanner(System.in);
        //Character to quit the loop with
        String stopper = "Q";
        //variables to hold the data the user enters
        String grade;
        double creditHours;
        //variables to hold the data made from the previous data
        String results = "";
        //a counter to keep track of the number of courses entered
        int counter = 1;
        while (true) {
            String reportTable = "";
            double totalGradePoints = 0;
            double totalCreditHours = 0;
            System.out.print(counter + ". " + namePrompt);
            String name = inKey.next();
            if(name.equals(stopper))
                break;
            while (true) {//loop runs until the user enters q
                //Get the input of the grade
                System.out.print(name + ": " + gradePrompt);
                grade = inKey.next().toUpperCase();
                if (grade.equals(stopper)) //stop the loop it q is entered
                    break;
                //Get the input of the credit hours
                System.out.print(name + ": " + hoursPrompt);
                creditHours = inKey.nextDouble();

                //add a line of information to the results table.
                reportTable += "|" + grade + "              " + creditHours + "|\n";
                //add the number of grade points that that course equals to the total grade points
                totalGradePoints += getGradePoint(grade) * creditHours;
                //add the credit hours the the total credit hours
                totalCreditHours += creditHours;
            }
            counter++;
            //take all the information gathered and . . .
            //calculate the GPA
            double GPA = calculateGPA(totalGradePoints, totalCreditHours);
            //print the resuslts
            results += getResults(reportTable, GPA, name);
        }
        System.out.print(results);


    }
    public static double calculateGPA(double gradePoints, double creditHours) {
        double result = gradePoints/creditHours;
        return result;
    }
    public static String getResults(String gradeAndHoursTable, double GPA, String name) {
        //Add necessary information to the table and print it
        String beforeTable = "The courses you entered for " + name + " are:\n";
        beforeTable += "------------------\n";
        beforeTable += "Grades       Hours\n";
        //print the pretty bar
        String afterTable = "----------------------------\n";
        //print the
        afterTable += String.format("Resulting in a GPA of %.1f\n", GPA);
        gradeAndHoursTable = beforeTable + gradeAndHoursTable + afterTable;
        return gradeAndHoursTable;

    }
    public static double getGradePoint(String letterGrade) {
        double gradePoint;
        /*
        switch (letterGrade) {
            case 'A':
                gradePoint = 4;
                break;
            case 'B':
                gradePoint = 3;
                break;
            case 'C':
                gradePoint = 2;
                break;
            case 'D':
                gradePoint = 1;
                break;
            case 'F':
                gradePoint = 0;
                break;
            default:
                System.out.print("ERROR");
                gradePoint = 0;
        }
        */
        if(letterGrade.equals("A+"))
            gradePoint = 4.0;
        else if(letterGrade.equals("A"))
            gradePoint = 4.0;
        else if(letterGrade.equals("A-"))
            gradePoint = 3.7;
        else if(letterGrade.equals("B+"))
            gradePoint = 3.3;
        else if(letterGrade.equals("B"))
            gradePoint = 3.0;
        else if(letterGrade.equals("B-"))
            gradePoint = 2.7;
        else if(letterGrade.equals("C+"))
            gradePoint = 2.3;
        else if(letterGrade.equals("C"))
            gradePoint = 2.0;
        else if(letterGrade.equals("C-"))
            gradePoint = 1.7;
        else if(letterGrade.equals("D+"))
            gradePoint = 1.3;
        else if(letterGrade.equals("D"))
            gradePoint = 1.0;
        else if(letterGrade.equals("F"))
            gradePoint = 0;
        else {
            gradePoint = 0;
        }
        return gradePoint;
    }
}