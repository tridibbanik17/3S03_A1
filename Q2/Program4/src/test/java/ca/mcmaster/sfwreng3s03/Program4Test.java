package ca.mcmaster.sfwreng3s03;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class Program4Test {

    // (b) Does NOT execute the fault (no negative odd numbers)
    @Test
    void noNegativeOddNumbers() {
        int[] x = {2, 4, 1};
        assertEquals(3, A1_Q2_Program4_Incorrect.oddOrPos(x));
    }

    // (c) Executes the fault but no error state (empty array)
    @Test
    void emptyArray() {
        int[] x = {};
        assertEquals(0, A1_Q2_Program4_Incorrect.oddOrPos(x));
    }

    // (d) Not possible: any error state causes a failure
    //     because missing a negative odd number always
    //     decreases the final count incorrectly.
}