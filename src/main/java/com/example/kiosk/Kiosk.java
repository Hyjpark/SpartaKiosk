package com.example.kiosk;

import java.util.*;

public class Kiosk {
    private final List<Menu> menus;
    private final Cart cart = new Cart();
    private final OrderMenu orderMenu = new OrderMenu();
    private final DiscountMenuView discountMenuView = new DiscountMenuView();

    private final Scanner sc = new Scanner(System.in);

    public Kiosk(List<Menu> menuList) {
        this.menus = menuList;
    }

    public void start() {
        while (true) {
            try {
                // 상위 카테고리 메뉴 출력
                showMainMenu();

                // 장바구니에 물건이 들어있으면 [ ORDER MENU ] 출력
                boolean isOrderMenu = cart.hasItems();
                if (isOrderMenu) orderMenu.printOrderMenu(menus.size());

                int selectMenu = readInput();

                if (handleMainMenu(selectMenu) == ActionResult.EXIT_PROGRAM) {
                    System.out.println("프로그램을 종료합니다.");
                    break;
                }

                if (isOrderMenu) {
                    if (handleOrderMenu(selectMenu) == ActionResult.RETURN_TO_MENU) continue;
                }

                // 음식 메뉴
                handleMenuSelection(selectMenu);

            } catch (IndexOutOfBoundsException e) {
                System.out.println("존재하지 않는 메뉴입니다.");
            } catch (NumberFormatException e) {
                System.out.println("잘못된 입력입니다.");
            } catch (IllegalArgumentException e) {
                System.out.println("유효하지 않은 메뉴입니다.");
            }
        }
    }

    private void showMainMenu() {
        // 상위 카테고리 메뉴 출력
        System.out.println("\n[ MAIN MENU ]");
        for (int i = 0; i < menus.size(); i++) {
            System.out.println((i + 1) + ". " + menus.get(i).getCategory());
        }
        System.out.println("0. 종료 \t| 종료");

    }

    private ActionResult handleMainMenu(int selectMenu) {
        if (selectMenu == 0) {
            return ActionResult.EXIT_PROGRAM;
        }
        return ActionResult.CONTINUE;
    }

    private ActionResult handleOrderMenu(int selectMenu) {
        int menusLength = menus.size();
        int maxMenuNumber = menusLength + 2;
        int ordersIndex = orderMenu.getOrdersIndex(menusLength);
        int cancelIndex = orderMenu.getCancelIndex(menusLength);

        if (selectMenu > maxMenuNumber) throw new IndexOutOfBoundsException("존재하지 않는 메뉴입니다.");

        if (selectMenu == ordersIndex) {
            System.out.println("\n아래와 같이 주문 하시겠습니까?");
            cart.showCart();
            return handleCartMenu(readInput());
        }

        if (selectMenu == cancelIndex) {
            System.out.println("주문을 취소합니다.");
            return ActionResult.RETURN_TO_MENU;
        }

        return ActionResult.CONTINUE;
    }

    private void handleMenuSelection(int selectMenu) {
        Menu menu = menus.get(selectMenu - 1);
        // 메뉴 출력
        System.out.println(menu.renderMenuItems());

        int selectMenuItem = readInput();

        handleMenuDetail(menu, selectMenuItem);
    }

    private ActionResult handleMenuDetail(Menu menu, int selectMenuItem) {
        if (selectMenuItem == 0) return ActionResult.RETURN_TO_MENU;
        if (selectMenuItem > menu.getMenuItems().size()) throw new IndexOutOfBoundsException("존재하지 않는 메뉴입니다.");

        int menuIndex = selectMenuItem - 1;

        MenuItem selectItem = menu.getMenuItems().get(menuIndex);
        String selectShowMenuItem = String.format("%s | W %s | %s",
                selectItem.getName(),
                selectItem.getPrice(),
                selectItem.getDescription());

        System.out.println("\n\"" + selectShowMenuItem  + "\"");
        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
        System.out.println("1. 확인 \t 2. 취소");

        switch (readInput()) {
            case 1 :
                cart.addCartList(menu.getMenuItems().get(menuIndex));
                break;
            case 2 :
                System.out.println("메뉴로 돌아갑니다.");
                break;
            default:
                throw new IllegalArgumentException("유효하지 않은 메뉴입니다.");
        }

        return ActionResult.CONTINUE;
    }

    private ActionResult handleCartMenu(int inputNumber) {
        switch (inputNumber) {
            case 1 :
                selectDiscountAndOrder();
                return ActionResult.RETURN_TO_MENU;
            case 2 :
                System.out.println("메뉴판으로 돌아갑니다.");
                return ActionResult.RETURN_TO_MENU;
            default:
                throw new IllegalArgumentException("유효하지 않은 메뉴입니다.");
        }
    }

    private void selectDiscountAndOrder() {
        System.out.println(discountMenuView.format());

        DiscountRate discountRate = DiscountRate.fromSelection(readInput());
        System.out.println("주문이 완료되었습니다. 금액은 W " + cart.applyDiscount(discountRate) + "입니다.");

        cart.order();
    }

    private int readInput() {
        try {
            return Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            throw new NumberFormatException("잘못된 입력입니다.");
        }
    }
}
