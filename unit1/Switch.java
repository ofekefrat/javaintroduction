package unit1;

import java.util.Scanner;
public class Switch {
    public static void main(String[] args) {
        //declarations
        int num, finalNum;
        Scanner scan = new Scanner(System.in);

        //input
        System.out.println("Enter month number: ");
        num = scan.nextInt();

        //eval
        if(num==1 || num==2)
            finalNum = num+1;
        else if(num >= 3 && num <=5)
            finalNum = num-1;
        else if(num==6)
            finalNum = num*2;
        else
            finalNum= num*3;

        System.out.println("The final number is: " + finalNum);
    }
}
