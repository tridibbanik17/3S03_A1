package ca.mcmaster.sfwreng3s03;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class Program1Test {

    // (b) Does NOT execute the fault
    @Test
    void valueFoundBeforeIndexZero() {
        int[] x = {2, 3, 5};
        assertEquals(2, A1_Q2_Program1_Incorrect.findLast(x, 5));
    }

    // (c) Executes the fault but no error state
    @Test
    void elementAbsent() {
        int[] x = {2, 3, 5};
        assertEquals(-1, A1_Q2_Program1_Incorrect.findLast(x, 4));
    }

    // (d) Not possible: any error state causes failure
    //     because skipping index 0 changes the correct result.

}