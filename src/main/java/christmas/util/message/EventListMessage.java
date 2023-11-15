package christmas.util.message;

public enum EventListMessage {
    CHRISTMAS_D_DAY("크리스마스 디데이 할인"),
    WEEKDAY("평일 할인"),
    WEEKEND("주말 할인"),
    STAR_DAY("특별 할인"),
    CHAMPAGNE("증정 이벤트");

    final String event;
    final String printFormat = ": -%,d원\n";

    EventListMessage(String message) {
        this.event = message;
    }

    public String getMessage() {
        return event + printFormat;
    }

    public String getEvent() {
        return event;
    }
}
