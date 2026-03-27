package ca.mcmaster.sfwreng3s03;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

class Program1Test {

    // (b) Does NOT execute the fault
    // Null input throws NullPointerException before the loop condition
    // i > 0 is ever evaluated — fault is never reached
    @Test
    void nullInputDoesNotExecuteFault() {
        assertThrows(NullPointerException.class, () -> {
            A1_Q2_Program1_Incorrect.findLast(null, 5);
        });
    }

    // (c) Executes the fault but does NOT result in an error state
    // y=5 is found at index 2, method returns before i=0 is reached.
    // The faulty condition i > 0 is evaluated but never affects
    // the internal state — index 0 is irrelevant for this input.
    @Test
    void valueFoundAtLaterIndex() {
        int[] x = {2, 3, 5};
        assertEquals(2, A1_Q2_Program1_Incorrect.findLast(x, 5));
    }

    // (d) Reaches an error state but NOT a failure
    // y=7 is absent from x. The faulty condition i > 0 causes the loop
    // to exit at i=1, skipping index 0 — wrong program counter (error state).
    // However, since y=7 is not at index 0 either, output is still -1 — no failure.
    @Test
    void elementAbsentNoFailure() {
        int[] x = {2, 3, 5};
        assertEquals(-1, A1_Q2_Program1_Incorrect.findLast(x, 7));
    }
}
