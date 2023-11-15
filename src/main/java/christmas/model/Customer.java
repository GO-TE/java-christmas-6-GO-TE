package christmas.model;

import christmas.util.menu.Food;
import christmas.util.menu.MainMenu;
import java.util.ArrayList;
import java.util.HashMap;
import christmas.util.menu.Menu;
import java.util.List;

public class Customer {
    private final int visitDate;
    private final HashMap<String, Integer> order;

    public Customer(int visitDate, HashMap<String, Integer> order) {
        this.visitDate = visitDate;
        this.order = order;
    }

    public int getTotalPrice() {
        int totalPrice = 0;
        HashMap<String, Integer> menu = new Menu().getMenuMap();
        for (String menuName : order.keySet()) {
            totalPrice += menu.get(menuName) * order.get(menuName);
        }
        return totalPrice;
    }

    public boolean checkEventRequirement() {
        return getTotalPrice() >= 10000;
    }

    public int getVisitDate() {
        return visitDate;
    }

    public int getDesertCount() {
        int count = 0;
        for (String menu : order.keySet()) {
            if (new Menu().getMainDesertName().contains(menu)) {
                count += order.get(menu);
            }
        }
        return count;
    }

    public int getMainMenuCount() {
        int count = 0;
        for (String menu : order.keySet()) {
            if (new Menu().getMainMenuName().contains(menu)) {
                count += order.get(menu);
            }
        }
        return count;
    }

    public HashMap<String, Integer> getOrder() {
        return order;
    }
}
