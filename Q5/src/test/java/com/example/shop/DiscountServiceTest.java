package com.example.shop;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class DiscountServiceTest {

    private final DiscountService discountService = new DiscountService();

    @Test
    void nullOrBlankCode_returnsSubtotal() {
        assertEquals(100.0, discountService.applyDiscount(100.0, null), 1e-9);
        assertEquals(100.0, discountService.applyDiscount(100.0, "   "), 1e-9);
    }

    @Test
    void student10_applies10PercentOff_caseInsensitive() {
        assertEquals(90.0, discountService.applyDiscount(100.0, "STUDENT10"), 1e-9);
        assertEquals(90.0, discountService.applyDiscount(100.0, "student10"), 1e-9);
    }

    @Test
    void blackFriday_applies30PercentOff() {
        assertEquals(70.0, discountService.applyDiscount(100.0, "BLACKFRIDAY"), 1e-9);
    }

    @Test
    void invalidCode_throws() {
        assertThrows(IllegalArgumentException.class,
                () -> discountService.applyDiscount(100.0, "INVALID"));
    }

    @Test
    void unknownCode_returnsSubtotal() {
        assertEquals(100.0, discountService.applyDiscount(100.0, "HELLO"), 1e-9);
    }
}
