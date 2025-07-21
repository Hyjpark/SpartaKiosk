package com.example.kiosk;

public class CartItem {
    private final MenuItem item;

    public CartItem(MenuItem item) {
        this.item = item;
    }

    public String getName() {
        return this.item.getName();
    }

    public String getPrice() {
        return this.item.getPrice();
    }

    public String getDescription() {
        return this.item.getDescription();
    }
}
