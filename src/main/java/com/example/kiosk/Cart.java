package com.example.kiosk;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Cart<T extends ItemDetails> {
    private final List<CartItem<T>> cartList = new ArrayList();

    public void addCartList(T cartItem) {
        filterCartList(cartItem);
        cartList.add(new CartItem<>(cartItem));
        System.out.println(cartItem.getName() + "가 장바구니에 추가되었습니다.");
    }

    public void filterCartList(T cartItem) {
        cartList.removeIf(item -> item.getName().equals(cartItem.getName()));
    }

    public boolean hasItems() {
        return !cartList.isEmpty();
    }

    public String renderCartList() {
        StringBuilder sb = new StringBuilder("\n[ Orders ]\n");
        for (CartItem cartItem : cartList) {
            sb.append(cartItem.getName() + " | W ")
                .append(cartItem.getPrice()  + " | ")
                .append(cartItem.getDescription())
                .append("\n");
        }
        return sb.toString();
    }

    public String renderTotalPrice() {
        String totalPrice = "[ Total ]\n";
        totalPrice += "W " + sumPrice() + "\n";

        return totalPrice;
    }

    private BigDecimal sumPrice() {
        BigDecimal sum = BigDecimal.ZERO;

        for (int  i = 0; i < cartList.size(); i++) {
            BigDecimal price = cartList.get(i).getPrice();
            sum = sum.add(price);
        }

        return sum;
    }

    public void order() {
        // 장바구니를 초기화 한다.
        cartList.clear();
    }

    public BigDecimal applyDiscount(DiscountPolicy discountPolicy) {
        // 최종 금액을 계산한다.
        BigDecimal total = sumPrice();

        return discountPolicy.applyDiscount(total);
    }
}
