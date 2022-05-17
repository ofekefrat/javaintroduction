import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

/**
 * Different tests for the Flight class.
 *
 * @author  Binyamin Lebedev
 * @version 3.4.2022
 */

public class FlightTesting{
    
    ////////////// Flight Tests

    private Flight flight1,flight2,flight3;
    private String origin,dest;
    private boolean simpleEqual,trueEqual;
    private Time1 time;

    @BeforeEach
    public void setUp(){
        flight1 = new Flight("New York", "Paris", 1, 0, 180, 200, 1200);
        flight2 = new Flight("Moscow", "Saint Peterburg", 5, 30, 90, 250, 1300);
        time = new Time1(0,0);
    }

    @Test
    @DisplayName("Testing construction of flight and getter methods")
    public void Constructor(){
        

        assertEquals("New York",flight1.getOrigin(),"getting the origin should work");
        assertEquals("Paris",flight1.getDestination(),"getting the Destination should work");
        assertEquals("01:00",flight1.getDeparture().toString(),"getting the departure time should work");
        assertEquals(180,flight1.getFlightDuration(),"getting the duration should work");
        assertEquals(200,flight1.getNoOfPassengers(),"getting the num of passengers should work");
        assertEquals(false,flight1.getIsFull(),"getting the full flight flag should give what we want");
        assertEquals(1200,flight1.getPrice(),"getting the price should work");

        flight3 = new Flight(flight2);
        assertEquals("Moscow",flight3.getOrigin(),"getting the origin should work");
        assertEquals("Saint Peterburg",flight3.getDestination(),"getting the Destination should work");
        assertEquals("05:30",flight3.getDeparture().toString(),"getting the departure time should work");
        assertEquals(90,flight3.getFlightDuration(),"getting the duration should work");
        assertEquals(250,flight3.getNoOfPassengers(),"getting the num of passengers should work");
        assertEquals(true,flight3.getIsFull(),"getting the full flight flag should give what we want");
        assertEquals(1300,flight3.getPrice(),"getting the price should work");

        // checking aliasing for the strings
        origin = flight1.getOrigin();
        dest = flight1.getDestination();
        assertEquals("New York",origin);
        assertEquals("Paris",dest);
//        simpleEqual = origin == flight1.getOrigin();
        trueEqual = dest.equals(flight1.getDestination());
//        assertFalse(simpleEqual);
        assertTrue(trueEqual);

        // checking aliasing for _departure
        time = flight1.getDeparture();
        assertEquals("01:00", time.toString());
        simpleEqual = time == flight1.getDeparture();
        trueEqual = time.equals(flight1.getDeparture());
        assertFalse(simpleEqual);
        assertTrue(trueEqual);
    }

    @Test
    @DisplayName("Testing setOrigin and SetDestination")
    public void setOriginDest(){

        /// checking setters for origin and destination
        flight2.setOrigin("Tel Aviv");
        flight2.setDestination("Rome");
        assertEquals("Tel Aviv",flight2.getOrigin());
        assertEquals("Rome",flight2.getDestination());
    }

    @Test
    @DisplayName("Testing setDeparture - including aliasing")
    public void setDeparture(){

        time = new Time1(6,10);
        flight2.setDeparture(time);
        simpleEqual = time == flight2.getDeparture();
        trueEqual = time.equals(flight2.getDeparture());
        assertEquals("06:10",flight2.getDeparture().toString());
        assertFalse(simpleEqual);
        assertTrue(trueEqual);
    }

    @Test
    @DisplayName("Testing setFlightDuration")
    public void setFlightDuration(){

        /// checking setFlightDuration
        flight2.setFlightDuration(0);
        assertEquals(0,flight2.getFlightDuration());
        flight2.setFlightDuration(-50);
        assertEquals(0,flight2.getFlightDuration());
        flight2.setFlightDuration(200);
        assertEquals(200,flight2.getFlightDuration());
    }

    @Test
    @DisplayName("Testing setNoOfPassengers")
    public void setNoOfPassengers(){

        /// checking setNoOfPassengers
        flight2.setNoOfPassengers(180);
        assertEquals(180,flight2.getNoOfPassengers());
        assertEquals(false,flight2.getIsFull());
        flight2.setNoOfPassengers(0);
        assertEquals(0,flight2.getNoOfPassengers());
        assertEquals(false,flight2.getIsFull());
        flight2.setNoOfPassengers(-50);
        assertEquals(0,flight2.getNoOfPassengers());
        assertEquals(false,flight2.getIsFull());
        flight2.setNoOfPassengers(350);
        assertEquals(0,flight2.getNoOfPassengers());
        assertEquals(false,flight2.getIsFull());
        flight2.setNoOfPassengers(250);
        assertEquals(250,flight2.getNoOfPassengers());
        assertEquals(true,flight2.getIsFull());
    }

    @Test
    @DisplayName("Testing setPrice")
    public void setPrice(){
    
        /// checking setPrice
        flight2.setPrice(0);
        assertEquals(0,flight2.getPrice());
        flight2.setPrice(-50);
        assertEquals(0,flight2.getPrice());
        flight2.setPrice(1500);
        assertEquals(1500,flight2.getPrice());
    }

    @Test
    @DisplayName("Testing equals for Flight")
    public void equalsFlight(){

        flight3 = new Flight(flight2);
        assertFalse(flight1.equals(flight2));
        assertTrue(flight3.equals(flight2));
    }

    @Test
    @DisplayName("Testing getArrivalTime")
    public void getArrivalTime(){
        time = new Time1(4,0);
        trueEqual = flight1.getArrivalTime().equals(time);
        assertEquals(true, trueEqual);

        time = new Time1(22,0);
        flight1.setDeparture(time);
        
        flight1.setFlightDuration(4*60 + 0);
        time = new Time1(2,0);
        trueEqual = flight1.getArrivalTime().equals(time);
        assertEquals(true, trueEqual);

        flight1.setDeparture(time);
        flight1.setFlightDuration(23*60 + 15);
        trueEqual = flight1.getArrivalTime().equals(new Time1(1,15));
        assertEquals(true, trueEqual);

    }

    @Test
    @DisplayName("Testing addPassengers")
    public void addPassengers(){
        

        assertFalse(flight1.addPassengers(100));
        assertTrue(flight1.addPassengers(30));
        assertFalse(flight2.addPassengers(1));
        assertFalse(flight2.addPassengers(200));
        //assertTrue(flight2.addPassengers(0));
        //assertFalse(flight1.addPassengers(-30));
    }

    @Test
    @DisplayName("Testing isCheaper")
    public void isCheaper(){
        assertTrue(flight1.isCheaper(flight2));
        flight3 = new Flight(flight2);
        assertFalse(flight3.isCheaper(flight2));

    }

    @Test
    @DisplayName("Testing totalPrice")
    public void totalPrice(){

        assertEquals(240000, flight1.totalPrice());
        assertEquals(325000, flight2.totalPrice());
    }

    @Test
    @DisplayName("Testing landsEarlier")
    public void landsEarlier(){
        assertTrue(flight1.landsEarlier(flight2));
        assertFalse(flight1.landsEarlier(flight1));

        flight1.setDeparture(new Time1(22,30));
        flight1.setFlightDuration(3*60 + 15);
        flight2.setDeparture(new Time1(21,45));
        flight2.setFlightDuration(2*60 + 0);
        assertTrue(flight1.landsEarlier(flight2));
    }

    @Test
    @DisplayName("Testing toString of class Flight")
    public void toStringFlight(){
        // flight1 = new Flight("New York", "Paris", 1, 0, 180, 200, 1200);
        // flight2 = new Flight("Moscow", "Saint Peterburg", 5, 30, 90, 250, 1300);

        String str1 = "Flight from New York to Paris departs at 01:00. Flight is not full.";
        String str2 = "Flight from Moscow to Saint Peterburg departs at 05:30. Flight is full.";

        assertTrue(str1.equals(flight1.toString()));
        assertTrue(str2.equals(flight2.toString()));
    }

}