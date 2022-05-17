import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
/**
 * The test class Time1Test.
 *
 * @author  Beery Shklar
 * @version 29.3.2022
 */
public class Time1Test
{
    
    @Test
    public void getTime() {
        Time1 time = new Time1(2, 15);
        assertEquals(2, time.getHour());
        assertEquals(15, time.getMinute());
    }

    @Test
    public void setTime() {
        Time1 time = new Time1(2, 15);
        // General Test
        time.setHour(22);
        time.setMinute(3);

        assertEquals(22, time.getHour());
        assertEquals(3, time.getMinute());

        // Test setHour
        time.setHour(25);
        assertEquals(22, time.getHour());

        time.setHour(24);
        assertEquals(22, time.getHour());

        time.setHour(0);
        assertEquals(0, time.getHour());

        time.setHour(22);
        assertEquals(22, time.getHour());

        time.setHour(-1);
        assertEquals(22, time.getHour());
        time.setHour(-12);
        assertEquals(22, time.getHour());

        // test setMinute
        time.setMinute(61);
        assertEquals(3, time.getMinute());

        time.setMinute(60);
        assertEquals(3, time.getMinute());

        time.setMinute(0);
        assertEquals(0, time.getMinute());

        time.setMinute(3);
        assertEquals(3, time.getMinute());

        time.setMinute(-1);
        assertEquals(3, time.getMinute());
        time.setMinute(-12);
        assertEquals(3, time.getMinute());
    }

    @Test
    public void string() {
        Time1 time = new Time1(2, 15);
        assertEquals("02:15", time.toString());

        time.setMinute(9);
        assertEquals("02:09", time.toString());

        time.setHour(23);
        assertEquals("23:09", time.toString());
    }

    @Test
    public void addMinutes() {
        Time1 time = new Time1(2, 15);

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
        time.setMinute(40);
        time = time.addMinutes(-765);
        assertEquals(23, time.getHour());
        assertEquals(55, time.getMinute());
    }

    @Test
    public void duplicate() {
        Time1 time1 = new Time1(2, 15);
        Time1 time2 = new Time1(time1);

        assertEquals(2, time2.getHour());
        assertEquals(15, time2.getMinute());

        time1.setHour(5);
        assertEquals(2, time2.getHour());

        time1.setMinute(9);
        assertEquals(15, time2.getMinute());
    }

    @Test
    public void equals() {
        Time1 time1 = new Time1(2, 15);
        Time1 time2 = new Time1(2, 15);
        Time1 time3 = new Time1(time1);
        Time1 time4 = new Time1(23, 15);
        Time1 time5 = new Time1(2, 6);
        Time1 time6 = new Time1(23, 6);

        assertTrue(time1.equals(time2));
        assertTrue(time1.equals(time3));

        assertFalse(time1.equals(time4));
        assertFalse(time1.equals(time5));
        assertFalse(time1.equals(time6));

        time1.setHour(4);
        assertFalse(time1.equals(time3));
    }

    @Test
    public void before() {
        Time1 time1 = new Time1(2, 15);
        Time1 time2 = new Time1(2, 15);

        assertFalse(time1.before(time2));
        assertFalse(time2.before(time1));

        time2 = new Time1(2, 16);
        assertTrue(time1.before(time2));
        assertFalse(time2.before(time1));

        time2 = new Time1(3, 14);
        assertTrue(time1.before(time2));
        assertFalse(time2.before(time1));

        time2 = new Time1(2, 14);
        assertFalse(time1.before(time2));
        assertTrue(time2.before(time1));

        time2 = new Time1(4, 16);
        assertTrue(time1.before(time2));
        assertFalse(time2.before(time1));
    }
}
