import java.util.Random;

/**
 * Created by keenan on 4/2/17.
 */
public class CoinToss {
    public static void tossCoin(int times) {
        Random randomGenerator = new Random();
        String toss = "";
        for (int dex = 0; dex < times; dex++) {
            int randomNumber = randomGenerator.nextInt(100);
            if (randomNumber < 50) {
                toss = "heads";
            } else {
                toss = "tails";
            }
            System.out.print("\ntoss: "+toss);
        }
    }

    public static void main(String[] args) {
        tossCoin(1);
    }
}
