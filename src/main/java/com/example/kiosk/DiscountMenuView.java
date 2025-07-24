package com.example.kiosk;

/**
 * 할인 메뉴 정보를 포맷하여 문자열로 반환하는 클래스입니다.
 */
public class DiscountMenuView {

    /**
     * 할인 정보 목록을 포맷하여 사용자에게 보여줄 메뉴 문자열을 생성합니다.
     *
     * @return 할인 메뉴 목록 문자열
     */
    public String format() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n할인 정보를 입력해주세요.\n");
        for (DiscountRate dr : DiscountRate.values()) {
            sb.append(dr.ordinal() + 1)
                    .append(". ")
                    .append(dr.getUserType() + " : ")
                    .append(dr.getPercent() + "%")
                    .append("\n");
        }
        return sb.toString();
    }
}
