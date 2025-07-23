package com.example.kiosk;

import java.math.BigDecimal;

public class CartItem<T extends ItemDetails> {
    private final T item;

    public CartItem(T item) {
        this.item = item;
    }

    public String getName() {
        return item.getName();
    }

    public BigDecimal getPrice() {
        return item.getPrice();
    }

    public String getDescription() {
        return item.getDescription();
    }
}
