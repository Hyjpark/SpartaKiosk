package com.example.kiosk;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // MAIN MENU 리스트
        List<Menu> menus = new ArrayList<>();

        // Menu 객체 생성을 통해 이름 설정
        // Menu 클래스 내 있는 List<MenuItem> 에 MenuItem 객체 생성하면서 삽입
        Menu burger = new Menu("Burger", List.of(
                new MenuItem("ShackBuger", "6.9", "토마토, 양상추, 쉑소스가 토핑된 치즈버거"),
                new MenuItem("SmokeShack", "8.9", "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"),
                new MenuItem("Cheeseburger", "6.9", "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"),
                new MenuItem("Hamburger", "5.4", "비프패티를 기반으로 야채가 들어간 기본버거")
        ));

        Menu drinks = new Menu("Drinks", List.of(
                new MenuItem("Coke", "4.0", "탄산이 톡톡쏘는 콜라"),
                new MenuItem("VanillaShake", "5.3", "바닐라닐라 쉐이크")
        ));
        Menu desserts = new Menu("Desserts", List.of());

        menus.add(burger);
        menus.add(drinks);
        menus.add(desserts);

        Kiosk kiosk = new Kiosk(menus);
        kiosk.start();
    }
}
