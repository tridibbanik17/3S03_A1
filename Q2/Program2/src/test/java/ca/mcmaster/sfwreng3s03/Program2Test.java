package ca.mcmaster.sfwreng3s03;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class Program2Test {

    // (b) Does NOT execute the fault (only one zero)
    @Test
    void singleZero() {
        int[] x = {1, 0, 2};
        assertEquals(1, A1_Q2_Program2_Incorrect.lastZero(x));
    }

    // (c) Executes the fault but no error state (no zero present)
    @Test
    void noZeroPresent() {
        int[] x = {1, 2, 3};
        assertEquals(-1, A1_Q2_Program2_Incorrect.lastZero(x));
    }

    // (d) Not possible: any error state causes a failure
    //     because returning the first zero instead of the last
    //     always violates the specification.
}