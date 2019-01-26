import java.text.DecimalFormat;

/**
 * Created by Keenan on 2/12/2017.
 */
public class PractiveWithyIfs {
    public static void main(String[] args) {

        double loanAmount = 13500;
        double interestRate =.16;

        // If the loan amount is greater than 60,000
        if (loanAmount > 60000) {
            interestRate = 0.06;
        }
        // If the loan amount is less than/equal to 60,000 but greater than 50,000
        else if (loanAmount > 50000) {
            interestRate = 0.08;
        }
        // If the loan amount is less than/equal to 50,000 but greater than 40,000
        else if (loanAmount > 40000) {
            interestRate = 0.10;
        }
        // If the loan amount is less than/equal to 40,000 but greater than 30,000
        else if (loanAmount > 30000) {
            interestRate = 0.12;
        }
        // If the loan amount is less than/equal to 30,000 but greater than 20,000
        else if (loanAmount > 20000) {
            interestRate = 0.14;
        }
        // If the loan amount is less than/equal to 20,000
        double percent = interestRate * 100;
        DecimalFormat decFor = new DecimalFormat("0.00");

        System.out.print("\nFor a loan amount of $"
                + decFor.format(loanAmount) + ", the interest rate is % "
                + decFor.format(percent) + "\n\n");
    }

}
