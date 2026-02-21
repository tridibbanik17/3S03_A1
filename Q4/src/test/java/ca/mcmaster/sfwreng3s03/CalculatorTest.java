package ca.mcmaster.sfwreng3s03;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

/**
 * Course code: SFWRENG 3S03
 * Assignment 1: Validation and Testing Basics
 *
 * ------------------------------------------------------------
 * CalculatorTest
 *
 * Unit tests for the Calculator class.
 * These tests were developed following Test-Driven Development
 * (TDD) principles in multiple iterations.
 * ------------------------------------------------------------
 */

public class CalculatorTest {

    /**
     * Tests division of two positive numbers.
     * This test was part of the initial TDD iteration.
     */
    @Test
    void dividePositiveNumbers() {
        Calculator calc = new Calculator();
        assertEquals(2.0, calc.divide(6, 3));
    }

    /**
     * Tests division by one.
     * Ensures the identity property of division holds.
     */
    @Test
    void divideByOne() {
        Calculator calc = new Calculator();
        assertEquals(5.0, calc.divide(5, 1));
    }

    /**
     * Tests that division by zero throws an ArithmeticException.
     * This test motivated a second TDD iteration and led to
     * improving the divide() method.
     */
    @Test
    void divideByZeroThrowsException() {
        Calculator calc = new Calculator();
        
        ArithmeticException exception = assertThrows(ArithmeticException.class, () -> {
            calc.divide(5, 0);
        });

        assertEquals("Cannot divide by zero", exception.getMessage());
    }

    /**
     * Tests dividing zero by a positive number.
     * The expected result should be zero.
     */
    @Test
    void divideZeroByNumber() {
        Calculator calc = new Calculator();
        assertEquals(0.0, calc.divide(0, 5));
    }

    /**
     * Tests division involving negative numbers.
     * Ensures correct handling of signs.
     */
    @Test
    void divideNegativeNumbers() {
        Calculator calc = new Calculator();
        assertEquals(-2.0, calc.divide(-6, 3));
    }


}
