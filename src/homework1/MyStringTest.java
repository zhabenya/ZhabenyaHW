package homework1;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by zhabenya on 30.12.15.
 */
public class MyStringTest {

    MyString myString;
    char[] charArray = {'k', 'e', 'e', 'p', ' ', 'C', 'a', 'l', 'm'};

    @Before
    public void setUp() throws Exception {
        myString = new MyString(charArray);
    }

    @Test
    public void testConcatString() throws Exception {
        char[] actual = myString.concatString(" and study");
        assertEquals("keep Calm and study", myString.toString(actual));
    }

    @Test
    public void testMakeAllBigLetters() throws Exception {
        char[] actual = myString.makeAllBigLetters();
        assertEquals("KEEP CALM", myString.toString(actual));
    }

    @Test
    public void testMakeAllSmallLetters() throws Exception {
        char[] actual = myString.makeAllSmallLetters();
        assertEquals("keep calm", myString.toString(actual));
    }

    @Test
    public void testContains() throws Exception {
        assertTrue(myString.contains("eep C"));
        assertFalse(myString.contains("eq"));
    }

    @Test
    public void testFindAndShowInString() throws Exception {
        char[] actual = myString.findAndShowInString("eep");
        assertEquals("kEEP Calm", myString.toString(actual));
    }

    @Test
    public void testRemoveSpaces() throws Exception {
        char[] actual = myString.removeSpaces();
        assertEquals("keepCalm", myString.toString(actual));
    }

    @Test
    public void testCompareWithStringByLength() throws Exception {
        assertTrue(myString.compareWithStringByLength("studyJava"));
        assertFalse(myString.compareWithStringByLength("java"));
    }
}