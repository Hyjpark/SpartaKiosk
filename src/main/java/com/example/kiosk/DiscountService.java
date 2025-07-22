package com.example.kiosk;

import java.math.BigDecimal;

public class DiscountService {
    private BigDecimal discountAmount;

    public void calculateDiscountAmount(BigDecimal total, BigDecimal rate) {
        if (rate.compareTo(BigDecimal.ZERO) == 0) {
            return;
        }

        this.discountAmount = total.subtract(total.multiply(rate));
    }

    public DiscountRate findDiscountRateBySelection(int selected) {
        DiscountRate[] retes = DiscountRate.values();
        if (selected < 1 || selected > retes.length) {
            throw new IllegalArgumentException("유효하지 않은 메뉴입니다.");
        }
        return retes[selected - 1];
    }

    public BigDecimal getDiscountAmount() {
        return this.discountAmount;
    }
}
