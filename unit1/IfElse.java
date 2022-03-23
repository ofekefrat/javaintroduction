package unit1;

import java.util.Scanner;
public class IfElse {
    public static void main(String[] args) {
        //declarations
        int age, salary, newSalary;
        Scanner scan = new Scanner(System.in);

        //user input
        System.out.println("Please enter your age: ");
        age = scan.nextInt();

        System.out.println("Please enter your salary: ");
        salary = scan.nextInt();

        //evaluation
        if(age > 18 && age < 67)
            newSalary = salary-100;
        else
            newSalary = salary+200;

        System.out.println("Your new salary is: " + newSalary);
    }
}
