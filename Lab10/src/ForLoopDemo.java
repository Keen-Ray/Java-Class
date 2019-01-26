/**
 * Created by keenan on 3/11/17.
 */
public class ForLoopDemo {
    public static void main(String[] args) {
        int numRows = 5; // number of rows
        int numCols = 5; // number of column
        // full multiplication table
        for(int row =1; row <= numRows; row++){
            System.out.print("\n");
            for(int column = 1; column <= numCols; column++){
                System.out.print("\t"+(row*column));
            }
        }
        System.out.print("\n\n");

        //  staggered table
        for(int row =1; row <= numRows; row+=1){
            System.out.print("\n");
            for(int column = 1; column <= row; column+=1) {
                System.out.print("\t"+(row*column));
            }
        }
        System.out.print("\n\n");

        // multiples of 5
        for(int row =5; row <= numRows*5; row+=5) {
            System.out.print("\n");
            for(int column = 5; column <= numCols*5; column+=5){
                System.out.print("\t"+(row*column));
            }
        }
        System.out.print("\n\n");

        //  Decrmented table
        for(int row =50; row >0; row-=10) {
            System.out.print("\n");
            for(int column = 50; column >0; column-=5){
                System.out.print("\t"+(row*column));
            }
        }
        System.out.print("\n\n");
    }
}
