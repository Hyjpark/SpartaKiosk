package com.example.kiosk;

import java.math.BigDecimal;

/**
 * 장바구니에 담기는 개별 항목을 나타내는 클래스입니다.
 *
 * @param <T> {@link ItemDetails}를 구현한 아이템 타입
 */
public class CartItem<T extends ItemDetails> {
    private final T item;

    /**
     * 주어진 아이템으로 CartItem을 생성합니다.
     *
     * @param item 장바구니에 담을 아이템
     */
    public CartItem(T item) {
        this.item = item;
    }

    /**
     * 아이템의 이름을 반환합니다.
     *
     * @return 아이템 이름
     */
    public String getName() {
        return item.getName();
    }

    /**
     * 아이템의 가격을 반환합니다.
     *
     * @return 아이템 가격
     */
    public BigDecimal getPrice() {
        return item.getPrice();
    }

    /**
     * 아이템의 설명을 반환합니다.
     *
     * @return 아이템 설명
     */
    public String getDescription() {
        return item.getDescription();
    }
}
