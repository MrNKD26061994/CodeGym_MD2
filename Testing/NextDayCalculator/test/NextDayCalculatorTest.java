import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class NextDayCalculatorTest {

    @Test
    public void testNextDayPassMonth() {

        MyDate date = new MyDate(31, 3, 2104);
        date.nextDay();
        MyDate expected = new MyDate(1, 4, 2104);

        assertEquals(date.getDay(), expected.getDay());
        assertEquals(date.getMonth(), expected.getMonth());
        assertEquals(date.getYear(), expected.getYear());
//        assertTrue(date.equals(expected));
    }


}
