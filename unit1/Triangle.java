package unit1;/*
This program receives 3 coordinates, which are the points of a triangle,
and determines whether this triangle is an equilateral triangle, an isosceles triangle,
or just a regular one, which is none of those two.
 */
import java.util.Scanner;
public class Triangle {
    public static void main(String[] args) {
        //declarations
        int xA, xB, xC, yA, yB, yC;// all the coordinates
        double AB, AC, BC;// lengths of triangle's arms
        Scanner s = new Scanner(System.in);

        //Asking the user for input
        System.out.println("Please input the x of point A:");
        xA = s.nextInt();

        System.out.println("Please input the y of point A:");
        yA = s.nextInt();

        System.out.println("Please input the x of point B:");
        xB = s.nextInt();

        System.out.println("Please input the y of point B:");
        yB = s.nextInt();

        System.out.println("Please input the x of point C:");
        xC = s.nextInt();

        System.out.println("Please input the y of point C:");
        yC = s.nextInt();

        //calculation
        AB = Math.sqrt((Math.pow((xA-xB), 2)) + (Math.pow((yA-yB), 2)));
        BC = Math.sqrt((Math.pow((xB-xC), 2)) + (Math.pow((yB-yC), 2)));
        AC = Math.sqrt((Math.pow((xA-xC), 2)) + (Math.pow((yA-yC), 2)));

        if (AB == AC && AC == BC)
            System.out.println("Equilateral triangle");
        else if (((AC == AB) || (AC == BC)) || AB == BC)
            System.out.println("Isoceles triangle");
        else
            System.out.println("Just a regular triangle");
    }
}
