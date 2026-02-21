package com.example.shop;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class PricingServiceTest {

    private final PricingService pricingService = new PricingService();

    @Test
    void calculateSubtotal_emptyOrder_isZero() {
        Order order = new Order();
        assertEquals(0.0, pricingService.calculateSubtotal(order), 1e-9);
    }

    @Test
    void calculateSubtotal_sumsItemTotals() {
        Order order = new Order();
        order.addItem(new OrderItem("A", 2, 5.0));   // 10
        order.addItem(new OrderItem("B", 1, 7.5));   // 7.5
        assertEquals(17.5, pricingService.calculateSubtotal(order), 1e-9);
    }

    @Test
    void calculateTax_negativeSubtotal_throws() {
        assertThrows(IllegalArgumentException.class,
                () -> pricingService.calculateTax(-0.01));
    }

    @Test
    void calculateTax_zero_isZero() {
        assertEquals(0.0, pricingService.calculateTax(0.0), 1e-9);
    }

    @Test
    void calculateTax_positive_is20Percent() {
        assertEquals(20.0, pricingService.calculateTax(100.0), 1e-9);
    }
}
