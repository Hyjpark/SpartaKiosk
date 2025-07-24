package com.example.kiosk;

import java.util.*;

/**
 *  프로그램 순서 및 흐름 제어를 담당하는 클래스입니다.
 *
 *  사용자의 메뉴 선택을 처리하고 주문 확인, 장바구니, 할인 적용 과정의 흐름을 관리합니다.
 */
public class Kiosk {
    private final List<Menu> menus;
    private final Cart cart = new Cart();
    private final OrderMenu orderMenu = new OrderMenu();
    private final DiscountMenuView discountMenuView = new DiscountMenuView();

    private final Scanner sc = new Scanner(System.in);

    /**
     * Kiosk 인스턴스를 생성합니다.
     *
     * @param menuList 메인 메뉴 리스트
     */
    public Kiosk(List<Menu> menuList) {
        this.menus = menuList;
    }

    /**
     * 키오스크를 시작합니다.
     * <p>
     * 무한 반복문을 통해 사용자의 입력을 받아 메뉴를 출력하고, 주문 흐름을 제어합니다.
     * 입력에 따라 음식 메뉴 선택, 장바구니 확인, 주문 처리, 뒤로가기, 종료 등의 동작을 수행합니다.
     * <p>
     * 잘못된 입력에 대해서는 예외를 처리하여 안내 메세지를 출력합니다.
     */
    public void start() {
        while (true) {
            try {
                // 메인 메뉴(상위 카테고리) 메뉴 출력
                showMainMenu();

                // 장바구니에 물건이 들어있으면 [ ORDER MENU ] 출력
                boolean isOrderMenu = cart.hasItems();
                if (isOrderMenu) orderMenu.printOrderMenu(menus.size());

                int selectMenu = readInput();

                if (handleMainMenu(selectMenu) == ActionResult.EXIT_PROGRAM) { // 프로그램 종료 상태
                    System.out.println("프로그램을 종료합니다.");
                    break;
                }

                if (isOrderMenu) {// 주문 메뉴 상태
                    if (handleOrderMenu(selectMenu) == ActionResult.RETURN_TO_MENU) continue;
                }

                // 음식 메뉴 선택 제어
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

    /**
     * 메인 메뉴(상위 카테고리)를 출력합니다.
     */
    private void showMainMenu() {
        // 메인 메뉴(상위 카테고리) 출력
        System.out.println("\n[ MAIN MENU ]");
        for (int i = 0; i < menus.size(); i++) {
            System.out.println((i + 1) + ". " + menus.get(i).getCategory());
        }
        System.out.println("0. 종료 \t| 종료");
    }

    /**
     * 메인 메뉴 선택 결과를 처리합니다.
     *
     * @param selectMenu 사용자가 선택한 메뉴 번호
     * @return 프로그램 종료 여부를 나타내는 {@link ActionResult}
     */
    private ActionResult handleMainMenu(int selectMenu) {
        if (selectMenu == 0) {
            return ActionResult.EXIT_PROGRAM;
        }
        return ActionResult.CONTINUE;
    }

    /**
     * 주문 메뉴(주문/취소) 선택 결과를 처리합니다.
     *
     * @param selectMenu 사용자가 선택한 메뉴 번호
     * @return 주문 계속 여부를 나타내는 {@link ActionResult}
     * @throws IndexOutOfBoundsException 유효하지 않은 메뉴 번호를 입력한 경우
     */
    private ActionResult handleOrderMenu(int selectMenu) {
        int menusLength = menus.size();     // 메인 메뉴의 개수
        int maxMenuNumber = menusLength + 2; // 메인 메뉴와 주문 메뉴의 개수를 더하여 총 갯수를 구함

        int ordersIndex = orderMenu.getOrdersIndex(menusLength); // 주문 메뉴 인덱스
        int cancelIndex = orderMenu.getCancelIndex(menusLength); // 취소 메뉴 인덱스

        // 선택한 메뉴가 메뉴의 총 갯수를 넘어가면 예외 처리
        if (selectMenu > maxMenuNumber) throw new IndexOutOfBoundsException("존재하지 않는 메뉴입니다.");

        // 주문 메뉴 선택
        if (selectMenu == ordersIndex) {
            System.out.println("\n아래와 같이 주문 하시겠습니까?");
            System.out.println(cart.renderCartList());  // 장바구니 내역 출력
            System.out.println(cart.renderTotalPrice()); // 총 금액 출력
            System.out.println("1. 주문\t\t2. 메뉴판");
            return handleCartMenu(readInput()); // 주문 진행 선택 처리
        }

        // 취소 메뉴 선택
        if (selectMenu == cancelIndex) {
            System.out.println("주문을 취소합니다.");
            return ActionResult.RETURN_TO_MENU;
        }

        return ActionResult.CONTINUE;
    }

    /**
     * 메인 카테고리에서 선택한 메뉴의 항목을 처리합니다.
     *
     * @param selectMenu 사용자가 선택한 메인 카테고리 번호
     */
    private void handleMenuSelection(int selectMenu) {
        Menu menu = menus.get(selectMenu - 1);
        // 메뉴 출력
        System.out.println(menu.renderMenuItems());

        int selectMenuItem = readInput();
        // 특정 메뉴 항목에 대한 상세 선택 처리
        handleMenuDetail(menu, selectMenuItem);
    }

    /**
     * 특정 메뉴 항목에 대한 상세 선택을 처리합니다.
     *
     * @param menu 선택한 메뉴 카테고리
     * @param selectMenuItem 사용자가 선택한 항목 번호
     * @return 계속 진행 여부를 나타내는 {@link ActionResult}
     * @throws IndexOutOfBoundsException 유효하지 않은 메뉴 번호를 입력한 경우
     * @throws IllegalArgumentException 유효하지 않은 확인/취소 입력값을 입력한 경우
     */
    private ActionResult handleMenuDetail(Menu menu, int selectMenuItem) {
        if (selectMenuItem == 0) return ActionResult.RETURN_TO_MENU; // 뒤로가기
        if (selectMenuItem > menu.getMenuItems().size()) throw new IndexOutOfBoundsException("존재하지 않는 메뉴입니다.");

        int menuIndex = selectMenuItem - 1;

        MenuItem selectItem = menu.getMenuItems().get(menuIndex);
        String selectShowMenuItem = String.format("%s | W %s | %s",
                selectItem.getName(),
                selectItem.getPrice(),
                selectItem.getDescription());
        // 선택한 항목 정보 출력
        System.out.println("\n\"" + selectShowMenuItem  + "\"");
        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
        System.out.println("1. 확인 \t 2. 취소");

        switch (readInput()) {
            case 1 :
                cart.addCartList(menu.getMenuItems().get(menuIndex)); // 장바구니에 추가
                break;
            case 2 :
                System.out.println("메뉴로 돌아갑니다.");
                break;
            default:
                throw new IllegalArgumentException("유효하지 않은 메뉴입니다.");
        }

        return ActionResult.CONTINUE;
    }

    /**
     * 주문에 대한 주문/메뉴판 메뉴를 처리합니다.
     *
     * @param inputNumber 사용자가 선택한 메뉴 번호
     * @return 주문 진행 결과를 나타내는 {@link ActionResult}
     * @throws IllegalArgumentException 유효하지 않은 메뉴 번호를 입력한 경우
     */
    private ActionResult handleCartMenu(int inputNumber) {
        switch (inputNumber) {
            case 1 :
                selectDiscountAndOrder(); // 할인 선택과 주문을 처리
                return ActionResult.RETURN_TO_MENU;
            case 2 :
                System.out.println("메뉴판으로 돌아갑니다.");
                return ActionResult.RETURN_TO_MENU;
            default:
                throw new IllegalArgumentException("유효하지 않은 메뉴입니다.");
        }
    }

    /**
     * 선택 가능한 할인 메뉴를 보여주고, 사용자의 선택에 대한 할인율을 적용하고 주문을 완료합니다.
     * <p>
     * 할인 정책은 {@link DiscountRate} 열거형을 통해 정의됩니다.
     * @throws IllegalArgumentException 유효하지 않은 할인 메뉴를 선택한 경우
     */
    private void selectDiscountAndOrder() {
        System.out.println(discountMenuView.format());

        DiscountRate discountRate = DiscountRate.fromSelection(readInput()); // 사용자 선택에 대한 할인 정책
        System.out.println("주문이 완료되었습니다. 금액은 W " + cart.applyDiscount(discountRate) + "입니다."); // 최종 계산 및 할인 적용된 금액 출력

        cart.order(); // 주문 완료 처리
    }

    /**
     * 사용자로부터 정수 입력을 받습니다.
     *
     * @return 정수형 사용자 입력값
     * @throws NumberFormatException 입력값이 정수가 아닐 경우 발생
     */
    private int readInput() {
        try {
            return Integer.parseInt(sc.nextLine()); // 예외 편의성을 위해 문자열을 받고 정수 변환
        } catch (NumberFormatException e) {
            throw new NumberFormatException("잘못된 입력입니다.");
        }
    }
}
