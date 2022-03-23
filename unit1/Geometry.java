package unit1;

import java.util.Scanner;
    public class Geometry {

        public static void main(String []args) {
            int height, width, perimeter, area;
            Scanner scan = new Scanner(System.in);

            System.out.println("Please enter the height: ");// Ask the user for input
            height = scan.nextInt();// Assign input

            System.out.println("Please enter the width: ");// Ask the user for input
            width = scan.nextInt();// Assign input

            perimeter = 2*height + 2*width;
            area = width*height;
            System.out.println("Perimeter: "+ perimeter);
            System.out.println("Area: "+ area);

    }
}
