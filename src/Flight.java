/**
 * Represents a flight object.
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
    public Flight(String origin, String dest, int depHour, int depMinute,
                  int depTimeMinutes, int noOfPass, int price) {
        this._departure = new Time1(depHour, depMinute);
        this._origin = origin;
        this._destination = dest;
        this._flightDuration = Math.max(depTimeMinutes, MIN_VAL);
        this._price = Math.max(price, MIN_VAL);
        if (noOfPass>=MAX_CAPACITY) setNoOfPassengers(MAX_CAPACITY);
    }

    public Flight(Flight other) { //copy constructor
        this._origin = other.getOrigin();
        this._destination = other.getDestination();
        this._departure = new Time1(other.getDeparture());
        this._flightDuration = other.getFlightDuration();
        this._noOfPassengers = other.getNoOfPassengers();
        this._price = other.getPrice();
        this._isFull = other.getIsFull();
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
        if (noOfPassengers <= MAX_CAPACITY) _noOfPassengers = noOfPassengers;
        if (noOfPassengers == MAX_CAPACITY) _isFull = true;
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
