package ca.mcmaster.sfwreng3s03;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

class Program2Test {

    // (b) Does NOT execute the fault
    // Null input throws NullPointerException before the loop initializes.
    // The faulty forward traversal (i = 0) is never set up — fault not executed.
    @Test
    void nullInputDoesNotExecuteFault() {
        assertThrows(NullPointerException.class, () -> {
            A1_Q2_Program2_Incorrect.lastZero(null);
        });
    }

    // (c) Executes the fault but does NOT result in an error state
    // The TA confirmed this case does not exist for Program 2 —
    // all non-null inputs execute the fault AND produce an error state
    // because the wrong traversal direction always produces an incorrect
    // internal program counter, except when x is null.
    // Closest valid case: single element array with no zero.
    // Fault executes, but traversal direction does not affect the result
    // since there is only one element to check either way.
    @Test
    void singleElementNoZero() {
        int[] x = {1};
        assertEquals(-1, A1_Q2_Program2_Incorrect.lastZero(x));
    }

    // (d) Reaches an error state but NOT a failure
    // x={1,0,3}: faulty forward traversal finds zero at index 1.
    // Error state exists (wrong traversal direction — incorrect program counter).
    // However, since there is only one zero, both forward and backward
    // traversal return index 1 — output is accidentally correct, no failure.
    @Test
    void singleZeroCorrectOutputDespiteErrorState() {
        int[] x = {1, 0, 3};
        assertEquals(1, A1_Q2_Program2_Incorrect.lastZero(x));
    }
}
