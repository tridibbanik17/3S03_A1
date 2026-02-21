package com.example.shop;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class OrderItemTest {

    @Test
    void constructor_rejectsNonPositiveQuantity() {
        assertThrows(IllegalArgumentException.class,
                () -> new OrderItem("X", 0, 1.0));
        assertThrows(IllegalArgumentException.class,
                () -> new OrderItem("X", -1, 1.0));
    }

    @Test
    void constructor_rejectsNegativeUnitPrice() {
        assertThrows(IllegalArgumentException.class,
                () -> new OrderItem("X", 1, -0.01));
    }

    @Test
    void totalPrice_isQuantityTimesUnitPrice() {
        OrderItem item = new OrderItem("X", 3, 2.5);
        assertEquals(7.5, item.getTotalPrice(), 1e-9);
        assertEquals(3, item.getQuantity());
    }
}
