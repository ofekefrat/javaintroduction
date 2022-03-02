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
        final int EDGE_1 = 1;
        final int EDGE_2 = 8;
        final int NEAR_EDGE_1 = EDGE_1 + 1;
        final int NEAR_EDGE_2 = EDGE_2 - 1;
        Scanner scan = new Scanner(System.in);//scanner object

        //describing program to user
        System.out.println("This program reads two integers which " +
                "represent the knight's location on the chess board: ");
        //asking user for input
        System.out.println("Please enter the number of row");
        int row = scan.nextInt();//row input
        System.out.println("Please enter the number of column");
        int col = scan.nextInt();//column input

        if ((col >= EDGE_1 && col <= EDGE_2) && (row >= EDGE_1 && row <= EDGE_2)) {//legal input check
            System.out.println("Moves:");//this line should be printed as long as the input is legal

            if (col < NEAR_EDGE_2 && col > NEAR_EDGE_1) { //far from horizontal edges
                if (row < NEAR_EDGE_2 && row > NEAR_EDGE_1) { //far from diagonal edges
                    System.out.println((row + 1) + (col + 2));
                    System.out.println((row + 2) + (col + 1));
                    System.out.println((row - 1) + (col + 2));
                    System.out.println((row - 2) + (col + 1));
                    System.out.println((row - 2) + (col - 1));
                    System.out.println((row - 1) + (col - 2));
                    System.out.println((row + 1) + (col - 2));
                    System.out.println((row + 2) + (col - 1));
                }
                else if (row == NEAR_EDGE_1) { //close to top edge
                    System.out.println((row + 1) + (col + 2));
                    System.out.println((row + 2) + (col + 1));
                    System.out.println((row - 1) + (col + 2));
                    System.out.println((row - 1) + (col - 2));
                    System.out.println((row + 1) + (col - 2));
                    System.out.println((row + 2) + (col - 1));
                }
                else if (row == EDGE_1) { //at top edge
                    System.out.println((row + 1) + (col + 2));
                    System.out.println((row + 2) + (col + 1));
                    System.out.println((row + 1) + (col - 2));
                    System.out.println((row + 2) + (col - 1));
                }
                else if (row == NEAR_EDGE_2) { //close to bottom edge
                    System.out.println((row + 1) + (col + 2));
                    System.out.println((row - 1) + (col + 2));
                    System.out.println((row - 2) + (col + 1));
                    System.out.println((row - 2) + (col - 1));
                    System.out.println((row - 1) + (col - 2));
                    System.out.println((row + 1) + (col - 2));
                }
                else { // (row == EDGE_2), at bottom edge
                    System.out.println((row - 1) + (col + 2));
                    System.out.println((row - 2) + (col + 1));
                    System.out.println((row - 2) + (col - 1));
                    System.out.println((row - 1) + (col - 2));
                }
            } //end of "far from horizontal edges" scenarios

            else if (row < NEAR_EDGE_2 && row > NEAR_EDGE_1) { // far from diagonal edges
                if (col == NEAR_EDGE_1) { // close to left edge
                    System.out.println((row + 1) + (col + 2));
                    System.out.println((row + 2) + (col + 1));
                    System.out.println((row - 1) + (col + 2));
                    System.out.println((row - 2) + (col + 1));
                    System.out.println((row - 2) + (col - 1));
                    System.out.println((row + 2) + (col - 1));
                }
                else if (col == EDGE_1) { // at left edge
                    System.out.println((row + 1) + (col + 2));
                    System.out.println((row + 2) + (col + 1));
                    System.out.println((row - 1) + (col + 2));
                    System.out.println((row - 2) + (col + 1));
                }
                else if (col == NEAR_EDGE_2) { // close to right edge
                    System.out.println((row + 2) + (col + 1));
                    System.out.println((row - 2) + (col + 1));
                    System.out.println((row - 2) + (col - 1));
                    System.out.println((row - 1) + (col - 2));
                    System.out.println((row + 1) + (col - 2));
                    System.out.println((row + 2) + (col - 1));
                }
                else {//(col == EDGE_2), at right edge
                    System.out.println((row - 2) + (col - 1));
                    System.out.println((row - 1) + (col - 2));
                    System.out.println((row + 1) + (col - 2));
                    System.out.println((row + 2) + (col - 1));
                }
            }//end of "far from diagonal edges" scenarios

            //special cases
            else if (col == EDGE_1) { // 1st column special cases
                if (row == NEAR_EDGE_1) { // 2,1
                    System.out.println((row + 1) + (col + 2));
                    System.out.println((row + 2) + (col + 1));
                    System.out.println((row - 1) + (col + 2));
                }
                else if (row == EDGE_1) { // 1,1
                    System.out.println((row + 1) + (col + 2));
                    System.out.println((row + 2) + (col + 1));
                }
                else if (row == NEAR_EDGE_2) { // 7,1
                    System.out.println((row + 1) + (col + 2));
                    System.out.println((row - 1) + (col + 2));
                    System.out.println((row - 2) + (col + 1));
                }
                else { // 8,1
                    System.out.println((row - 1) + (col + 2));
                    System.out.println((row - 2) + (col + 1));
                }
            } // end of 1st column special cases

            else if (col == NEAR_EDGE_1) { // 2nd column special cases
                if (row == NEAR_EDGE_1) { // 2,2
                    System.out.println((row + 1) + (col + 2));
                    System.out.println((row + 2) + (col + 1));
                    System.out.println((row - 1) + (col + 2));
                    System.out.println((row + 2) + (col - 1));
                }
                else if (row == EDGE_1) { // 1,2
                    System.out.println((row + 1) + (col + 2));
                    System.out.println((row + 2) + (col + 1));
                    System.out.println((row + 2) + (col - 1));
                }
                else if (row == NEAR_EDGE_2) { // 7,2
                    System.out.println((row + 1) + (col + 2));
                    System.out.println((row - 1) + (col + 2));
                    System.out.println((row - 2) + (col + 1));
                    System.out.println((row - 2) + (col - 1));
                }
                else { // 8,2
                    System.out.println((row - 1) + (col + 2));
                    System.out.println((row - 2) + (col + 1));
                    System.out.println((row - 2) + (col - 1));
                }
            } // end of 2nd column special cases

            else if (col == NEAR_EDGE_2) { // 7th column special cases
                if (row == NEAR_EDGE_1) { // 2,7
                    System.out.println((row + 2) + (col + 1));
                    System.out.println((row - 1) + (col - 2));
                    System.out.println((row + 1) + (col - 2));
                    System.out.println((row + 2) + (col - 1));
                }
                else if (row == EDGE_1) { // 1,7
                    System.out.println((row + 2) + (col + 1));
                    System.out.println((row + 1) + (col - 2));
                    System.out.println((row + 2) + (col - 1));
                }
                else if (row == NEAR_EDGE_2) { // 7,7
                    System.out.println((row - 2) + (col + 1));
                    System.out.println((row - 2) + (col - 1));
                    System.out.println((row - 1) + (col - 2));
                    System.out.println((row + 1) + (col - 2));
                }
                else { // 8,7
                    System.out.println((row - 2) + (col + 1));
                    System.out.println((row - 2) + (col - 1));
                    System.out.println((row - 1) + (col - 2));
                }
            } // end of 7th column special cases

            else { // 8th column special cases
                if (row == NEAR_EDGE_1) { // 2,8
                    System.out.println((row - 1) + (col - 2));
                    System.out.println((row + 1) + (col - 2));
                    System.out.println((row + 2) + (col - 1));
                }
                else if (row == EDGE_1) { // 1,8
                    System.out.println((row + 1) + (col - 2));
                    System.out.println((row + 2) + (col - 1));
                }
                else if (row == NEAR_EDGE_2) { // 7,8
                    System.out.println((row - 2) + (col - 1));
                    System.out.println((row - 1) + (col - 2));
                    System.out.println((row + 1) + (col - 2));
                }
                else { // 8,8
                    System.out.println((row - 2) + (col - 1));
                    System.out.println((row - 1) + (col - 2));
                }
            } // end of 8th column special cases

        }//end of legal input check
        else
            System.out.println("input is illegal");//if input is illegal, print error message and exit the program

    }//end of method main

}//end of class Knight
