public class Worker extends Employee {
    //fields
    private int _shift;
    private final int MORNING=1;
    private final int NIGHT=3;
    private final int BREAKFAST_BONUS=25;

    public Worker(String name, String id, double wage, int shift) {
        super(name, id, wage);
        this._shift = shift;
    }

    @Override
    public double computeSalary(int month) {
        if (_shift<1 || _shift>3) return 0;
        if (_shift == NIGHT) return _monthlyHrs[month-1] * (_wage * 1.1);
        if (_shift == MORNING) return _monthlyHrs[month-1] * _wage + BREAKFAST_BONUS;
        return _monthlyHrs[month-1] * _wage;
    }
}
