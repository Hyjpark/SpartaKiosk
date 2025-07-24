package com.example.kiosk;

import java.math.BigDecimal;

/**
 * 개별 음식 메뉴 함옥을 나타내는 클래스입니다.
 * {@link ItemDetails} 인터페이스를 구현하여 이름, 가격, 설명 정보를 제공합니다.
 */
public class MenuItem implements ItemDetails {
    private final String name;
    private final BigDecimal price;
    private final String description;

    /**
     * 음식 이름, 가격, 설명을 받아 {@code MenuItem} 객체를 생성합니다.
     *
     * @param name 메뉴 항목 이름
     * @param price 메뉴 항목 가격
     * @param description 메뉴 항목 설명
     */
    public MenuItem(String name, BigDecimal price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    /**
     * 메뉴 항목의 이름을 반환합니다.
     *
     * @return 메뉴 이름
     */
    public String getName() {
        return this.name;
    }

    /**
     * 메뉴 항목의 가격을 반환합니다.
     *
     * @return
     */
    public BigDecimal getPrice() {
        return this.price;
    }

    /**
     * 메뉴 항목의 설명을 반환합니다.
     *
     * @return 메뉴 설명
     */
    public String getDescription() {
        return this.description;
    }
}
