import javax.swing.*;
import java.util.Scanner;

public class Factory {
    //fields
    private Employee[] _staff;
    private int _numOfEmployees;
    private final int MAX_STAFF=100;

    //const
    public Factory() {
        this._staff = new Employee[MAX_STAFF];
        this._numOfEmployees=0;
    }

    //methods
    public void hire() {
        if (_numOfEmployees == MAX_STAFF) return;
        Scanner scan = new Scanner(System.in);

        System.out.println("Type: ");
        int type = scan.nextInt();

        System.out.println("Name: ");
        String name = scan.nextLine();

        System.out.println("ID: ");
        String id = scan.nextLine();

        System.out.println("Wage: ");
        double wage = scan.nextDouble();

        if (type == 1) _staff[_numOfEmployees++] = new Administrator(name, id, wage);
        if (type == 2) {
            System.out.println("Shift: ");
            int shift = scan.nextInt();
            _staff[_numOfEmployees++] = new Worker(name, id, wage, shift);
        }
        if (type == 3) {
            System.out.println("Workers: ");
            int workers = scan.nextInt();
            _staff[_numOfEmployees++] = new Manager(name, id, wage, workers);
        }
    }

    public void updateHours(int[] hours, int month) {
        if (hours.length < _numOfEmployees || month<1 || month>12) return;
        for (int i = 0; i < _numOfEmployees; i++) {
            _staff[i]._monthlyHrs[month-1] = hours[i];
        }
    }

    public void printSalaries(int month) {
        if (month<1 || month>12) return;
        for (int i = 0; i < _numOfEmployees; i++) {
            System.out.println(_staff[i].getName() + ", " + _staff[i].computeSalary(month) + "\n");
        }
    }
}
