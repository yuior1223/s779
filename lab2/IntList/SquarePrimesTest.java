package IntList;

import static org.junit.Assert.*;
import org.junit.Test;

public class SquarePrimesTest {

    /**
     * Here is a test for isPrime method. Try running it.
     * It passes, but the starter code implementation of isPrime
     * is broken. Write your own JUnit Test to try to uncover the bug!
     */
    @Test
    public void testSquarePrimesSimple() {
        IntList lst = IntList.of(14, 15, 16, 17, 18, 19);
        boolean changed = IntListExercises.squarePrimes(lst);
        assertEquals("14 -> 15 -> 16 -> 289 -> 18 -> 361", lst.toString());
        assertTrue(changed);
    }

    @Test
    public void testSquarePrimesSimple2() {
        IntList lst = IntList.of(22,23,24,25,26,27,28,29,30);
        boolean changed = IntListExercises.squarePrimes(lst);
        assertEquals("22 -> 529 -> 24 -> 25 -> 26 -> 27 -> 28 -> 841 -> 30", lst.toString());
        assertTrue(changed);
    }
}
