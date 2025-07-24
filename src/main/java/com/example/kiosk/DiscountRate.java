package com.example.kiosk;

import java.math.BigDecimal;

/**
 * 사용자 유형별 할인율을 정의한 열거형(enum)입니다.
 *
 * 각 할인율은 {@link DiscountPolicy} 인터페이스를 구현하여
 * 총 금액에 대해 할인 적용 기능을 제공합니다.
 */
public enum DiscountRate implements DiscountPolicy {
    /** 국가유공자 할인 10% */
    VETERAN("국가유공자", new BigDecimal("0.1")),
    /** 군인 할인 5% */
    SOLDIER("군인", new BigDecimal("0.05")),
    /** 학생 할인 3% */
    STUDENT("학생", new BigDecimal("0.03")),
    /** 일반 할인 0% */
    GENERAL("일반", BigDecimal.ZERO);

    private final String userType;
    private final BigDecimal discountRate;

    /**
     * DiscountRate 생성자
     *
     * @param userType 사용자 유형 명칭
     * @param discountRate 할인율
     */
    DiscountRate(String userType, BigDecimal discountRate) {
        this.userType = userType;
        this.discountRate = discountRate;
    }

    /**
     * 사용자 유형 명칭을 반환합니다.
     *
     * @return 사용자 유형 문자열
     */
    public String getUserType() {
        return userType;
    }

    /**
     * 할인율을 백분율(%) 문자열로 반환합니다.
     *
     * @return 할인율 백분율 문자열
     */
    public String getPercent() {
        BigDecimal multiplier = new BigDecimal("100");
        BigDecimal discount = discountRate.multiply(multiplier);
        return discount.setScale(0, BigDecimal.ROUND_DOWN).toString();
    }

    /**
     * 선택한 할인에 대한 할인율을 반환합니다.
     *
     * @param selected 사용자 선택 번호
     * @return 해당하는 {@link DiscountRate} 객체
     * @throws IllegalArgumentException 선택 번호가 유효하지 않을 경우 발생
     */
    public static DiscountRate fromSelection(int selected) {
        DiscountRate[] retes = DiscountRate.values();
        if (selected < 1 || selected > retes.length) {
            throw new IllegalArgumentException("유효하지 않은 메뉴입니다.");
        }
        return retes[selected - 1];
    }

    /**
     * 총 금엑에 할인율을 적용하여 할인된 금액을 반환합니다.
     *
     * @param total 할인 적용 전 총 금액
     * @return 할인 적용 후 금액
     */
    @Override
    public BigDecimal applyDiscount(BigDecimal total) {
        return total.subtract(total.multiply(discountRate));
    }
}
