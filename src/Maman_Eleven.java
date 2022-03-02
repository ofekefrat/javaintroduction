/*
This program receives 2 integers from the user, representing
the current position of a knight on a chess board,
and prints all the possible moves he can make.
 */
import java.util.Scanner;
public class Maman_Eleven {
    public static void main(String[] args) {
        //declarations
        int diagonalPos, horizontalPos;
        Scanner scan = new Scanner(System.in);

        //functionality
        System.out.println("Input diagonal, and then horizontal position:");//asking user for input
        diagonalPos = scan.nextInt();
        horizontalPos = scan.nextInt();

        if (diagonalPos < 7 && diagonalPos > 2){
            if (horizontalPos < 7 && horizontalPos > 2) {
                System.out.println("Moves:");
                System.out.println("(" + (horizontalPos+1) + "," + (diagonalPos+2) + ")");
                System.out.println("(" + (horizontalPos+2) + "," + (diagonalPos+1) + ")");
                System.out.println("(" + (horizontalPos-1) + "," + (diagonalPos+2) + ")");
                System.out.println("(" + (horizontalPos-2) + "," + (diagonalPos+1) + ")");
                System.out.println("(" + (horizontalPos-2) + "," + (diagonalPos-1) + ")");
                System.out.println("(" + (horizontalPos-1) + "," + (diagonalPos-2) + ")");
                System.out.println("(" + (horizontalPos+1) + "," + (diagonalPos-2) + ")");
                System.out.println("(" + (horizontalPos+2) + "," + (diagonalPos-1) + ")");
            }
        }
    }
}
