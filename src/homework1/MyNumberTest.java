package homework1;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

/**
 * Created by zhabenya on 29.12.15.
 */
public class MyNumberTest {

    MyNumber number = new MyNumber();
    int value1;
    int value2;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Before
    public void setUp() throws Exception {
        number.value = 5;
        value1 = 0;
        value2 = 7;
    }

    @Test
    public void testAddNumbers() throws Exception {
        assertEquals(5, number.addNumbers(value1));
        assertEquals(12, number.addNumbers(value2));
    }

    @Test
    public void testSubtractNumbers() throws Exception {
        assertEquals(5, number.subtractNumbers(value1));
        assertEquals(-2, number.subtractNumbers(value2));
    }

    @Test
    public void testMultiplyNumbers() throws Exception {
        assertEquals(0, number.multiplyNumbers(value1));
        assertEquals(35, number.multiplyNumbers(value2));
    }

    @Test
    public void testDivideNumbers() throws Exception {
        assertEquals(0, number.divideNumbers(value2));

        exception.expect(IllegalArgumentException.class);
        number.divideNumbers(value1);
    }

    @Test
    public void testPowerNumbers() throws Exception {
        assertEquals(1, number.powerNumbers(value1));
        assertEquals(78125, number.powerNumbers(value2));
    }

    @Test
    public void testFactorialNumber() throws Exception {
        assertEquals(120, number.factorialNumber());
    }

    @Test
    public void testModuloNumbers() throws Exception {
        assertEquals(5, number.moduloNumbers(value2));

        exception.expect(IllegalArgumentException.class);
        number.divideNumbers(value1);
    }

    @Test
    public void testFindLargerNumber() throws Exception {
        assertEquals(number.value, number.findLargerNumber(value1));
        assertEquals(value2, number.findLargerNumber(value2));
        assertEquals(5, number.findLargerNumber(5));
    }

    @Test
    public void testFindSmallerNumber() throws Exception {
        assertEquals(value1, number.findSmallerNumber(value1));
        assertEquals(number.value, number.findSmallerNumber(value2));
        assertEquals(5, number.findSmallerNumber(5));
    }
}