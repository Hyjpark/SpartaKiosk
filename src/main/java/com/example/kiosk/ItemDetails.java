package com.example.kiosk;

import java.math.BigDecimal;

/**
 * 아이템의 기본 정보를 제공하는 인터페이스 입니다.
 *
 * 구현 클래스는 이름, 가격, 설명 정보를 반환해야 합니다.
 */
public interface ItemDetails {
    /**
     * 아이템의 이름을 반환합니다.
     *
     * @return 아이템 이름
     */
    String getName();

    /**
     * 아이템의 가격을 반환합니다.
     *
     * @return 아이템 가격
     */
    BigDecimal getPrice();

    /**
     * 아이템의 설명을 반환합니다.
     *
     * @return 아이템 설명
     */
    String getDescription();
}
