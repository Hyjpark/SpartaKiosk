package com.example.kiosk;

import java.math.BigDecimal;

// 개별 음식 항목을 관리하는 클래스
public class MenuItem {
    private final String name;
    private final BigDecimal price;
    private final String description;

    public MenuItem(String name, BigDecimal price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public String getName() {
        return this.name;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public String getDescription() {
        return this.description;
    }
}
