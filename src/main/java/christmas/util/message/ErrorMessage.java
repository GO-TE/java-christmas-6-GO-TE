package christmas.util.message;

public enum ErrorMessage {
    NOT_INTEGER_ERROR("[ERROR] 방문 날짜를 숫자로 입력해 주세요!"),
    INVALID_DATE_ERROR("[ERROR] 방문 날짜를 1~31 사이로 입력해 주세요!");

    final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
