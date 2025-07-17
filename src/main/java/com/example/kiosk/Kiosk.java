package com.example.kiosk;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
    List<Menu> menus = new ArrayList<>();

    Kiosk(List<Menu> menuList) {
        this.menus = menuList;
    }

    public void start() {
        Scanner sc =  new Scanner(System.in);
        boolean run = true;
        //while (run) {
            try {
                // 상위 카테고리 메뉴 출력
                System.out.println("[ MAIN MENU ]");
                for (int i = 0; i < menus.size(); i++) {
                    System.out.println((i + 1) + ". " + menus.get(i).category);
                }
                System.out.println("0. 종료 \t| 종료");

//                int selectMenu = sc.nextInt();
//                int menuIndex = selectMenu - 1;
//                switch (selectMenu) {
//                    case 0:
//                        System.out.println("프로그램을 종료합니다.");
//                        run = false;
//                        break;
//                    case 1:
//                    case 2:
//                    case 3:
//                    case 4:
//                        System.out.print("선택한 메뉴 : ");
//                        System.out.println(menuItems.get(menuIndex).name + " | W " + menuItems.get(menuIndex).price + " | " + menuItems.get(menuIndex).description);
//                        break;
//                    default:
//                        throw new InputMismatchException("존재하지 않는 메뉴입니다.");
//                }
            } catch (InputMismatchException e) {
                System.out.println("존재하지 않는 메뉴입니다.");
            }
       // }
    }
}
