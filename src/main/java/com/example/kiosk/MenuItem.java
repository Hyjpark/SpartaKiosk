package com.example.kiosk;

// 개별 음식 항목을 관리하는 클래스
public class MenuItem {
    String name;
    double price;
    String description;

    MenuItem(String name, double price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }
}
