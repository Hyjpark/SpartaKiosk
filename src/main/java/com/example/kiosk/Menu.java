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
}
