package exercise1;
import java.io.*;
import java.text.DecimalFormat;
import java.util.Scanner;
/**
 * Created by keenan on 3/29/17.
 */
public class MaxSalesRatio {
    public static void main(String[] args) throws Exception {
        String intro = "This program will read the data in from the\n"+
                "file \"Shop_data.csv\" and will determine which\n"+
                "shop has the higest netSales to grosssales ratio.\n\n"+
                "For this demo, the user does not enter anything.\n"+
                "The shop with the highest ratio will be displayed";
        System.out.println(intro);

// Initializing variable
        String maxCity = "";
        String maxID = "";
        double maxSales = 0;
        double maxExpenses = 0;
        double maxRatio = 0;

// Initalizing file IO
        String fileName = "/home/keenan/IdeaProjects/Lab11/src/exercise1/Shop_data.csv";
        File file = new File("/home/keenan/IdeaProjects/Lab11/src/exercise1/Shop_data.csv");
        Scanner fileScan = new Scanner(file);

// read in data and process
        while(fileScan.hasNext()) {
            String id = fileScan.next();
            String city = fileScan.next();
            double sales = fileScan.nextDouble();
            double expenses = fileScan.nextDouble();
            double ratio = (sales-expenses)/sales;
            if (maxRatio < ratio) {
                maxID = id;
                maxCity = city;
                maxSales = sales;
                maxExpenses = expenses;
                maxRatio = ratio;
            }
        }

// form display
        DecimalFormat decFor = new DecimalFormat("0.00");
        double ratio = (maxSales-maxExpenses)/maxSales;
        String display = maxCity + " has the highest ratio: \n"+
                "( "+decFor.format(maxSales)+" - "+decFor.format(maxExpenses)+
                " ) / "+decFor.format(maxSales)+") = "+decFor.format(ratio);
        System.out.println(display);
        FileWriter outWriter = new FileWriter(file,true);
        outWriter.write("\n5558 Manhattan 7785900 16600");
        outWriter.close();
    }
}
