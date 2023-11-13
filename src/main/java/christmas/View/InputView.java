package christmas.View;

import camp.nextstep.edu.missionutils.Console;
import christmas.util.DateValidator;
import christmas.util.OrderValidator;
import java.util.HashMap;


public class InputView {
    DateValidator dateValidator = new DateValidator();
    OrderValidator orderValidator = new OrderValidator();

    public int inputVisitDate() { // 메세지 상수화
        System.out.println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");
        String input = Console.readLine();
        dateValidator.validateDate(input);
        return Integer.parseInt(input);

    }

    public HashMap<String, Integer> inputOrderMenu() {
        System.out.println("주문하실 메뉴를 메뉴와 개수를 알려주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1");
        String input = Console.readLine();
        return orderValidator.validateOrderMenu(input);
    }

}
