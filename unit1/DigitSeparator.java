package unit1;

import java.util.Scanner;
public class DigitSeparator {
    public static void main(String[] args) {
        int userInput, num1, num2, num3;
        Scanner scan = new Scanner(System.in);

        System.out.println("Please enter a 3-digit number: ");
        userInput = scan.nextInt();
        num1 = userInput % 10;
        num2 = userInput / 10 % 10;
        num3 = userInput / 100;

        System.out.println(num1);
        System.out.println(num2);
        System.out.println(num3);
    }
}
