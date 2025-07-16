package com.example.kiosk;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<MenuItem> menuItems = new ArrayList<>();
        menuItems.add(new MenuItem("ShackBuger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));

        StringBuilder sb = new StringBuilder();
        sb.append("\n[ SHAKESHACK MENU ]\n");
        for (int  i = 0; i < menuItems.size(); i++) {
            int blankLength = 12;
            sb.append((i + 1) + ". " );
            sb.append(menuItems.get(i).name);
            sb.append(" ".repeat(blankLength - menuItems.get(i).name.length()) +  " | "); // 이름과 가격 사이의 공백 생성
            sb.append("W " + menuItems.get(i).price +  " | ");
            sb.append(menuItems.get(i).description);
            sb.append("\n");
        }
        sb.append("0. 종료 \t| 종료");

        Scanner sc =  new Scanner(System.in);
        boolean run = true;
        while (run) {
            System.out.println(sb.toString()); // 메뉴 출력

            int selectMenu = sc.nextInt();
            int menuIndex = selectMenu - 1;
            switch (selectMenu) {
                case 0:
                    System.out.println("프로그램을 종료합니다.");
                    run = false;
                    break;
                case 1: case 2: case 3: case 4:
                    System.out.print("선택한 메뉴 : ");
                    System.out.println(menuItems.get(menuIndex).name + " | W " + menuItems.get(menuIndex).price + " | " + menuItems.get(menuIndex).description);
                    break;
            }
        }
    }
}
