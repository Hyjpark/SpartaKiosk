package com.example.kiosk;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

// MenuItem 클래스를 관리
public class Menu {
    private String category;
    private List<MenuItem> menuItems = new ArrayList<>();

    public Menu(String category, List<MenuItem> menuItems) {
        this.category = category;
        this.menuItems = menuItems;
    }

    public void showMenuItem() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n[ "+ category.toUpperCase() + " MENU ]\n");
        for (int  i = 0; i < menuItems.size(); i++) {
            int blankLength = 12;
            sb.append((i + 1) + ". " );
            sb.append(menuItems.get(i).getName());
            sb.append(" ".repeat(blankLength - menuItems.get(i).getName().length()) +  " | "); // 이름과 가격 사이의 공백 생성
            sb.append("W " + menuItems.get(i).getPrice() +  " | ");
            sb.append(menuItems.get(i).getDescription());
            sb.append("\n");
        }
        sb.append("0. 뒤로가기");// 메뉴 출력

        System.out.println(sb.toString());
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public String getCategory() {
        return this.category;
    }

    public void setMenuItems(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }
}
