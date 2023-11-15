package christmas.util.validator;

import christmas.util.menu.Food;
import christmas.util.menu.Drink;
import christmas.util.menu.Menu;
import christmas.util.message.ErrorMessage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class OrderValidator {
    private final String MENU_REGEX = "^([가-힣]+-\\d+,?)+$";

    public HashMap<String, Integer> validateOrderMenu(String input) {
        validateOrderRegex(input);
        List<String> userMenu = splitInputByComma(input);
        HashMap<String, Integer> order = new HashMap<>();
        for (String eachOrder : userMenu) {
            String[] part = eachOrder.split("-");
            validateEachOrder(part);
            order.put(part[0], Integer.parseInt(part[1]));
        }
        validateOrderCount(order.values());
        checkOnlyDrink(new ArrayList<>(order.keySet()));
        return order;
    }

    public void validateEachOrder(String[] part) {
        if (!new Menu().getAllMenuName().contains(part[0])) {
            throw new IllegalArgumentException(ErrorMessage.NON_EXISTENT_MENU.getMessage());
        }
        if (Integer.parseInt(part[1]) <= 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_MENU_COUNT.getMessage());
        }
    }

    private void validateOrderCount(Collection<Integer> count) {
        if (count.stream().mapToInt(Integer::intValue).sum() > 20) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_OVER_ORDER.getMessage());
        }
    }

    public List<String> splitInputByComma(String input) {
        if (input.contains(",")) {
            return Arrays.stream(input.split(","))
                    .collect(Collectors.toList());
        }
        return List.of(input);
    }

    private void validateOrderRegex(String input) {
        if (!input.matches(MENU_REGEX)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_ORDER_REGEX.getMessage());
        }
    }

    public void checkOnlyDrink(List<String> order) {
        if (order.stream()
                .allMatch(menu -> Arrays.stream(Drink.values())
                        .map(Food::getMenuName)
                        .toList()
                        .contains(menu))) {
            throw new IllegalArgumentException(ErrorMessage.ONLY_DRINKS_EXCEPTION.getMessage());
        }
    }

}
