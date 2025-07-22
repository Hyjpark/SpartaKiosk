package com.example.kiosk;

import java.math.BigDecimal;

public enum DiscountRate {
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

    public static DiscountRate fromUserType(String userType) {
        for (DiscountRate discountRate : values()) {
            if (discountRate.getUserType().equals(userType)) {
                return discountRate;
            }
        }
        throw new IllegalArgumentException("유효하지 않는 메뉴입니다.");
    }

}
