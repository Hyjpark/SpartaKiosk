package com.example.kiosk;

import java.util.*;

public class Kiosk {
    private final List<Menu> menus;
    private final Cart cart = new Cart();
    private final OrderMenu orderMenu = new OrderMenu();

    public Kiosk(List<Menu> menuList) {
        this.menus = menuList;
    }

    public void start() {
        Scanner sc =  new Scanner(System.in);

        while (true) {
            try {
                // 상위 카테고리 메뉴 출력
                System.out.println("\n[ MAIN MENU ]");
                for (int i = 0; i < menus.size(); i++) {
                    System.out.println((i + 1) + ". " + menus.get(i).getCategory());
                }
                System.out.println("0. 종료 \t| 종료");

                // 장바구니에 물건이 들어있으면 [ ORDER MENU ] 출력
                boolean isOrderMenu = cart.getCartList().size() > 0;
                if (isOrderMenu) orderMenu.printOrderMenu();

                int selectMenu = Integer.parseInt(sc.nextLine());

                if (selectMenu == 0) {
                    System.out.println("프로그램을 종료합니다.");
                    break;
                }

                int maxMenuNumber = isOrderMenu ? menus.size() + 2 : menus.size();
                if (selectMenu > maxMenuNumber) throw new IndexOutOfBoundsException("존재하지 않는 메뉴입니다.");

                if (isOrderMenu) {
                    switch (selectMenu) {
                        case 4 :
                            System.out.println("\n아래와 같이 주문 하시겠습니까?");
                            cart.showCart();
                            handleCartMenu(Integer.parseInt(sc.nextLine()));
                            continue;
                        case 5 :
                            System.out.println("주문을 취소합니다.");
                            continue;
                    }
                }

                Menu menu = menus.get(selectMenu - 1);

                // 메뉴 출력
                menu.showMenuItem();

                int selectMenuItem = Integer.parseInt(sc.nextLine());
                int menuIndex = selectMenuItem - 1;

                if (selectMenuItem == 0) continue;

                if (selectMenuItem > menu.getMenuItems().size()) throw new IndexOutOfBoundsException("존재하지 않는 메뉴입니다.");

                String selectShowMenuItem = menu.getMenuItems().get(menuIndex).getName() + " | W "
                        + menu.getMenuItems().get(menuIndex).getPrice()
                        + " | " + menu.getMenuItems().get(menuIndex).getDescription();
                System.out.print("선택한 메뉴 : ");
                System.out.println(selectShowMenuItem);

                System.out.println("\n\"" + selectShowMenuItem  + "\"");
                System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
                System.out.println("1. 확인 \t 2. 취소");
                switch (Integer.parseInt(sc.nextLine())) {
                    case 1 :
                        cart.addCartList(menu.getMenuItems().get(menuIndex));
                        break;
                    case 2 :
                        System.out.println("메뉴로 돌아갑니다.");
                        break;
                    default:
                        throw new IllegalArgumentException("유효하지 않은 메뉴입니다.");
                }

            } catch (IndexOutOfBoundsException e) {
                System.out.println("존재하지 않는 메뉴입니다.");
            } catch (NumberFormatException e) {
                System.out.println("잘못된 입력입니다.");
            } catch (IllegalArgumentException e) {
                System.out.println("유효하지 않은 메뉴입니다.");
            }
        }
    }

    public void handleCartMenu(int inputNumber) {
        switch (inputNumber) {
            case 1 :
                System.out.println("주문");
                break;
            case 2 :
                System.out.println("메뉴판");
                return;
            default:
                throw new IllegalArgumentException("유효하지 않은 메뉴입니다.");
        }
    }
}
