package com.example.kiosk;

import java.util.List;
import java.util.stream.IntStream;

/**
 * 메뉴 카테고리와 {@link MenuItem}을 관리하는 클래스입니다.
 */
public class Menu {
    private final String category;
    private final List<MenuItem> menuItems;

    /**
     * 카테고리명과 메뉴 항목 리스트를 받아서 {@code Menu} 객체를 생성합니다.
     *
     * @param category 메뉴 카테고리 이름
     * @param menuItems 해당 카테고리에 속한 메뉴 항목 리스트
     */
    public Menu(String category, List<MenuItem> menuItems) {
        this.category = category;
        this.menuItems = menuItems;
    }

    /**
     * 메뉴 항목들을 깔끔한 형식의 문자열로 반환홥니다.
     * 각 항목은 번호, 이름, 가격, 설명 순으로 출력됩니다.
     *
     * @return 포맷팅된 메뉴 항목 목록 문자열
     */
    public String renderMenuItems() {
        StringBuilder sb = new StringBuilder();
        int blankLength = 12; // 공백 길이

        sb.append("\n[ "+ category.toUpperCase() + " MENU ]\n");
        IntStream.range(0, menuItems.size()).forEach(i -> {
            sb.append((i + 1)).append(". ")
                    .append(menuItems.get(i).getName())
                    .append(" ".repeat(blankLength - menuItems.get(i).getName().length())).append(" | ") // 이름과 가격 사이의 공백 생성
                    .append("W " + menuItems.get(i).getPrice() +  " | ")
                    .append(menuItems.get(i).getDescription())
                    .append("\n");
        });
        sb.append("0. 뒤로가기");

        return sb.toString();
    }

    /**
     * 메뉴 항목 리스트를 반환합니다.
     *
     * @return 메뉴 항목 리스트
     */
    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    /**
     * 메뉴 카테고리명을 반환합니다.
     *
     * @return 메뉴 카테고리명
     */
    public String getCategory() {
        return this.category;
    }
}
