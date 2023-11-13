package christmas.util.menu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Menu {

    public List<Food> getMenu() {
        ArrayList<Food> menu = new ArrayList<>();
        menu.addAll(getMenuList(Appetizer.values()));
        menu.addAll(getMenuList(MainMenu.values()));
        menu.addAll(getMenuList(Desert.values()));
        menu.addAll(getMenuList(Drink.values()));

        return menu;
    }

    public List<String> getAllMenuName() {
        List<Food> menu = getMenu();

        return menu.stream()
                .map(Food::getMenuName)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public List<Integer> getAllMenuPrice() {
        List<Food> menu = getMenu();

        return menu.stream()
                .map(Food::getPrice)
                .collect(Collectors.toCollection(ArrayList::new));
    }



    public HashMap<String, Integer> getMenuMap() {
        List<String> name = getAllMenuName();
        List<Integer> price = getAllMenuPrice();

        return  IntStream.range(0, name.size())
                .boxed()
                .collect(HashMap::new, (map, i) -> map.put(name.get(i), price.get(i)), HashMap::putAll);
    }


    private <T extends Enum<T> & Food> ArrayList<Food> getMenuList(T[] values) {
        return new ArrayList<>(Arrays.asList(values));
    }

}
