package christmas.util.message;

public enum ErrorMessage {
    NOT_INTEGER_ERROR("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요."),
    INVALID_DATE_ERROR("[ERROR] 방문 날짜를 1~31 사이로 입력해 주세요! 다시 입력해 주세요."),
    INVALID_MENU_COUNT("[ERROR] 메뉴의 갯수를 잘못 입력하셨습니다. 다시 입력해 주세요."),
    INVALID_OVER_ORDER("[ERROR] 메뉴는 20개 까지 주문 가능합니다. 다시 입력해 주세요."),
    INVALID_ORDER_REGEX("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요. 다시 입력해 주세요."),
    ONLY_DRINKS_EXCEPTION("[ERROR] 음료만 주문 불가 합니다. 다시 입력해 주세요."),
    NON_EXISTENT_MENU("[ERROR] 메뉴에 없는 주문입니다. 다시 입력해 주세요.");


    final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
