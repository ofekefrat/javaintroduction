/**
 * Represents a time object, with hour and minute implementation.
 * @author Ofek Efrat
 * @version 30/03/22
 */
public class Time1 {
    //class variables
    private static final int DEFAULT_HOUR = 0;
    private static final int DEFAULT_MINUTE = 0;
    private static final int MINUTES_IN_HOUR = 60;
    private static final int HOURS_IN_DAY = 24;

    //instance variables
    private int _hour;// 0-23
    private int _minute;// 0-59

    //constructors
    /**
     * Constructs a Time1 object. Construct a new time instance with the specified hour and minute.
     * hour should be between 0-23, otherwise it should be set to 0.
     * minute should be between 0-59, otherwise it should be set to 0.
     * @param h the hour of the time.
     * @param m the minute of the time.
     */
    public Time1(int h, int m) {
        this.setHour(h); // if (num>=DEFAULT_HOUR && num<HOURS_IN_DAY) _hour = num;
        this.setMinute(m); // if (num>=DEFAULT_MINUTE && num<MINUTES_IN_HOUR) _minute = num;
    }

    /**
     * Copy constructor for Time1. Construct a time with the same instance variables as another time.
     * @param other The time object from which to construct the new time
     */
    public Time1(Time1 other) {
        this(other.getHour(), other.getMinute());
    }

    //methods
    /**
     * Returns the hour of the time.
     * @return The hour of the time.
     */
    public int getHour() {
        return _hour;
    }

    /**
     * Returns the minute of the time.
     * @return The minute of the time.
     */
    public int getMinute() {
        return _minute;
    }

    /**
     * Changes the hour of the time. If an illegal number is received hour will be unchanged.
     * @param num The new hour
     */
    public void setHour(int num) {
        if (num>=DEFAULT_HOUR && num<HOURS_IN_DAY) _hour = num;
    }

    /**
     * Changes the minute of the time. If an illegal number is received minute will be unchanged.
     * @param num The new minute
     */
    public void setMinute(int num) {
        if (num>=DEFAULT_MINUTE && num<MINUTES_IN_HOUR) _minute = num;
    }

    /**
     * Return a string representation of this time (hh:mm).
     * @return String representation of this time (hh:mm)
     */
    public String toString() {
        String tempH = (_hour<10) ? "0" : "";// adding a '0' before any single digit values.
        String tempM = (_minute<10) ? "0" : "";
        return (tempH + _hour + ":" + tempM + _minute);
    }

    /**
     * Return the amount of minutes since midnight.
     * @return amount of minutes since midnight.
     */
    public int minFromMidnight() {
        return _hour * MINUTES_IN_HOUR + _minute;
    }
    /**
     * Check if the received time is equal to this time.
     * @param other The time to be compared with this time
     * @return True if the received time is equal to this time
     */
    public boolean equals(Time1 other) {
        return (this.minFromMidnight() == other.minFromMidnight());
    }

    /**
     * Check if this time is before a received time.
     * @param other The time to be compared with this time
     * @return True if this time is before other time
     */
    public boolean before(Time1 other) {
        return (this.minFromMidnight() < other.minFromMidnight());
    }

    /**
     * Check if this time is after a received time.
     * @param other The time to be compared with this time
     * @return True if this time is after other time
     */
    public boolean after(Time1 other) {
        return other.before(this);
    }

    /**
     * Calculates the difference (in minutes) between two times. Assumption: this time is after other time.
     * @param other The time to check the difference to
     * @return int difference in minutes
     */
    public int difference(Time1 other) {
        return (this.minFromMidnight() - other.minFromMidnight());
    }

    /**
     * Copy current object and add requested minutes to new object.
     * @param num The minutes need to add.
     * @return new update Time1 object.
     */
    public Time1 addMinutes(int num) {
        int tempT = (this.minFromMidnight()+num);// total minutes after change
        return new Time1((tempT/MINUTES_IN_HOUR) % HOURS_IN_DAY, tempT % MINUTES_IN_HOUR);// convert minutes back to hours and minutes, assign to new instance
    }
}
