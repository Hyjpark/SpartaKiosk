package com.example.kiosk;

import java.math.BigDecimal;

/**
 * 할인 정책을 정의하는 인터페이스입니다.
 *
 * 구현체는 총 금액에 대해 할인 정책을 적용하는 로직을 제공합니다.
 */
public interface DiscountPolicy {
    /**
     * 총 금액에 할인 정책을 적용하여 할인된 금액을 반환합니다.
     *
     * @param total 할인 적용 전 총 금액
     * @return 할인 적용 후 금액
     */
    BigDecimal applyDiscount(BigDecimal total);
}