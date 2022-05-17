public abstract class Employee {
    //fields
    protected String _name;
    protected String _id;
    protected double _wage;
    protected int[] _monthlyHrs;

    private static final int MAX_MONTHS=12;

    //const
    public Employee(String name, String id, double wage) {
        this._monthlyHrs = new int[MAX_MONTHS];
        this._name = name;
        this._id = id;
        this._wage = wage;
    }

    public String getName() {
        return _name;
    }

    public double getPerHourSalary() {
        return _wage;
    }

    public void setWorkingHours(int month, int hours) {
        if (hours<0) return;
        _monthlyHrs[month-1] = hours;
    }

    public abstract double computeSalary(int month);

    @Override
    public String toString() {
        String temp = "Name: " + _name + ", ID: " + _id + ", Pay per hour: " + _wage + " shekels\n" + _monthlyHrs[0];
        for (int i = 1; i < _monthlyHrs.length; i++) {
            temp = temp.concat(", " + _monthlyHrs[i]);
        }
        return temp;
    }
}
