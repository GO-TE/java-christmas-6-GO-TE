package christmas.View;


import christmas.util.Constant;
import christmas.util.menu.Drink;
import java.util.HashMap;

public class OutputView {
    public void printGuide(int date) {
        System.out.printf("12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리보기!\n", date);
        System.out.println();
    }
    public void printOrder(HashMap<String, Integer> order) {
        System.out.println("<주문 메뉴>");
        for (String menu : order.keySet()) {
            System.out.printf(menu + " %d개\n", order.get(menu));
        }
        System.out.println();
    }

    public void printBeforeDiscount(int price) {
        System.out.println("<할인 전 총주문 금액>");
        System.out.printf("%,d원\n", price);
        System.out.println();
    }

    public void printBenefitList(HashMap<String, Integer> eventList) {
        System.out.println("<혜택 내역>");
        for (String event : eventList.keySet()) {
            if (eventList.get(event) != 0) {
                System.out.printf("%s -%,d원\n", event, eventList.get(event));
            }
        }
        if (eventList.values().stream()
                .allMatch(value -> value == 0)) {
            System.out.println(Constant.NOTHING);
        }

        System.out.println();
    }



    public void printEventBatch(String batch) {
        System.out.println("<12월 이벤트 배지>");
        System.out.println(batch);
    }

    public void printGiveawayMenu(boolean event) {
        System.out.println("<증정 메뉴>");
        if (event) {
            System.out.println(Drink.CHAMPAGNE.getMenuName() + " 1개");
        }
        if (!event) {
            System.out.println(Constant.NOTHING);
        }
        System.out.println();
    }

    public void printTotalBenefit(int totalDiscount) {
        System.out.println("<총혜택 금액>");
        System.out.printf("%,d원\n", -totalDiscount);
        System.out.println();
    }
    public void printForPay(int totalPrice, int totalDiscount) {
        System.out.println("<할인 후 예상 결제 금액>");
        System.out.printf("%,d원\n", totalPrice - totalDiscount);
        System.out.println();
    }

}
