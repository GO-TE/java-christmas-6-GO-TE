package christmas.util.menu;

public enum Appetizer implements Food {

    MUSHROOM_SOUP("양송이수프", 6000),
    TAPAS("타파스", 5500),
    CAESAR_SALAD("시저샐러드", 8000);

    final String menuName;
    final int price;

    Appetizer(String menuName, int price) {
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
