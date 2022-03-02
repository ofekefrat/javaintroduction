/*
This class calculates a course's cost based on the following 4 INTS received from the user:

1) Number of points that the student has gathered:
    1 = under 18 points
    2 = 18 or more points

2) The student's military service status:
    1 = Fighter (current or past)
    2 = Soldier (current or past)
    3 = Other

3) Instruction Type:
    1 = Standard
    2 = Increased

4) Semester:
    1 = Standard
    2 = Summer
 */
import java.sql.PseudoColumnUsage;
import java.util.Scanner;

public class CourseCost {
    public static void main(String[] args) {
        //declarations
        final int SECURITY_COST = 59;
        final int NEW_STUDENT_COST = 2079;
        final int ADVANCED_STUDENT_COST = 1539;
        final double FIGHTER_DISCOUNT = 0.5;
        final double SOLDIER_DISCOUNT = 0.1;
        final int INCREASED_INSTRUCTION_FEE = 301;
        final int SUMMER_SEMESTER_FEE = 286;
        int points, milService, instructionType, semester;
        double finalCost;
        Scanner scan = new Scanner(System.in);

        //Asking user for values:
        System.out.println("""

                This program will calculate your course's cost!
                How many points have you gathered?
                1) Under 18
                2) 18 or more""");
        points = scan.nextInt();

        System.out.println("What type of soldier are/were you?\n1) Fighter\n2) non-Fighter\n3) Didn't serve");
        milService = scan.nextInt();

        System.out.println("What is the course's instruction type?\n1) Standard\n2) Increased");
        instructionType = scan.nextInt();

        System.out.println("Is the semester a summer semester?\n1) No\n2) Yes");
        semester = scan.nextInt();

        //Calculation
        //Points
        if (points == 1)
            finalCost = NEW_STUDENT_COST;
        else if (points == 2)
            finalCost = ADVANCED_STUDENT_COST;
        else
            finalCost = 0;


        //Service
        if (milService == 1)
            finalCost -= finalCost*FIGHTER_DISCOUNT;
        else if(milService == 2)
            finalCost -= finalCost*SOLDIER_DISCOUNT;

        //Instruction
        if (instructionType == 2)
            finalCost += INCREASED_INSTRUCTION_FEE;

        //Semester
        if (semester == 2)
            finalCost += SUMMER_SEMESTER_FEE;

        finalCost += SECURITY_COST;

        //Print the cost
        System.out.println("Your course will cost: " + finalCost);
    }
}
