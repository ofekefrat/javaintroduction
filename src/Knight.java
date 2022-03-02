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
        int diagonalPos, horizontalPos;
        Scanner scan = new Scanner(System.in);

        //functionality
        System.out.println("Input diagonal, and then horizontal position:");//asking user for input
        diagonalPos = scan.nextInt();
        horizontalPos = scan.nextInt();

        if((diagonalPos >= 1 && diagonalPos <= 8) && (horizontalPos >= 1 && horizontalPos <= 8)) {//Making sure input is legal
            if (diagonalPos < 7 && diagonalPos > 2) {
                if (horizontalPos < 7 && horizontalPos > 2) {
                    System.out.println("Moves:");
                    System.out.println((horizontalPos + 1) + (diagonalPos + 2));
                    System.out.println((horizontalPos + 2) + (diagonalPos + 1));
                    System.out.println((horizontalPos - 1) + (diagonalPos + 2));
                    System.out.println((horizontalPos - 2) + (diagonalPos + 1));
                    System.out.println((horizontalPos - 2) + (diagonalPos - 1));
                    System.out.println((horizontalPos - 1) + (diagonalPos - 2));
                    System.out.println((horizontalPos + 1) + (diagonalPos - 2));
                    System.out.println((horizontalPos + 2) + (diagonalPos - 1));
                } else if (horizontalPos == 7) {
                    System.out.println("Moves:");
                    System.out.println((horizontalPos + 1) + (diagonalPos + 2));
                    System.out.println((horizontalPos + 2) + (diagonalPos + 1));
                    System.out.println((horizontalPos - 1) + (diagonalPos + 2));
                    System.out.println((horizontalPos - 2) + (diagonalPos + 1));
                    System.out.println((horizontalPos - 2) + (diagonalPos - 1));
                    System.out.println((horizontalPos - 1) + (diagonalPos - 2));
                    System.out.println((horizontalPos + 1) + (diagonalPos - 2));
                    System.out.println((horizontalPos + 2) + (diagonalPos - 1));

                }
            }
        }
        else//if input is illegal, print error message and exit the program
            System.out.println("input is illegal");
    }
}
