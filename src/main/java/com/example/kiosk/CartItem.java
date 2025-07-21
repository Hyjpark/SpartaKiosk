package com.example.kiosk;

import java.math.BigDecimal;

public class CartItem {
    private final MenuItem item;

    public CartItem(MenuItem item) {
        this.item = item;
    }

    public String getName() {
        return this.item.getName();
    }

    public BigDecimal getPrice() {
        return this.item.getPrice();
    }

    public String getDescription() {
        return this.item.getDescription();
    }
}
