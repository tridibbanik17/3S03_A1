package ca.mcmaster.sfwreng3s03;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class Program3Test {

    // (b) Does NOT execute the fault (no zeros present)
    @Test
    void noZerosPresent() {
        int[] x = {-3, 2, 5};
        assertEquals(2, A1_Q2_Program3_Incorrect.countPositive(x));
    }

    // (c) Executes the fault but no error state (empty array)
    @Test
    void emptyArray() {
        int[] x = {};
        assertEquals(0, A1_Q2_Program3_Incorrect.countPositive(x));
    }

    // (d) Not possible: any error state causes a failure
    //     because counting zero as positive always increases
    //     the returned value incorrectly.
}