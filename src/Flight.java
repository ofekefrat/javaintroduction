/**
 * Represents a flight object.
 * @author Ofek Efrat
 * @version 30/03/22
 */
public class Flight {
    //class variable
    private static final int MAX_CAPACITY = 250;// maximum passenger capacity
    private static final int MIN_VAL = 0;// minimum value of several fields

    //instance variables
    private String _origin, _destination; // names of flight origin and destination cities
    private Time1 _departure; // time of departure as an object of the Time1 class
    private int _flightDuration, _noOfPassengers, _price;
    private boolean _isFull;

    //constructor
    /**
     * Constructor for a Flight object. If the number of passengers exceeds the maximum capacity,
     * the number of passengers will be set to the maximum capacity.
     * If the number of passengers is negative, the number of passengers will be set to zero.
     * If the flight duration is negative, the flight duration will be set to zero.
     * If the price is negative, the price will be set to zero.
     * @param origin The city the flight leaves from
     * @param dest The city the flight lands at
     * @param depHour The departure hour (should be between 0-23)
     * @param depMinute The departure minute (should be between 0-59)
     * @param durTimeMinutes The flight duration in minutes (should not be negative)
     * @param noOfPass The number of passengers (should be between 0-250)
     * @param price The price (should not be negative)
     */
    public Flight(String origin, String dest, int depHour, int depMinute,
                  int durTimeMinutes, int noOfPass, int price) {
        this._departure = new Time1(depHour, depMinute);// not aliasing
        this._origin = origin;
        this._destination = dest;
        this._flightDuration = Math.max(durTimeMinutes, MIN_VAL);// calling Math.max method to prevent negative inputs
        this._price = Math.max(price, MIN_VAL);
        this._noOfPassengers = (noOfPass>=MAX_CAPACITY) ? MAX_CAPACITY : Math.max(noOfPass, MIN_VAL);
        this._isFull = (_noOfPassengers == MAX_CAPACITY);
    }

    //copy constructor
    /**
     * Copy constructor for a Flight object. Construct a Flight object
     * with the same attributes as another Flight object.
     * @param other The Flight object from which to construct the new flight.
     */
    public Flight(Flight other) {
        this(other._origin,
            other._destination,
            other._departure.getHour(),
            other._departure.getMinute(),
            other._flightDuration,
            other._noOfPassengers,
            other._price);
        this._isFull = other._isFull;
    }

    //methods
    //getters

    /**
     * Returns the flight origin.
     * @return The flight origin
     */
    public String getOrigin() {
        return _origin;
    }

    /**
     * Returns the flight destination.
     * @return The flight destination
     */
    public String getDestination() {
        return _destination;
    }

    /**
     * Returns the flight departure time.
     * @return A copy of the flight departure time
     */
    public Time1 getDeparture() {
        return new Time1(_departure);
    }

    /**
     * Returns the flight duration time in minutes.
     * @return The flight duration
     */
    public int getFlightDuration() {
        return _flightDuration;
    }

    /**
     * Returns the number of passengers on the flight.
     * @return The number of passengers
     */
    public int getNoOfPassengers() {
        return _noOfPassengers;
    }

    /**
     * Returns whether the flight is full or not.
     * @return True if the flight is full.
     */
    public boolean getIsFull() {
        return _isFull;
    }

    /**
     * Returns the price of the flight.
     * @return The price
     */
    public int getPrice() {
        return _price;
    }

    /**
     * Returns the arrival time of the flight.
     * @return The arrival time of the flight.
     */
    public Time1 getArrivalTime() {
        return new Time1(this._departure.addMinutes(this._flightDuration));
    }

    //setters

    /**
     * Changes the flight's origin
     * @param origin The new origin.
     */
    public void setOrigin(String origin) {
        this._origin = origin;
    }

    /**
     * Changes the flight's destination.
     * @param dest The new destination
     */
    public void setDestination(String dest) {
        this._destination = dest;
    }

    /**
     * Changes the flight's departure time.
     * @param departureTime The new departure time.
     */
    public void setDeparture(Time1 departureTime) {
        this._departure = new Time1(departureTime);
    }

    /**
     * Changes the flight's duration. if the parameter is negative, the duration time will remain unchanged.
     * @param durTimeMinutes The new duration
     */
    public void setFlightDuration(int durTimeMinutes) {
        if (durTimeMinutes>=MIN_VAL) this._flightDuration = durTimeMinutes;
    }

    /**
     * Changes the number of passengers. If the parameter is negative or larger than the maximum capacity,
     * the number of passengers will remain unchanged.
     * @param noOfPass The new number of passengers
     */
    public void setNoOfPassengers(int noOfPass) {
        if (noOfPass>= MIN_VAL && noOfPass <= MAX_CAPACITY) this._noOfPassengers = noOfPass;
    }

    /**
     * Changes the flight's price. if the parameter is negative, the price will remain unchanged.
     * @param price The new price.
     */
    public void setPrice(int price) {
        this._price = Math.max(price, MIN_VAL);
    }

    /**
     * Check if the received flight is equal to this flight.
     * Flights are considered equal if the origin, destination and departure times are the same.
     * @param other The flight to be compared with this flight.
     * @return True if the received flight is equal to this flight.
     */
    public boolean equals(Flight other) {
        return (_origin.equals(other.getOrigin()) &&
                _destination.equals(other.getDestination()) &&
                _departure.equals(other.getDeparture()));
    }

    /**
     * Add passengers to this flight.
     * If the number of passengers exceeds he maximum capacity, no passengers are added and false is returned.
     * If the flight becomes full, the boolean attribute describing whether the flight is full becomes true.
     * @param num The number of passengers to be added to this flight.
     * @return True if the passengers were added to this flight.
     */
    public boolean addPassengers(int num) {
        if (_noOfPassengers + num <= MAX_CAPACITY) {
            this.setNoOfPassengers(_noOfPassengers+num);
            this._isFull = true;
            return true;
        }
        else
            return false;
    }

    /**
     * Check if this flight is cheaper than another flight.
     * @param other the flight whose price is to be compared with this flight's price.
     * @return True if this flight is cheaper than the received flight.
     */
    public boolean isCheaper(Flight other) {
        return (_price < other.getPrice());
    }

    /**
     * Calculate the total price of the flight.
     * @return The total price of the flight.
     */
    public int totalPrice() {
        return _noOfPassengers*_price;
    }

    /**
     * Check if this flight lands before another flight.
     * Note - the flights may land on different days, the method checks which flight lands first.
     * @param other The flight whose arrival time to be compared with this flight's arrival time.
     * @return True if this flight arrives before the received flight.
     */
    public boolean landsEarlier(Flight other) {
        return this.getArrivalTime().before(other.getArrivalTime());
    }

    /**
     * Return a string representation of this flight.
     * (e.g: "Flight from London to Paris departs at 09:24. Flight is full.").
     * @return String representation of this flight (e.g: "Flight from London to Paris departs at 09:24. Flight is full.").
     */
    @Override
    public String toString() {
        String tempF = (_isFull) ? "full" : "not full";
        return ("Flight from " + _origin + " to " + _destination + " departs at " + _departure + ". Flight is " + tempF);
    }
}
