package com.example.kiosk;

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

    public void showCartList() {
        System.out.println("\n[ Orders ]");
        for (int  i = 0; i < cartList.size(); i++) {
            System.out.println(
                    cartList.get(i).getName() + " | W "
                    + cartList.get(i).getPrice()  + " | "
                    + cartList.get(i).getDescription());
        }
    }
}
