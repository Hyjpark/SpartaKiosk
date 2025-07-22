package com.example.kiosk;

public class DiscountMenuView {

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
