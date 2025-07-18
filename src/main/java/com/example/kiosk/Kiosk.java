package com.example.kiosk;

import java.util.*;

public class Kiosk {
    private List<Menu> menus = new ArrayList<>();

    public Kiosk(List<Menu> menuList) {
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

                int selectMenu = Integer.parseInt(sc.nextLine());
                Menu menu = null;

                if (selectMenu == 0) {
                    System.out.println("프로그램을 종료합니다.");
                    break;
                }

                if (selectMenu > menus.size()) throw new IndexOutOfBoundsException("존재하지 않는 메뉴입니다.");

                menu = menus.get(selectMenu - 1);

                if (run) {
                    // 메뉴 출력
                    menu.showMenuItem();

                    int selectMenuItem = Integer.parseInt(sc.nextLine());
                    int menuIndex = selectMenuItem - 1;

                    if (selectMenuItem == 0) continue;

                    if (selectMenuItem > menu.getMenuItems().size()) throw new IndexOutOfBoundsException("존재하지 않는 메뉴입니다.");

                    System.out.print("선택한 메뉴 : ");
                    System.out.println(menu.getMenuItems().get(menuIndex).getName() + " | W "
                            + menu.getMenuItems().get(menuIndex).getPrice()
                            + " | " + menu.getMenuItems().get(menuIndex).getDescription());

                }
            } catch (IndexOutOfBoundsException e) {
                System.out.println("존재하지 않는 메뉴입니다.");
            } catch (NumberFormatException e) {
                System.out.println("잘못된 입력입니다.");
            }
        }
    }
}
