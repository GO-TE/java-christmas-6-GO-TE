package christmas.model;

import java.util.HashMap;
import christmas.util.menu.Menu;
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
        for (String menuName :order.keySet()) {
            totalPrice += menu.get(menuName) * order.get(menuName);
        }
        return totalPrice;
    }




}
