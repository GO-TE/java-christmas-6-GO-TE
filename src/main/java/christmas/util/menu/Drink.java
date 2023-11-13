package christmas.util.menu;

public enum Drink implements Food {
    ZERO_COKE("제로콜라", 3000),
    RED_WINE("레드와인", 60000),
    CHAMPAGNE("샴페인", 25000);

    final String menuName;
    final int price;

    Drink(String menuName, int price) {
        this.menuName = menuName;
        this.price = price;
    }

    @Override
    public String getMenuName() {
        return menuName;
    }

    @Override
    public int getPrice() {
        return price;
    }
}
