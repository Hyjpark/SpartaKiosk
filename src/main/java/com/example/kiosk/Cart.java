package com.example.kiosk;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * 장바구니 역할을 담당하는 클래스 입니다.
 *
 * @param <T> {@link ItemDetails}를 구현한 장바구니 항목 타입
 */
public class Cart<T extends ItemDetails> {
    private final List<CartItem<T>> cartList = new ArrayList();

    /**
     * 장바구니에 항목을 추가합니다.
     * 동일한 항목이 있으면 기존 항목을 제거한 후 추가합니다.
     *
     * @param cartItem 장바구니에 추가할 항목
     */
    public void addCartList(T cartItem) {
        filterCartList(cartItem);
        cartList.add(new CartItem<>(cartItem));
        System.out.println(cartItem.getName() + "가 장바구니에 추가되었습니다.");
    }

    /**
     * 장바구니에서 동일한 이름으이 항목을 제거합니다.
     *
     * @param cartItem 중복 확인할 항목
     */
    public void filterCartList(T cartItem) {
        cartList.removeIf(item -> item.getName().equals(cartItem.getName()));
    }

    /**
     * 장바구니에 항목이 존재하는지 여부를 반환합니다.
     *
     * @return 장바구니가 비어있으면 {@code false}, 그렇지 않으면 {@code true}
     */
    public boolean hasItems() {
        return !cartList.isEmpty();
    }

    /**
     * 장바구니에 담긴 항목들을 문자열로 반환합니다.
     *
     * @return 장바구니 항목 목록 문자열
     */
    public String renderCartList() {
        StringBuilder sb = new StringBuilder("\n[ Orders ]\n");
        for (CartItem cartItem : cartList) {
            sb.append(cartItem.getName() + " | W ")
                .append(cartItem.getPrice()  + " | ")
                .append(cartItem.getDescription())
                .append("\n");
        }
        return sb.toString();
    }

    /**
     * 장바구니 항목들의 총합 금액 문자열을 반환합니다.
     *
     * @return 총 금액을 포함한 문자열
     */
    public String renderTotalPrice() {
        String totalPrice = "[ Total ]\n";
        totalPrice += "W " + sumPrice() + "\n";
        
        return totalPrice;
    }

    /**
     * 장바구니 항목들의 총합 금액을 계산합니다.
     *
     * @return 총 금액
     */
    private BigDecimal sumPrice() {
        BigDecimal sum = BigDecimal.ZERO;

        for (int  i = 0; i < cartList.size(); i++) {
            BigDecimal price = cartList.get(i).getPrice();
            sum = sum.add(price);
        }

        return sum;
    }

    /**
     * 주문을 완료하고 장바구니를 초기화합니다.
     */
    public void order() {
        // 장바구니를 초기화 한다.
        cartList.clear();
    }

    /**
     * 주어진 할인 정책을 적용한 최종 금액을 반환합니다.
     * 
     * @param discountPolicy 적용할 할인 정책
     * @return 할인 적용 후 금액
     */
    public BigDecimal applyDiscount(DiscountPolicy discountPolicy) {
        // 최종 금액을 계산한다.
        BigDecimal total = sumPrice();

        return discountPolicy.applyDiscount(total); // 할인 적용한 금액을 반환한다.
    }
}
