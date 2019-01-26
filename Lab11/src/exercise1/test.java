package exercise1;

import java.io.File;
import java.util.Scanner;

/**
 * Created by keenan on 3/29/17.
 */
public class test {
    public static void main(String[] args) throws Exception{
        File file = new File("/home/keenan/IdeaProjects/Lab11/src/spanishDictionary.csv");
        Scanner inFile = new Scanner(file);
        while(inFile.hasNext()) {
            System.out.println(inFile.nextLine());
        }
    }
}
