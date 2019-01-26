import java.text.DecimalFormat;

/**
 * Created by Keenan on 2/9/2017.
 */
public class test {
    public static void main(String[] args) {
        Double test = 192.31;
        DecimalFormat formater = new DecimalFormat();
        String rounded = formater.format(test);

    }
}
