package christmas.util;

import christmas.util.menu.Appetizer;
import christmas.util.menu.Desert;
import christmas.util.menu.Drink;
import christmas.util.menu.MainMenu;
import christmas.util.menu.Menu;
import christmas.util.message.ErrorMessage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Validator {
    private final String DATE_REGEX = "^\\d+$";
    private final String MENU_REGEX = "^([가-힣]+-\\d+,?)+$";

    private int validateDateRegex(String input) {
        if (!input.matches(DATE_REGEX)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_INTEGER_ERROR.getMessage());
        }
        return Integer.parseInt(input);
    }

    public void validateDate(String input) {
        int date = validateDateRegex(input);
        if (date > 31 || date < 1) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_DATE_ERROR.getMessage());
        }
    }

    public void validateOrderMenu(String input) { // 메소드 분리
        validateMenuRegex(input);
        List<String> userMenu = splitInputByComma(input);
        HashMap<String, Integer> order = new HashMap<>();
        for (String eachOrder : userMenu) {
            String[] part = eachOrder.split("-");
            if (Integer.parseInt(part[1]) >= 0) {
                throw new IllegalArgumentException("[ERROR] 메뉴의 갯수를 잘못 입력하셨습니다.");
            }
            order.put(part[0], Integer.parseInt(part[1]));
        }

        if (order.values().stream().mapToInt(Integer::intValue).sum() > 20) {
            throw new IllegalArgumentException("[ERROR] 메뉴는 20개 까지 주문 가능합니다.");
        }
        checkOnlyDrink(new ArrayList<>(order.keySet()));


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
            throw new IllegalArgumentException("[ERROR] 형식에 맞춰 입력해 주세요.");
        }
    }

    public void checkOnlyDrink(List<String> order) {
        if (order.stream()
                .allMatch(menu -> Arrays.stream(Drink.values())
                        .map(Menu::getMenuName)
                        .toList()
                        .contains(menu))) {
            throw new IllegalArgumentException("[ERROR] 음료만 주문 불가 합니다.");
        }
    }

    private ArrayList<String> getMenu(String input) {
        ArrayList<Menu> menu = new ArrayList<>();
        menu.addAll(getMenuList(Appetizer.values()));
        menu.addAll(getMenuList(MainMenu.values()));
        menu.addAll(getMenuList(Desert.values()));
        menu.addAll(getMenuList(Drink.values()));

       return  menu.stream()
                .map(Menu::getMenuName)
                .collect(Collectors.toCollection(ArrayList::new));

    }
    private <T extends Enum<T> & Menu> ArrayList<Menu> getMenuList(T[] values) {
        return new ArrayList<>(Arrays.asList(values));
    }

}
