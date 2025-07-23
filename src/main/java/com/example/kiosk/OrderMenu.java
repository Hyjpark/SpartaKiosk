package com.example.kiosk;

public class OrderMenu {
    public int getOrdersIndex(int menusLength) {
        return menusLength + 1;
    }

    public int getCancelIndex(int menusLength) {
        return menusLength + 2;
    }

    public void printOrderMenu(int menusLength) {
        System.out.println("\n[ ORDER MENU ]");
        System.out.println(getOrdersIndex(menusLength)+ ". Orders   | 장바구니를 확인 후 주문합니다.");
        System.out.println(getCancelIndex(menusLength)+ ". Cancel   | 진행중인 주문을 취소합니다.");
    }
}
