package com.example.kiosk;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *  키오스크 애플리케이션의 진입점 클래스입니다.
 *
 *  애플리케이션 실행 시 메뉴 데이터를 초기화하고 {@link Kiosk}를 시작합니다.
 */
public class Main {
    /**
     * @param args 명령줄 인자. 현재는 사용되지 않는다.
     */
    public static void main(String[] args) {
        // MAIN MENU 리스트
        List<Menu> menus = new ArrayList<>();

        // Menu 객체 생성을 통해 이름 설정
        // Menu 클래스 내 있는 List<MenuItem> 에 MenuItem 객체 생성하면서 삽입
        Menu burger = new Menu("Burgers", List.of(
                new MenuItem("ShackBurger", new BigDecimal("6.9"), "토마토, 양상추, 쉑소스가 토핑된 치즈버거"),
                new MenuItem("SmokeShack", new BigDecimal("8.9"), "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"),
                new MenuItem("Cheeseburger", new BigDecimal("6.9"), "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"),
                new MenuItem("Hamburger", new BigDecimal("5.4"), "비프패티를 기반으로 야채가 들어간 기본버거")
        ));
        Menu drinks = new Menu("Drinks", List.of(
                new MenuItem("Coke", new BigDecimal("4.0"), "탄산이 톡톡쏘는 콜라"),
                new MenuItem("VanillaShake", new BigDecimal("5.3"), "바닐라닐라 쉐이크")
        ));
        Menu desserts = new Menu("Desserts", List.of());

        menus.add(burger);
        menus.add(drinks);
        menus.add(desserts);

        // Kiosk에 카테고리 메뉴 전달
        Kiosk kiosk = new Kiosk(menus);
        kiosk.start();
    }
}
