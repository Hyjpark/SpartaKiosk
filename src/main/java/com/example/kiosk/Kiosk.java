package com.example.kiosk;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
    List<MenuItem> menuItems = new ArrayList<>();


    public void start() {
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

        Scanner sc =  new Scanner(System.in);
        boolean run = true;
        while (run) {
            System.out.println(sb.toString());

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
