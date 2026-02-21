package com.example.shop;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

    private final OrderService orderService = new OrderService();

    @Test
    void invalidPaymentMethod_cancelsOrder_andReturnsZero() {
        Order order = new Order();
        order.addItem(new OrderItem("A", 1, 10.0));

        double total = orderService.processOrder(order, "STUDENT10", "crypto"); // validator returns false

        assertEquals(0.0, total, 1e-9);
        assertEquals(OrderStatus.CANCELLED, order.getStatus());
    }

    @Test
    void validPayment_paysOrder_andReturnsDiscountedPlusTax() {
        Order order = new Order();
        order.addItem(new OrderItem("A", 2, 50.0)); // subtotal 100

        double total = orderService.processOrder(order, "STUDENT10", "card");
        // subtotal 100 -> discounted 90 -> tax 18 -> total 108
        assertEquals(108.0, total, 1e-9);
        assertEquals(OrderStatus.PAID, order.getStatus());
    }

    @Test
    void onceProcessed_cannotAddMoreItems() {
        Order order = new Order();
        order.addItem(new OrderItem("A", 1, 10.0));
        orderService.processOrder(order, null, "card");

        assertThrows(IllegalStateException.class,
                () -> order.addItem(new OrderItem("B", 1, 5.0)));
    }

    // @Test
    // void unknownPaymentMethod_causesProcessOrderToThrow() {
    //     Order order = new Order();
    //     order.addItem(new OrderItem("A", 1, 10.0));

    //     assertThrows(UnsupportedOperationException.class,
    //             () -> orderService.processOrder(order, null, "wire"));
    // }

    // @Test
    // void invalidDiscountCode_causesProcessOrderToThrow() {
    //     Order order = new Order();
    //     order.addItem(new OrderItem("A", 1, 10.0));

    //     assertThrows(IllegalArgumentException.class,
    //             () -> orderService.processOrder(order, "INVALID", "card"));
    // }
}
