package com.example.kiosk;

/**
 * 주문 관련 메뉴 인덱스를 관리하고 주문 메뉴를 출력하는 클래스입니다.
 */
public class OrderMenu {
    /**
     * 주문 메뉴에서 'Orders' 항목의 인덱스를 반환합니다.
     * 
     * @param menusLength 메인 메뉴 개수
     * @return 주문 메뉴의 'Orders' 인덱스
     */
    public int getOrdersIndex(int menusLength) {
        return menusLength + 1;
    }

    /**
     * 주문 메뉴에서 'Cancel' 항목의 인덱스를 반환합니다. 
     * 
     * @param menusLength 메인 메뉴 개수
     * @return 주문 메뉴의 'Cancel' 인덱스
     */
    public int getCancelIndex(int menusLength) {
        return menusLength + 2;
    }

    /**
     * 현재 진행 중인 주문 메뉴를 콘솔에 출력합니다.
     * 
     * @param menusLength 메인 메뉴 개수
     */
    public void printOrderMenu(int menusLength) {
        System.out.println("\n[ ORDER MENU ]");
        System.out.println(getOrdersIndex(menusLength)+ ". Orders   | 장바구니를 확인 후 주문합니다.");
        System.out.println(getCancelIndex(menusLength)+ ". Cancel   | 진행중인 주문을 취소합니다.");
    }
}
