package com.example.kiosk;

// 개별 음식 항목을 관리하는 클래스
public class MenuItem {
    private String name;
    private String price;
    private String description;

    MenuItem(String name, String price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public String getName() {
        return this.name;
    }

    public String getPrice() {
        return this.price;
    }

    public String getDescription() {
        return this.description;
    }
}
