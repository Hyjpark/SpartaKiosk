package com.example.kiosk;

/**
 * 프로그램의 흐름 제어를 위한 상태를 정의합니다.
 */
public enum ActionResult {
    /** 계속 진행 */
    CONTINUE,
    /** 메인 메뉴로 돌아가기 */
    RETURN_TO_MENU,
    /** 프로그램 종료 */
    EXIT_PROGRAM
}