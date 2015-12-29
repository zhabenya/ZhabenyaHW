package homework1;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by zhabenya on 29.12.15.
 */
public class MyArrayTest {


    MyArray myArray;
    int[] array = {3, 7, 9, 1};

    @Before
    public void setUp() throws Exception{
        myArray = new MyArray(array);
    }

    @Test
    public void testShowArray() throws Exception {
        assertEquals("{ 3 7 9 1 }", myArray.showArray(myArray.getAbsArray()));
    }

    @Test
    public void testFindArrayMin() throws Exception {
        assertEquals(1, myArray.findArrayMin());
    }

    @Test
    public void testFindArrayMax() throws Exception {
        assertEquals(9, myArray.findArrayMax());
    }

    @Test
    public void testFillArrayRandomly() throws Exception {
        int[] arrayRandomly = myArray.fillArrayRandomly();
        assertNotNull(arrayRandomly);
        assertEquals(myArray.getArraySize(), arrayRandomly.length);
    }

    @Test
    public void testSortArrayIncreasing() throws Exception {
        int[] sorted = myArray.sortArrayIncreasing();
        for (int i = 0; i < sorted.length - 1; i++) {
            assertTrue(sorted[i] <= sorted[i + 1]);
        }
    }

    @Test
    public void testSortArrayDecreasing() throws Exception {
        int[] sorted = myArray.sortArrayDecreasing();
        for (int i = 0; i < sorted.length - 1; i++) {
            assertTrue(sorted[i] >= sorted[i + 1]);
        }
    }

    @Test
    public void testCompareArraysLengthEqual() throws Exception {
        assertFalse(myArray.compareArraysLengthEqual(new int[]{1, 1, 1, 1, 1}));
        assertTrue(myArray.compareArraysLengthEqual(new int[]{1, 1, 1, 1}));
    }

    @Test
    public void testCompareArraysEqual() throws Exception {
        assertFalse(myArray.compareArraysEqual(new int[]{1, 1, 1, 1, 1}));
        assertTrue(myArray.compareArraysEqual(array));
    }

    @Test
    public void testAddElementToArray() throws Exception {
        assertEquals("{ 3 7 9 1 8 }", myArray.showArray(myArray.addElementToArray(8)));
    }

}