package com.example.kiosk;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new  Scanner(System.in);
        boolean run = true;

        // 햄버거 메뉴
        String[][] menu = {
                {"ShackBuger", "W 6.9", "토마토, 양상추, 쉑소스가 토핑된 치즈버거"},
                {"SmokeShack", "W 8.9", "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"},
                {"Cheeseburger", "W 6.9", "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"},
                {"Hamburger", "W 5.4", "비프패티를 기반으로 야채가 들어간 기본버거"}
        };

        while (run) {
            System.out.println("[ SHAKESHACK MENU ]");
            for (int i = 0; i < menu.length; i++) {
                System.out.print((i + 1) + ". ");
                for (int j = 0; j < menu[i].length; j++) {
                    System.out.print(menu[i][j] + " | ");
                }
                System.out.println();
            }
            System.out.println("0. 종료 | 종료");


            int selectMenu = sc.nextInt();
            int menuIndex = selectMenu - 1;
            switch (selectMenu) {
                case 0:
                    System.out.println("프로그램을 종료합니다.");
                    run = false;
                    break;
                case 1:
                    System.out.print("선택한 메뉴 : ");
                    System.out.println(menu[menuIndex][0] + " | " + menu[menuIndex][1] + " | " + menu[menuIndex][2]);
                    break;
                case 2:
                    System.out.print("선택한 메뉴 : ");
                    System.out.println(menu[menuIndex][0] + " | " + menu[menuIndex][1] + " | " + menu[menuIndex][2]);
                    break;
                case 3:
                    System.out.print("선택한 메뉴 : ");
                    System.out.println(menu[menuIndex][0] + " | " + menu[menuIndex][1] + " | " + menu[menuIndex][2]);
                    break;
                case 4:
                    System.out.print("선택한 메뉴 : ");
                    System.out.println(menu[menuIndex][0] + " | " + menu[menuIndex][1] + " | " + menu[menuIndex][2]);
                    break;
            }
        }
    }
}
