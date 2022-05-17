/**
 * Represents an Airport object.
 * @author Ofek Efrat
 * @version 18/04/22
 */

public class Airport {
    //class vars
    private static final int MAX_FLIGHTS=200;
    private static final int NO_FLIGHTS=0;

    //instance vars
    private Flight[] _flightsSchedule;
    private int _noOfFlights;
    private String _city;

    //constructors

    /**
     * Constructor for an Airport object.
     * The name of the city in which the airport is stationed is passed as a string parameter.
     * The flight schedule can contain up to 200 flights.
     * @param city The city in which the airport is stationed.
     */
    public Airport(String city) {
        this._city = city;
        this._flightsSchedule = new Flight[MAX_FLIGHTS];
        this._noOfFlights = 0;
    }

    //methods


    /**
     * Adds a flight (either from or to the airport) to the schedule.
     * if the flight schedule is full, or if this airport
     * is neither this flight's origin nor its destination, the flight
     * will not be added, and the method returns false.
     * If the flight was added successfully, returns true.
     * @param flight The flight object to be added to the schedule.
     * @return True if the flight was added successfully.
     */
    public boolean addFlight(Flight flight) {
        if (_noOfFlights == MAX_FLIGHTS) return false;
        if (flight.getOrigin().equals(this._city) || flight.getDestination().equals(this._city)) {
            _flightsSchedule[_noOfFlights++] = new Flight(flight);
            return true;
        }
        return false;
    }

    /**
     * Removes a flight from the schedule.
     * if the flight was not found in the schedule, the method does nothing and returns false.
     * if the flight was removed successfully, returns true.
     * @param flight the flight object to be removed from the schedule.
     * @return True if the flight was removed successfully.
     */
    public boolean removeFlight(Flight flight) {
        if (_noOfFlights == NO_FLIGHTS) return false;
        for (int i = 0; i < _noOfFlights; i++) {
            if (_flightsSchedule[i].equals(flight)) {
                _flightsSchedule[i] = (i<_noOfFlights-1) ? _flightsSchedule[_noOfFlights-1] : null; //remove, fill the hole if not last.
                _noOfFlights--;
                return true;
            }
        }
        return false;
    }

    /**
     * Returns the flight that leaves at the earliest time from a certain place on the airport's schedule.
     * @param place The origin city from which to check earliest flight.
     * @return The earliest flight object from origin.
     */
    public Time1 firstFlightFromOrigin(String place) {
        if (_noOfFlights == NO_FLIGHTS) return null;
        Time1 earliest = null;
        for (int i = 0; i < _noOfFlights; i++) {
            if (_flightsSchedule[i].getOrigin().equals(place)) {
                if (earliest == null || _flightsSchedule[i].getDeparture().before(earliest)) {
                    earliest = _flightsSchedule[i].getDeparture();
                }
            }
        }
        if (earliest == null) return null;
        return new Time1(earliest);
    }

    /**
     * Returns the number of flights on the schedule that are full.
     * @return The number of full flights on the schedule.
     */
    public int howManyFullFlights() {
        if (_noOfFlights == NO_FLIGHTS) return 0;
        int count=0;
        for (int i = 0; i < _noOfFlights; i++) {
            if (_flightsSchedule[i].getIsFull()) count++;
        }
        return count;
    }

    /**
     * Returns the number of flights on the schedule which are either leaving from or landing at a certain place.
     * @param place The place to check for flight traffic.
     * @return The number of flights on the schedule which are passing through the given city.
     */
    public int howManyFlightsBetween(String place) {
        if (_noOfFlights == NO_FLIGHTS) return 0;
        int count=0;
        for (int i = 0; i < _noOfFlights; i++) {
            if (_flightsSchedule[i].getOrigin().equals(place) || _flightsSchedule[i].getDestination().equals(place)) {
                count++;
            }
        }
        return count;
    }

    private int howManyLandings(String place) { // private method to get landing count
        if (_noOfFlights == NO_FLIGHTS) return 0;
        int count=0;
        for (int i = 0; i < _noOfFlights; i++) {
            if (_flightsSchedule[i].getDestination().equals(place)) {
                count++;
            }
        }
        return count;
    }

    /**
     * Returns the destination, from the schedule, which has the most flights landing at it.
     * @return The destination with most landings on the schedule.
     */
    public String mostPopularDestination() {
        if (_noOfFlights == NO_FLIGHTS) return null;
        String[] destinations = new String[_noOfFlights]; // make array of unique destinations
        destinations[0] = (_flightsSchedule[0].getDestination());
        int destCount = 1;
        for (int i = 1; i < _noOfFlights; i++) {// fill up the array
            boolean flag = true;
            for (int j = 0; destinations[j] != null && flag; j++) {
                if (destinations[j].equals(_flightsSchedule[i].getDestination())) flag = false;
            }
            if (flag)
                destinations[destCount++] = _flightsSchedule[i].getDestination();
        }// end of destination array filler

        String mostPopular = destinations[0];
        for (int i = 1; i < destCount; i++) {
            if (this.howManyLandings(destinations[i]) > this.howManyLandings(mostPopular)) {
                mostPopular = destinations[i];
            }
        }
        return mostPopular;
    }

    /**
     * Returns the flight whose ticket is the most expensive from the schedule.
     * @return The flight with the most expensive ticket.
     */
    public Flight mostExpensiveTicket() {
        if (_noOfFlights == NO_FLIGHTS) return null;
        int maxPrice = 0;
        int maxInd = 0;
        for (int i = 0; i < _noOfFlights; i++) {
            if (_flightsSchedule[i].getPrice() > maxPrice) {
                maxPrice = _flightsSchedule[i].getPrice();
                maxInd = i;
            }
        }
        return new Flight(_flightsSchedule[maxInd]);
    }

    /**
     * Returns the flight whose duration is the longest.
     * @return The longest flight.
     */
    public Flight longestFlight() {
        if (_noOfFlights == NO_FLIGHTS) return null;
        int maxDuration = 0;
        int maxInd = 0;
        for (int i = 0; i < _noOfFlights; i++) {
            if (_flightsSchedule[i].getFlightDuration() > maxDuration) {
                maxDuration = _flightsSchedule[i].getFlightDuration();
                maxInd = i;
            }
        }
        return new Flight(_flightsSchedule[maxInd]);
    }

    /**
     * Returns a string representation of this airport and its flight schedule.
     * (e.g: The flights for airport London today are:
     *       and then a string representation of every flight on the schedule, each on a new line.)
     * @return String representation of this airport and its flight schedule. (see example in description)
     */
    @Override
    public String toString() {
        if (_noOfFlights == NO_FLIGHTS) return null;
        String s = "The flights for airport " + this._city + " today are:\n";
        for (int i = 0; i < _noOfFlights; i++) {
//            s = s.concat(_flightsSchedule[i].toString() + "\n");
            s += _flightsSchedule[i].toString() + "\n";
        }
        return s;
    }
}
