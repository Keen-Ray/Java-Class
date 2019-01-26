import java.util.Scanner;

/**
 * Created by keenan on 3/11/17.
 * Last edited on 3/11/17
 * This program takes in the maximum weight that a person or bag can carry and four objects that the person wishes to take
 * Then this program prints the combination that will allow a person to take the most weight, but still be under quota.
 */
public class KnapsackProblem {
    public static void main(String[] args) {
        //Introduce the program
        String intro = "This program is for poor hitchhiker who only has 4 things he cares about.\n";
        intro += "Unfortunately  is so weak that he can't carry all of them.\n";
        intro += "This program takes the maximum amount he can cary.\n";
        intro += "Then it returns the combination of possessions that will enable him to take the most objects possible\n";
        intro += "___________________________________________________________________________________________________\n";
        intro += "Please enter the maximum amount of weight the hiker can carry (in lbs.): ";
        System.out.print(intro);
        //Get the users input
        Scanner inKey = new Scanner(System.in);
        int maxWeight = inKey.nextInt();

        //Get the weight of the hitchhikers 4 possessions
        String prompt = "Please enter the weight of possession ";
        //Tne
        System.out.print(prompt + "one: ");
        int object1 = inKey.nextInt();
        //Two
        System.out.print(prompt + "two: ");
        int object2 = inKey.nextInt();
        //Three
        System.out.print(prompt + "three: ");
        int object3 = inKey.nextInt();
        //Four
        System.out.print(prompt + "four: ");
        int object4 = inKey.nextInt();

        //create a variable to keep track of which combination of object is results in the largest weight
        int totalPossibleWeight = 0;
        //create variables to kee track of the most likely looking combination
        int objectToTake1 = 0;
        int objectToTake2 = 0;
        int objectToTake3 = 0;
        int objectToTake4 = 0;

        //These four loops run through every possible combination that the four objects' weight can be placed in.
        for(int i = 0; i < 2; i++){
            for(int j = 0; j < 2; j++){
                for(int x =0; x < 2; x++) {
                    for(int e = 0; e < 2; e++) {
                        //find the sum of every possible combinations that the objects can make
                        int sum = (i*object1) + (j*object2) + (x*object3) + (e*object4);
                        if(sum > totalPossibleWeight && sum <= maxWeight) {// if the sum is the best fit found so far
                            //then save this combinations information for later use.
                            totalPossibleWeight = sum;
                            objectToTake1 = i*object1;
                            objectToTake2 = j*object2;
                            objectToTake3 = x*object3;
                            objectToTake4 = e*object4;


                        }
                    }
                }
            }
        }
        //print the results
        String results = "\nFor a maximum weight of " + maxWeight + " pounds\n";
        results += "and for objects of the following weights:\n\n";
        String separator = " lbs, ";
        results += object1 + separator + object2 + separator + object3 + separator + "and " + object4 + " lbs\n\n";
        results += "the hikers can carry the following item weights:\n\n";
        results += weightsNotEqualToZero(objectToTake1, objectToTake2, objectToTake3, objectToTake4);
        results += "for a total of " + totalPossibleWeight + " lbs.\n";
        System.out.print(results);

    }
    public static String weightsNotEqualToZero(int one, int two, int three, int four) {
        /**
         * This method takes four ints and returns a string containing them,
         * but removes any of the variable that are equal to zero
         */
        String result = "";
        if(one != 0)
            result += one + " lbs, ";

        if(two != 0)
            result += two + " lbs, ";

        if(three != 0)
            result += three + " lbs, ";

        if(four != 0)
            result += four + " lbs, ";

        return result;


    }
}
