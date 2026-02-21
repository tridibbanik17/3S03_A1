/**
 * Course code: SFWRENG 3S03
 * Assignment 1: Validation and Testing Basics
 *
 * ------------------------------------------------------------
 * Calculator
 *
 * A simple calculator class that provides basic arithmetic
 * operations. This version includes the divide() method,
 * developed using Test-Driven Development (TDD).
 * ------------------------------------------------------------
 */
public class Calculator {

    public double divide(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return a / b;
    }
}