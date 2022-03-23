package unit1;

import java.util.Scanner;
public class SquareOrNot {
    public static void main(String[] args) {
        //declarations
        double side1, side2, side3, side4;
        Scanner scan = new Scanner(System.in);

        //user input
        System.out.println("Please input length of all sides, one by one: ");
        side1 = scan.nextDouble();
        side2 = scan.nextDouble();
        side3 = scan.nextDouble();
        side4 = scan.nextDouble();

        //evaluation
        if((side1 == side2 && side2 == side3) && side3 == side4)
            System.out.println("Square");
        else
            System.out.println("Not Square");

    }
}
