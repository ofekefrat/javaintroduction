/*
This program shows possible moves of a knight in a chess game
after receiving its current position on the board as 2 integers:
1) row number
2) column number
 */
import java.util.Scanner;
public class Knight {
    public static void main(String[] args) {
        //declarations
        final int LOW_BOUNDARY = 1;//assigning boundaries as constants
        final int HIGH_BOUNDARY = 8;
        Scanner scan = new Scanner(System.in);//scanner object
        System.out.println("This program reads two integers which " +
                "represent the knight's location on the chess board: ");//describing program to user
        //asking user for input
        System.out.println("Please enter the number of row");
        int row = scan.nextInt();//row input
        System.out.println("Please enter the number of column");
        int col = scan.nextInt();//column input

        if ((col >= LOW_BOUNDARY && col <= HIGH_BOUNDARY) && (row >= LOW_BOUNDARY && row <= HIGH_BOUNDARY)) {//legal input check
            System.out.println("Moves:");//this line should be printed as long as the input is legal

            //checking if each move will end up on the board, and printing it if it will:
            if (row+1 <= HIGH_BOUNDARY && col+2 <= HIGH_BOUNDARY)
                System.out.println((row + 1) + " " + (col + 2));

            if (row+2 <= HIGH_BOUNDARY && col+1 <= HIGH_BOUNDARY)
                System.out.println((row + 2) + " " + (col + 1));

            if (row-1 >= LOW_BOUNDARY && col+2 <= HIGH_BOUNDARY)
                System.out.println((row - 1) + " " + (col + 2));

            if (row-2 >= LOW_BOUNDARY && col+1 <= HIGH_BOUNDARY)
                System.out.println((row - 2) + " " + (col + 1));

            if (row-2 >= LOW_BOUNDARY && col-1 >= LOW_BOUNDARY)
                System.out.println((row - 2) + " " + (col - 1));

            if (row-1 >= LOW_BOUNDARY && col-2 >= LOW_BOUNDARY)
                System.out.println((row - 1) + " " + (col - 2));

            if (row+1 <= HIGH_BOUNDARY && col-2 >= LOW_BOUNDARY)
                System.out.println((row + 1) + " " + (col - 2));

            if (row+2 <= HIGH_BOUNDARY && col-1 >= LOW_BOUNDARY)
                System.out.println((row + 2) + " " + (col - 1));
        }//end of legal input check
        else
            System.out.println("input is illegal");//if input is illegal, print error message and exit the program

    }//end of method main
}//end of class Knight
