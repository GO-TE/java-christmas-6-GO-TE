package christmas.util.message;

public enum ErrorMessage {
    NOT_INTEGER_ERROR("[ERROR] 방문 날짜를 숫자로 입력해 주세요!"),
    INVALID_DATE_ERROR("[ERROR] 방문 날짜를 1~31 사이로 입력해 주세요!"),
    INVALID_MENU_COUNT("[ERROR] 메뉴의 갯수를 잘못 입력하셨습니다."),
    INVALID_OVER_ORDER("[ERROR] 메뉴는 20개 까지 주문 가능합니다."),
    INVALID_ORDER_REGEX("[ERROR] 형식에 맞춰 입력해 주세요. e.g. 음식-갯수,음식-갯수.."),
    ONLY_DRINKS_EXCEPTION("[ERROR] 음료만 주문 불가 합니다."),
    NON_EXISTENT_MENU("[ERROR] 메뉴에 존재하는 메뉴를 입력해 주세요.");


    final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
