package christmas.util;

import christmas.util.menu.Appetizer;
import christmas.util.menu.Desert;
import christmas.util.menu.Drink;
import christmas.util.menu.MainMenu;
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

    public void validateOrderMenu(String input) {
        validateMenuRegex(input);
        List<String> userMenu = splitInputByComma(input);
        HashMap<String, Integer> order = new HashMap<>();
        for (String eachOrder : userMenu) {
            String[] part = eachOrder.split("-");
            validateEachOrder(part);
            order.put(part[0], Integer.parseInt(part[1]));
        }
        validateOrderCount(order.values());
        checkOnlyDrink(new ArrayList<>(order.keySet()));
    }

    public void validateEachOrder(String[] part) {
        if (!getMenu().contains(part[0])) {
            throw new IllegalArgumentException(ErrorMessage.NON_EXISTENT_MENU.getMessage());
        }
        if (Integer.parseInt(part[1]) >= 0) {
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

    private void validateMenuRegex(String input) {
        if (!input.matches(MENU_REGEX)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_ORDER_REGEX.getMessage());
        }
    }

    public void checkOnlyDrink(List<String> order) {
        if (order.stream()
                .allMatch(menu -> Arrays.stream(Drink.values())
                        .map(Menu::getMenuName)
                        .toList()
                        .contains(menu))) {
            throw new IllegalArgumentException(ErrorMessage.ONLY_DRINKS_EXCEPTION.getMessage());
        }
    }

    private ArrayList<String> getMenu() {
        ArrayList<Menu> menu = new ArrayList<>();
        menu.addAll(getMenuList(Appetizer.values()));
        menu.addAll(getMenuList(MainMenu.values()));
        menu.addAll(getMenuList(Desert.values()));
        menu.addAll(getMenuList(Drink.values()));

        return menu.stream()
                .map(Menu::getMenuName)
                .collect(Collectors.toCollection(ArrayList::new));
    }


    private <T extends Enum<T> & Menu> ArrayList<Menu> getMenuList(T[] values) {
        return new ArrayList<>(Arrays.asList(values));
    }

}
