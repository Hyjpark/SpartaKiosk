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
        while (run) {
            try {
                // 상위 카테고리 메뉴 출력
                System.out.println("\n[ MAIN MENU ]");
                for (int i = 0; i < menus.size(); i++) {
                    System.out.println((i + 1) + ". " + menus.get(i).getCategory());
                }
                System.out.println("0. 종료 \t| 종료");

                int selectMenu = sc.nextInt();
                Menu menu = null;
                switch (selectMenu) {
                    case 0:
                        System.out.println("프로그램을 종료합니다.");
                        run = false;
                        break;
                    case 1:  case 2: case 3:
                        menu = menus.get(selectMenu - 1);
                }

                if (run) {
                    // 메뉴 출력
                    menu.showMenuItem();

                    int selectMenuItem = sc.nextInt();
                    int menuIndex = selectMenuItem - 1;
                    switch (selectMenuItem) {
                        case 0:
                            continue;
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                            System.out.print("선택한 메뉴 : ");
                            System.out.println(menu.getMenuItems().get(menuIndex).name + " | W "
                                    + menu.getMenuItems().get(menuIndex).price
                                    + " | " + menu.getMenuItems().get(menuIndex).description);
                            break;
                        default:
                            throw new InputMismatchException("존재하지 않는 메뉴입니다.");
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("존재하지 않는 메뉴입니다.");
            }
        }
    }
}
