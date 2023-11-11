package christmas.util.menu;

public enum Desert implements MenuInterface {
    CHOCOLATE_CAKE("초코케이크", 15000),
    ICECREAM("아이스크림,", 5000);

    final String menuName;
    final int price;

    Desert(String menuName, int price) {
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
