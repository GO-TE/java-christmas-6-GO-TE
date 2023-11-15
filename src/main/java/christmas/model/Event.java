package christmas.model;

import christmas.util.Batch;
import christmas.util.Constant;
import christmas.util.menu.Drink;
import christmas.util.message.EventListMessage;
import java.util.HashMap;


public class Event {
    int christmasDDay = 0;
    int starDay = 0;
    boolean weekend = false;
    boolean champagneEvent;
    int dayDiscountEvent;
    String batch;

    public Event(int date, int totalPrice, int count) {
        if (date <= Constant.CHRISTMAS) {
            christmasDDay = Constant.DISCOUNT_BY_DAY * date + Constant.BASE_DISCOUNT;
        }
        if (date % Constant.WEEK == Constant.STAR_DAY || date == Constant.CHRISTMAS) {
            starDay = Constant.BASE_DISCOUNT;
        }
        if (Constant.WEEKEND.contains(date % Constant.WEEK)) {
            weekend = true;
        }
        champagneEvent = (totalPrice >= Constant.CHAMPAGNE_EVENT);
        dayDiscountEvent = setDayDiscountEvent(count);
        batch = setBatch(getTotalBenefit());
    }

    public Event() {
        christmasDDay = 0;
        starDay = 0;
        champagneEvent = false;
        dayDiscountEvent = 0;
    }

    public int setDayDiscountEvent(int count) {
        return count * Constant.MENU_DISCOUNT;
    }

    public int getTotalBenefit() {
        int totalBenefit = 0;
        if (champagneEvent) {
            totalBenefit += Drink.CHAMPAGNE.getPrice();
        }
        totalBenefit += getTotalDiscount();
        return totalBenefit;
    }

    public int getTotalDiscount() {
        return christmasDDay + starDay + dayDiscountEvent;
    }

    public String setBatch(int totalBenefit) {
        for (Batch eachBatch : Batch.values()) {
            if (eachBatch.getCurrentBatch(totalBenefit)) {
                return eachBatch.getBatchName();
            }
        }
        return Constant.NOTHING;
    }

    public boolean isChampagneEvent() {
        return champagneEvent;
    }

    public HashMap<String, Integer> getEventList(int count) {
        HashMap<String, Integer> eventList = new HashMap<>();
        eventList.put(EventListMessage.CHRISTMAS_D_DAY.getEvent(), christmasDDay);
        if (weekend) {
            eventList.put(EventListMessage.WEEKEND.getEvent(), dayDiscountEvent);
        }
        if (!weekend) {
            eventList.put(EventListMessage.WEEKDAY.getEvent(), dayDiscountEvent);
        }
        eventList.put(EventListMessage.STAR_DAY.getEvent(), starDay);
        if (champagneEvent) {
            eventList.put(EventListMessage.CHAMPAGNE.getEvent(), Drink.CHAMPAGNE.getPrice());
        }
        if (!champagneEvent) {
            eventList.put(EventListMessage.CHAMPAGNE.getEvent(), 0);
        }
        return eventList;
    }

    public String getBatch() {
        return batch;
    }
}
