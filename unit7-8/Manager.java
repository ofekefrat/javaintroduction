public class Manager extends Employee {
    //fields
    private int _workers;

    public Manager(String name, String id, double wage, int workers) {
        super(name, id, wage);
        this._workers = workers;
    }

    @Override
    public double computeSalary(int month) {
        if (_workers>10) return _monthlyHrs[month-1] * _wage*1.1;
        if (_workers>5) return _monthlyHrs[month-1] * _wage*1.05;
        return _monthlyHrs[month-1] * _wage;
    }
}
