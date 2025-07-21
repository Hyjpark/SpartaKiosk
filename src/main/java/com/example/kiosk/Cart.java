package com.example.kiosk;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Cart {
    private final List<CartItem> cartList = new ArrayList();

    public void addCartList(MenuItem menuItem) {
        cartList.add(new CartItem(menuItem));
        System.out.println(menuItem.getName() + "가 장바구니에 추가되었습니다.");
    }

    public List<CartItem> getCartList() {
        return cartList;
    }

    public void showCart() {
        showCartList();
        showTotalPrice();
        System.out.println("\n1. 주문\t\t2. 메뉴판");
    }

    public void showCartList() {
        System.out.println("\n[ Orders ]");
        for (int  i = 0; i < cartList.size(); i++) {
            System.out.println(
                    cartList.get(i).getName() + " | W "
                    + cartList.get(i).getPrice()  + " | "
                    + cartList.get(i).getDescription());
        }
    }

    public void showTotalPrice() {
        System.out.println("\n[ Total ]");
        System.out.println("W " + sumPrice());
    }

    private BigDecimal sumPrice() {
        BigDecimal sum = BigDecimal.ZERO;

        for (int  i = 0; i < cartList.size(); i++) {
            BigDecimal price = cartList.get(i).getPrice();
            sum = sum.add(price);
        }

        return sum;
    }
}
