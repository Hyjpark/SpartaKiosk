package com.example.kiosk;

import java.util.ArrayList;
import java.util.List;

// MenuItem 클래스를 관리
public class Menu {
    List<MenuItem> menuItems = new ArrayList<>();

    Menu(List<List<String>> menuList) {
        for (List<String> menu : menuList) {
            menuItems.add(new MenuItem(menu.get(0), menu.get(1), menu.get(2)));
        }
    }

    public void showMenuItem() {
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
        sb.append("0. 종료 \t| 종료");// 메뉴 출력

        System.out.println(sb.toString());
    }

}
