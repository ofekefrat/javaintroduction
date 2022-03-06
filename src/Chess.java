/*
This class gets the following 3 parameters from the user, twice (one for each piece):
1) type of chess piece
2) row number
3) column number
for two different chess pieces on the board, and checks if they threaten
each other in their current locations.
 */
import java.util.Scanner;
public class Chess {
    public static void main (String [] args) {
        //declarations
        int illegalPosition = 0;//flag for illegal position check
        int threatFound = 0;//flag to check if no threats were found
        final int LOW_BOUNDARY = 1;//assigning boundaries as constants
        final int HIGH_BOUNDARY = 8;
        String firstPieceName = "Unassigned";
        String secondPieceName = "Unassigned";//making variables to store full name of piece types
        Scanner scan = new Scanner (System.in);

        //asking user for input:
        //first chess piece
        System.out.println("Please enter the type " +
                "of the first chessman");
        char first = scan.next().charAt(0);//type of chess piece input
        switch (first) {//assigning name for piece type
            case ('k'):
                firstPieceName = "knight";
                break;
            case ('r'):
                firstPieceName = "rook";
                break;
            case('b'):
                firstPieceName = "bishop";
        }
        System.out.println("Please enter the number of row");
        int row1 = scan.nextInt();//row input
        if (row1 < 1 || row1 > 8)//checking for illegal position assignment
            illegalPosition = 1;
        System.out.println("Please enter the number of column");
        int col1 = scan.nextInt();//column input
        if (col1 < 1 || col1 > 8)
            illegalPosition = 1;

        //second chess piece
        System.out.println("Please enter the type " +
                "of the second chessman");
        char second = scan.next().charAt(0);
        switch (second) {
            case ('k'):
                secondPieceName = "knight";
                break;
            case ('r'):
                secondPieceName = "rook";
                break;
            case ('b'):
                secondPieceName = "bishop";
        }
        System.out.println("Please enter the number of row");
        int row2 = scan.nextInt();
        if (row2 < LOW_BOUNDARY || row2 > HIGH_BOUNDARY)
            illegalPosition = 1;
        System.out.println("Please enter the number of column");
        int col2 = scan.nextInt();
        if (col2 < LOW_BOUNDARY || col2 > HIGH_BOUNDARY)
            illegalPosition = 1;

        if (first != second) {//unique chess piece check
            if (illegalPosition == 0) {//checking the illegal position flag
                if (!(row1 == row2 && col1 == col2)) {//unique position check
                    //threat checks
                    if (first == 'r' || second == 'r') {
                        if (row1 == row2 || col1 == col2) {//rook threatens other piece
                            threatFound = 1;
                            if (first == 'r')
                                System.out.println("rook threats " + secondPieceName);
                            else
                                System.out.println("rook threats " + firstPieceName);
                        }
                    }
                    if (first == 'b' || second == 'b') {
                        if ((col1 - row1 == col2 - row2) || (col1 + row1 == col2 + row2)) {//bishop threatens other piece
                            threatFound = 1;
                            if (first == 'b')
                                System.out.println("bishop threats " + secondPieceName);
                            else
                                System.out.println("bishop threats " + firstPieceName);
                        }
                    }
                    if (first == 'k' || second == 'k') {//knight threatens other piece
                        if (row1+2 == row2 && col1+1 == col2) {
                            threatFound = 1;
                            if (first == 'k')
                                System.out.println("knight threats " + secondPieceName);
                            else
                                System.out.println("knight threats " + firstPieceName);
                        }
                        else if (row1+1 == row2 && col1+2 == col2) {
                            threatFound = 1;
                            if (first == 'k')
                                System.out.println("knight threats " + secondPieceName);
                            else
                                System.out.println("knight threats " + firstPieceName);
                        }
                        else if (row1-1 == row2 && col1+2 == col2) {
                            threatFound = 1;
                            if (first == 'k')
                                System.out.println("knight threats " + secondPieceName);
                            else
                                System.out.println("knight threats " + firstPieceName);
                        }
                        else if (row1-2 == row2 && col1+1 == col2) {
                            threatFound = 1;
                            if (first == 'k')
                                System.out.println("knight threats " + secondPieceName);
                            else
                                System.out.println("knight threats " + firstPieceName);
                        }
                        else if (row1-2 == row2 && col1-1 == col2) {
                            threatFound = 1;
                            if (first == 'k')
                                System.out.println("knight threats " + secondPieceName);
                            else
                                System.out.println("knight threats " + firstPieceName);
                        }
                        else if (row1-1 == row2 && col1-2 == col2) {
                            threatFound = 1;
                            if (first == 'k')
                                System.out.println("knight threats " + secondPieceName);
                            else
                                System.out.println("knight threats " + firstPieceName);
                        }
                        else if (row1+1 == row2 && col1-2 == col2) {
                            threatFound = 1;
                            if (first == 'k')
                                System.out.println("knight threats " + secondPieceName);
                            else
                                System.out.println("knight threats " + firstPieceName);
                        }
                        else if (row1+2 == row2 && col1-1 == col2) {
                            threatFound = 1;
                            if (first == 'k')
                                System.out.println("knight threats " + secondPieceName);
                            else
                                System.out.println("knight threats " + firstPieceName);
                        }
                    }//end of knight threat cases
                    if (threatFound == 0)//using flag to check if no threat was ever found by the program
                        System.out.println("no threat");
                }//end of unique position check
                else
                    System.out.println("Chessmen positions should not be identical");

            }//end of illegal position check
            else
                System.out.println("Position is not legal");

        }//end of unique piece check
        else
            System.out.println("Chessmen should be different from each other");

    } //end of method main
} //end of class Chess