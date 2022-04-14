import java.util.Arrays;

/**
 * Represents an Airport object.
 * @author Ofek Efrat
 * @version 14/04/22
 */
public class Airport {
    //class vars
    private static final int MAX_FLIGHTS=200;
    private static final int MIN_FLIGHTS=0;

    //instance vars
    private Flight[] _flightsSchedule;
    private int _noOfFlights;
    private String _city;

    //constructors
    public Airport(String city) {
        this._city = city;
        this._flightsSchedule = new Flight[MAX_FLIGHTS];
        this._noOfFlights = 0;
    }

    //methods
    public boolean addFlight(Flight flight) {
        if (_noOfFlights == MAX_FLIGHTS) return false;
        if (flight.getOrigin().equals(this._city) || flight.getDestination().equals(this._city)) {
            _flightsSchedule[_noOfFlights++] = new Flight(flight);
            return true;
        }
        return false;
    }

    public boolean removeFlight(Flight flight) {
        if (_noOfFlights == MIN_FLIGHTS) return false;
        for (int i = 0; i < _noOfFlights; i++) {
            if (_flightsSchedule[i].equals(flight)) {
                _flightsSchedule[i] = (i<_noOfFlights-1) ? _flightsSchedule[_noOfFlights-1] : null; //remove, fill the hole if not last.
                _noOfFlights--;
                return true;
            }
        }
        return false;
    }

    public Time1 firstFlightFromOrigin(String place) {
        if (_noOfFlights == MIN_FLIGHTS) return null;
        Time1 earliest = null;
        for (int i = 0; i < _noOfFlights; i++) {
            if (_flightsSchedule[i].getOrigin().equals(place)) {
                if (earliest == null || _flightsSchedule[i].getDeparture().before(earliest)) {
                    earliest = _flightsSchedule[i].getDeparture();
                }
            }
        }
        if (earliest != null) return new Time1(earliest);
        return null;
    }

    public int howManyFullFlights() {
        if (_noOfFlights == MIN_FLIGHTS) return 0;
        int count=0;
        for (int i = 0; i < _noOfFlights; i++) {
            if (_flightsSchedule[i].getIsFull()) count++;
        }
        return count;
    }

    public int howManyFlightsBetween(String place) {
        if (_noOfFlights == MIN_FLIGHTS) return 0;
        int count=0;
        for (int i = 0; i < _noOfFlights; i++) {
            if (_flightsSchedule[i].getOrigin().equals(place) || _flightsSchedule[i].getDestination().equals(place)) {
                count++;
            }
        }
        return count;
    }

    private int howManyLandings(String place) { // private method to get landing count
        if (_noOfFlights == MIN_FLIGHTS) return 0;
        int count=0;
        for (int i = 0; i < _noOfFlights; i++) {
            if (_flightsSchedule[i].getDestination().equals(place)) {
                count++;
            }
        }
        return count;
    }

    public String mostPopularDestination() {
        if (_noOfFlights == MIN_FLIGHTS) return null;
        String[] destinations = new String[_noOfFlights]; // make list of all destinations
        destinations[0] = (_flightsSchedule[0].getDestination());
        int destCount = 1;
        for (int i = 1; i < _noOfFlights; i++) {// fill up the list
            boolean flag = true;
            for (int j = 0; destinations[j] != null && flag; j++) {
                if (destinations[j].equals(_flightsSchedule[i].getDestination())) flag = false;
            }
            if (flag)
                destinations[destCount++] = _flightsSchedule[i].getDestination();
        }// end of destination list filler

        String mostPopular = destinations[0];
        int maxFlights = this.howManyLandings(destinations[0]);
        for (int i = 1; i < destCount; i++) {
            if (this.howManyLandings(destinations[i]) > this.howManyLandings(mostPopular)) {
                maxFlights = this.howManyLandings(destinations[i]);
                mostPopular = destinations[i];
            }
        }
        return mostPopular;
    }

    public Flight mostExpensiveTicket() {
        if (_noOfFlights == MIN_FLIGHTS) return null;
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

    public void longestFlight() {}

    @Override
    public String toString() {
        String s = "The flights for airport " + this._city + " today are:\n";
        for (int i = 0; i < _noOfFlights; i++) {
            s = s.concat(_flightsSchedule[i].toString() + "\n");
        }
        return s;
    }
}
