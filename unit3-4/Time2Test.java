

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class Time2Test.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class Time2Test
{
    /**
     * Default constructor for test class Time2Test
     */
    public Time2Test()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown()
    {
    }

    @Test
    public void equals()
    {
        Time2 time1 = new Time2(10, 55);
        Time2 time2 = new Time2(10, 55);
        assertEquals(true, time1.equals(time2));
        Time2 time3 = new Time2(18, 55);
        assertEquals(false, time3.equals(time1));
        assertEquals(false, time1.equals(time3));
        assertEquals(true, time1.equals(time1));
    }

    @Test
    public void setHour()
    {
        Time2 time = new Time2(10, 30);
        time.setHour(18);
        assertEquals(18, time.getHour());
        assertEquals(30, time.getMinute());
        time.setHour(0);
        assertEquals(0, time.getHour());
        assertEquals(30, time.getMinute());
        time.setHour(-1);
        assertEquals(0, time.getHour());
        assertEquals(30, time.getMinute());
        time.setHour(23);
        assertEquals(23, time.getHour());
        assertEquals(30, time.getMinute());
        time.setHour(24);
        assertEquals(23, time.getHour());
        assertEquals(30, time.getMinute());
        time.setHour(25);
        assertEquals(23, time.getHour());
        assertEquals(30, time.getMinute());
    }
    
    @Test
    public void setMinute()
    {
        Time2 time = new Time2(10, 30);
        time.setMinute(33);
        assertEquals(10, time.getHour());
        assertEquals(33, time.getMinute());
        time.setMinute(59);
        assertEquals(10, time.getHour());
        assertEquals(59, time.getMinute());
        time.setMinute(60);
        assertEquals(10, time.getHour());
        assertEquals(59, time.getMinute());
        time.setMinute(0);
        assertEquals(10, time.getHour());
        assertEquals(0, time.getMinute());
        time.setMinute(-1);
        assertEquals(10, time.getHour());
        assertEquals(0, time.getMinute());
    }

    @Test
    public void getHour()
    {
        Time2 time1 = new Time2(10, 30);
        assertEquals(10, time1.getHour());
        Time2 time2 = new Time2(19, 03);
        assertEquals(19, time2.getHour());
        Time2 time3 = new Time2(-1, 65);
        assertEquals(0, time3.getHour());
    }

    @Test
    public void getMinute()
    {
        Time2 time1 = new Time2(10, 30);
        assertEquals(30, time1.getMinute());
        Time2 time2 = new Time2(19, 3);
        assertEquals(3, time2.getMinute());
        Time2 time3 = new Time2(-1, 65);
        assertEquals(0, time3.getMinute());
    }
    
    @Test
    public void string() {
        Time2 time = new Time2(2, 15);
        assertEquals("02:15", time.toString());
        
        time.setMinute(9);
        assertEquals("02:09", time.toString());
        
        time.setHour(23);
        assertEquals("23:09", time.toString());
    }
    
    @Test
    public void addMinutes() {
        Time2 time = new Time2(2, 15);
        
        // Positive
        time = time.addMinutes(3);
        assertEquals(2, time.getHour());
        assertEquals(18, time.getMinute());
        
        time = time.addMinutes(63);
        assertEquals(3, time.getHour());
        assertEquals(21, time.getMinute());
        
        // Negative
        time = time.addMinutes(-3);
        assertEquals(3, time.getHour());
        assertEquals(18, time.getMinute());
        
        time = time.addMinutes(-63);
        assertEquals(2, time.getHour());
        assertEquals(15, time.getMinute());
        
        // Positive overflow
        time = time.addMinutes(23 * 60);
        assertEquals(1, time.getHour());
        assertEquals(15, time.getMinute());
        
        time = time.addMinutes(48 * 60);
        assertEquals(1, time.getHour());
        assertEquals(15, time.getMinute());
        
        time = time.addMinutes(100 * 60 + 26);
        assertEquals(5, time.getHour());
        assertEquals(41, time.getMinute());
        
        // Negative overflow
        time = time.addMinutes(-6);
        assertEquals(5, time.getHour());
        assertEquals(41 - 6, time.getMinute());
        
        time = time.addMinutes(-48 * 60);
        assertEquals(5, time.getHour());
        assertEquals(41 - 6, time.getMinute());

        time.setHour(12);
        time.setMinute(40);;
        time = time.addMinutes(-765);
        assertEquals(23, time.getHour());
        assertEquals(55, time.getMinute());
        System.out.println(time);

        // Positive?
        time.setHour(23);
        time.setMinute(30);
        time = time.addMinutes(60);
        assertEquals(0, time.getHour());
        assertEquals(30, time.getMinute());

    }
    
    @Test
    public void duplicate() {
        Time2 time1 = new Time2(2, 15);
        Time2 time2 = new Time2(time1);
        
        assertEquals(2, time2.getHour());
        assertEquals(15, time2.getMinute());
        
        time1.setHour(5);
        assertEquals(2, time2.getHour());
        
        time1.setMinute(9);
        assertEquals(15, time2.getMinute());
    }
    
    @Test
    public void before() {
        Time2 time1 = new Time2(2, 15);
        Time2 time2 = new Time2(2, 15);
        
        assertFalse(time1.before(time2));
        assertFalse(time2.before(time1));
        
        time2 = new Time2(2, 16);
        assertTrue(time1.before(time2));
        assertFalse(time2.before(time1));
        
        time2 = new Time2(3, 14);
        assertTrue(time1.before(time2));
        assertFalse(time2.before(time1));
        
        time2 = new Time2(2, 14);
        assertFalse(time1.before(time2));
        assertTrue(time2.before(time1));
        
        time2 = new Time2(4, 16);
        assertTrue(time1.before(time2));
        assertFalse(time2.before(time1));
    }
}





