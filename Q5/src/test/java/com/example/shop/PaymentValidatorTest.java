package com.example.shop;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class PaymentValidatorTest {

    private final PaymentValidator validator = new PaymentValidator();

    @Test
    void nullPaymentMethod_isInvalid() {
        assertFalse(validator.isPaymentMethodValid(null));
    }

    @Test
    void cardAndPaypal_areValid_caseInsensitive() {
        assertTrue(validator.isPaymentMethodValid("card"));
        assertTrue(validator.isPaymentMethodValid("CARD"));
        assertTrue(validator.isPaymentMethodValid("paypal"));
    }

    @Test
    void crypto_isInvalid() {
        assertFalse(validator.isPaymentMethodValid("crypto"));
    }

    // @Test
    // void unknownPaymentMethod_throws() {
    //     assertThrows(UnsupportedOperationException.class,
    //             () -> validator.isPaymentMethodValid("wire"));
    // }
}
