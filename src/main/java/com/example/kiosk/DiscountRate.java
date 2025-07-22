package com.example.kiosk;

import java.math.BigDecimal;

public enum DiscountRate implements DiscountPolicy {
    // 국자유공자 10% 군인 5% 학생 3% 일반 0%
    VETERAN("국가유공자", new BigDecimal("0.1")),
    SOLDIER("군인", new BigDecimal("0.05")),
    STUDENT("학생", new BigDecimal("0.03")),
    GENERAL("일반", BigDecimal.ZERO);

    private final String userType;
    private final BigDecimal discountRate;

    DiscountRate(String userType, BigDecimal discountRate) {
        this.userType = userType;
        this.discountRate = discountRate;
    }

    public String getUserType() {
        return userType;
    }

    public BigDecimal getDiscountRate() {
        return discountRate;
    }

    public String getPercent() {
        BigDecimal multiplier = new BigDecimal("100");
        BigDecimal discount = discountRate.multiply(multiplier);
        return discount.setScale(0, BigDecimal.ROUND_DOWN).toString();
    }

    public static DiscountRate fromSelection(int selected) {
        DiscountRate[] retes = DiscountRate.values();
        if (selected < 1 || selected > retes.length) {
            throw new IllegalArgumentException("유효하지 않은 메뉴입니다.");
        }
        return retes[selected - 1];
    }

    @Override
    public BigDecimal applyDiscount(BigDecimal total) {
        return total.subtract(total.multiply(discountRate));
    }
}
