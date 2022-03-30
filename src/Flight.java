/**
 * Represents a flight.
 * @author Ofek Efrat
 * @version 30/03/22
 */
public class Flight {
    //class variable
    private static final int MAX_CAPACITY = 250;// maximum passenger capacity
    private static final int MIN_VAL = 0; // no numbers, huh?

    //instance variables
    private String _origin, _destination; // names of flight origin and destination cities
    private Time1 _departure; // time of departure as an object of the Time1 class
    private int _flightDuration, _noOfPassengers, _price;
    private boolean _isFull;

    //constructors
    public Flight(String origin, String destination, int depHour, int depMinute, int flightDuration, int noOfPassengers, int price) {
        _departure = new Time1(depHour, depMinute);// using a different Time1 constructor from the one in setter method.
        this.setOrigin(origin);
        this.setDestination(destination);
        this.setFlightDuration(flightDuration);
        this.setPrice(price);
        this.setNoOfPassengers(noOfPassengers);
    }

    public Flight(Flight other) { //copy constructor
        _origin = other.getOrigin();
        _destination = other.getDestination();
        _departure = new Time1(other.getDeparture());
        _flightDuration = other.getFlightDuration();
        _noOfPassengers = other.getNoOfPassengers();
        _price = other.getPrice();
        _isFull = other.getIsFull();
    }

    //methods
        //getters
    public String getOrigin() {
        return _origin;
    }

    public String getDestination() {
        return _destination;
    }

    public Time1 getDeparture() {
        return new Time1(_departure);
    }

    public int getFlightDuration() {
        return _flightDuration;
    }

    public int getNoOfPassengers() {
        return _noOfPassengers;
    }

    public int getPrice() {
        return _price;
    }

    public boolean getIsFull() {
        return _isFull;
    }

    public Time1 getArrivalTime() {
        return new Time1(_departure.addMinutes(_flightDuration));
    }

        //setters
    public void setOrigin(String origin) {
        _origin = origin;
    }

    public void setDestination(String destination) {
        _destination = destination;
    }

    public void setDeparture(Time1 departure) {
        _departure = new Time1(departure);// no aliasing ok? ok.
    }

    public void setFlightDuration(int flightDuration) {
        _flightDuration = Math.max(flightDuration, MIN_VAL);// using Math.max method to save the turtles
    }

    public void setNoOfPassengers(int noOfPassengers) {
        _noOfPassengers = Math.max(noOfPassengers, MIN_VAL);
        if (noOfPassengers>=MAX_CAPACITY) {
            _noOfPassengers = MAX_CAPACITY;
            _isFull = true;
        }
    }

    public void setPrice(int price) {
        _price = Math.max(price, MIN_VAL);// another happy turtle
    }

    public boolean equals(Flight other) {
        if (!_origin.equals(other.getOrigin())) return false;
        if (!_destination.equals(other.getDestination())) return false;
        return _departure.equals(other.getDeparture());
    }

    public boolean addPassengers(int num) {
        if (_noOfPassengers + num <= MAX_CAPACITY) {
            this.setNoOfPassengers(_noOfPassengers+num);
            return true;
        }
        else
            return false;
    }

    public boolean isCheaper(Flight other) {
        return (_price < other.getPrice());
    }

    public int totalPrice() {
        return _noOfPassengers*_price;
    }

    public boolean landsEarlier(Flight other) {
        return this.getArrivalTime().before(other.getArrivalTime());
    }

    @Override
    public String toString() {
        String tempF = (_isFull) ? "full" : "not full";
        return ("Flight from " + _origin + " to " + _destination + " departs at " + _departure + ". Flight is " + tempF);
    }
}
