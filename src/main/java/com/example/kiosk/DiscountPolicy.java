package com.example.kiosk;

import java.math.BigDecimal;

public interface DiscountPolicy {
    BigDecimal applyDiscount(BigDecimal total);
}