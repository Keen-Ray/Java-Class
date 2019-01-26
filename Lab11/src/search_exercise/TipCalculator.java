/*
 * Demo code for Lab 11 exercise
 * File io using scanner and while loop
 * CSIS130 lab
 * C.Anderson  11-3-13 
 */
package search_exercise;

import javax.swing.JOptionPane;
import java.util.Scanner;
import java.io.*;
import java.text.DecimalFormat;
/**
 *
 * @author canderson
 */
public class TipCalculator {
    
    
    public static void main(String[] args) throws Exception
    { 
         //Establishing constants
        final double TIP_BREAK_POINT = 85.00;
        final double REGULAR_RATE = 0.15;
        final double BONUS_RATE = 0.2;
        final String FILENAME = "/home/keenan/IdeaProjects/Lab11/src/search_exercise/dinner_Sales.csv";
        
        // Form greeting display
        String greeting = "The program will calculate tips from the dinner\n"
                        + "sales stored in the file dinner_sales.csv\n\n"+
                          "Tips are calculated by giving the server 15% on\n"+
                          "each dinner sale\n\n"+
                          "If the sale is over 85 dollars, the server gets 20%\n\n"+
                          "You will need to enter the name of the server\n"+
                          "and the program will display there dinner sales\n"+
                          "and each associated tip along with the final tips\n"+
                          "they earned.\n ";
        JOptionPane.showMessageDialog(null, greeting,"Tip Calculator", 1);     
        
        //  Entry of Servers Name
        String namePrompt = "Please enter the server's name!\n\nYour choices are:\n\n"+
                            "  Judy\n  Bo\n  Mary\n  Dave\n\n";
        String serverName = JOptionPane.showInputDialog(null, namePrompt,"Enter name", 1);
        
        // Initializing accumulator variables
        String serversTips = "Sales    tips\n";
        Double runningTipTotal = 0.0;
        Double runningSalesTotal = 0.0;
        
        DecimalFormat decFor = new DecimalFormat("0.00");
        File inFile = new File(FILENAME);
        if(!inFile.exists())
        {
            JOptionPane.showMessageDialog(null,"File "+FILENAME+" not found!",
                                            "Error Message", 1);
            System.exit(0);
        }
        
        // opening file and reading in data
        Scanner inScan = new Scanner(inFile);
        while(inScan.hasNext())
        { 
            String tempName = inScan.next();
            Double tempSales = inScan.nextDouble();
            
            // Calculating tips and adjusting accumulators
            if(tempName.toUpperCase().equals(serverName.toUpperCase()))
            {
                serversTips += decFor.format(tempSales);
                runningSalesTotal += tempSales;
                double rate = 0.0;
                if(tempSales  > TIP_BREAK_POINT )
                {
                    rate = BONUS_RATE;
                }
                else
                {
                    rate = REGULAR_RATE;
                }
                double tip = tempSales * rate;
                runningTipTotal += tip;
                serversTips += "    "+decFor.format(tip)+"\n";
            }
        }
        inScan.close();
        // Forming result display
        String results = "The sales and tips for server "+serverName+" are:\n\n"+
                         serversTips+"\n"+decFor.format(runningSalesTotal)+
                         "   "+decFor.format(runningTipTotal)+"  Totals";
        
        JOptionPane.showMessageDialog(null, results,"Tip Calculator - Results", 1);  
        
       // This section should be uncommented to enter new data
      /* 
        serverName = JOptionPane.showInputDialog(null, namePrompt,"Enter name", 1);
        String sales_string = JOptionPane.showInputDialog(null,
                                               "Enter Sales = format XXX.XX",
                                               "Enter sales", 1);
        
        FileWriter outWriter = new FileWriter(inFile, true);
        outWriter.write("\n"+serverName+" "+sales_string);
        outWriter.close();
      */   
        JOptionPane.showMessageDialog(null, "Program now terminating!\n","Tip Calculator - exiting", 1);  
    }   
}
