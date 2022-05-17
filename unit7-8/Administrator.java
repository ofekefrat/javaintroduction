public class Administrator extends Employee {

    public Administrator(String name, String id, double wage) {
        super(name, id, wage);
    }

    @Override
    public double computeSalary(int month) {
        return _monthlyHrs[month-1] * _wage;
    }
}
