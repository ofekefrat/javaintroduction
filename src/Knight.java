/*
This program shows possible moves of a knight in a chess game
after receiving its current position on the board as 2 integers:
1) diagonal position
2) horizontal position
 */
import java.util.Scanner;
public class Knight {
    public static void main(String[] args) {
        //declarations
        final int BOARD_EDGE = 8;

        Scanner scan = new Scanner(System.in);//scanner object

        //asking user for input
        System.out.println("This program reads two integers which " +
                "represent the knight's location on the chess board: ");
        System.out.println("Please enter the number of row");
        int row = scan.nextInt();//row input
        System.out.println("Please enter the number of column");
        int col = scan.nextInt();//column input

        //Making sure input is legal
        if((col >= 1 && col <= 8) && (row >= 1 && row <= 8)) {
            //dividing to scenarios

            //scenario 1: all moves can be made
            if ((col < 7 && col > 2) && (row < 7 && row > 2)) {
                System.out.println("Moves:");
                System.out.println((row + 1) + (col + 2));
                System.out.println((row + 2) + (col + 1));
                System.out.println((row - 1) + (col + 2));
                System.out.println((row - 2) + (col + 1));
                System.out.println((row - 2) + (col - 1));
                System.out.println((row - 1) + (col - 2));
                System.out.println((row + 1) + (col - 2));
                System.out.println((row + 2) + (col - 1));
            }//end of scenario 1
        }//end of legal input check
        else
            System.out.println("input is illegal");//if input is illegal, print error message and exit the program
    }//end of method main
}//end of class Knight
