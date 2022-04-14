import org.junit.jupiter.api.BeforeEach;

import java.util.Scanner;

public class Tester {

    public static void main(String[] args) {
        Airport flightBoardMilan, flightBoardTelAviv, flightBoardTokyo;
        Flight flight1, flight2, flight3, flight4, flight5, flight6, flight7, flight8, flight9, flight10, flight11, flight12, flight13, flight14, flight15;
        Flight flight16, flight17, flight18, flight19, flight20, flight21, flight22, flight23, flight24, flight25, flight26, flight27, flight28, flight29, flight30;

        flight1 = new Flight("Amsterdam", "Tel-aviv", 1, 5, 205, 300, 300);// Tel-aviv1
        flight2 = new Flight("Madrid", "Milan", 8, 20, 105, 128, 60); // Milan1
        flight3 = new Flight("Warsaw", "Lyon", 22, 45, 90, 105, 78);
        flight4 = new Flight("Milan", "Paris", 11, 55, 120, 244, 52);// Milan2
        flight5 = new Flight("Milan", "Tokyo", 7, 80, 700, 250, 999); // Milan3 // Tokyo1 // 7:00
        flight6 = new Flight("New-York", "Tel-aviv", 2, 25, 900, 250, 1300); // Tel-aviv2
        flight7 = new Flight("Toronto", "Manchester", 18, 30, 660, 208, 1190);
        flight8 = new Flight("Madrid", "Milan", 9, 30, 138, 120, 26);// Milan4
        flight9 = new Flight("Tel-aviv", "Bucharest", 15, 15, 145, 260, 105); // Tel-aviv3
        flight10 = new Flight("Tel-aviv", "Barcelona", 6, 35, 265, 174, 240); // Tel-aviv4
        flight11 = new Flight("Seoul", "London", 21, 0, 780, 235, 970);
        flight12 = new Flight("Milan", "London", 5, 45, 350, 250, 285);// Milan5
        flight13 = new Flight("Amsterdam", "Tel-aviv", 14, 30, 420, 142, 420); // Tel-aviv5
        flight14 = new Flight("Tokyo", "Paris", 23, 20, 815, 248, 1124); // Tokyo2
        flight15 = new Flight("Tokyo", "Berlin", 16, 50, 820, 250, 1099); // Tokyo3
        flight16 = new Flight("Prague", "Tel-aviv", 20, 35, 260, 202, 270); // Tel-aviv6
        flight17 = new Flight("Tokyo", "Seoul", 4, 25, 150, 171, 155); // Tokyo4
        flight18 = new Flight("Tokyo", "Madrid", 19, 20, 735, 250, 1122); // Tokyo5
        flight19 = new Flight("Monaco", "Oslo", 11, 40, 210, 95, 540);
        flight20 = new Flight("Stockholm", "Milan", 2, 55, 232, 250, 241); // Milan6
        flight21 = new Flight("Stockholm", "Helsinki", 3, 15, 90, 141, 99);
        flight22 = new Flight("Tel-aviv", "New Delhi", 16, 10, 640, 400, 420); // Tel-aviv7
        flight23 = new Flight("Bangkok", "Tel-aviv", 13, 30, 780, 300, 490); // Tel-aviv8
        flight24 = new Flight("Cape Town", "Milan", 5, 40, 385, 248, 354); // Milan7
        flight25 = new Flight("Los Angeles", "Washington", 15, 25, 170, 167, 109);
        flight26 = new Flight("Milan", "Tel-aviv", 15, 45, 268, 250, 250); // Milan8 // Tel-aviv9
        flight27 = new Flight("Tokyo", "Berlin", 18, 5, 820, 214, 1024); // Tokyo6
        flight28 = new Flight("Moscow", "Tokyo", 14, 0, 690, 198, 864); // Tokyo7
        flight29 = new Flight("Istanbul", "Milan", 6, 50, 162, 250, 140); // Milan9
        flight30 = new Flight("Porto", "Madrid", 8, 25, 105, 300, 186);

        flightBoardMilan = new Airport("Milan");

    }
}