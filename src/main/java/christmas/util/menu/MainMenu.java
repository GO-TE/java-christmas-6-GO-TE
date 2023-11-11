package christmas.util.menu;

public enum MainMenu implements MenuInterface {
    T_BONE_STEAK("티본스테이크", 55000),
    BBQ_RIB("바베큐립", 54000),
    SEA_FOOD_PASTA("해산물파스타", 35000),
    CHRISTMAS_PASTA("크리스마스파스타", 25000);

    final String menuName;
    final int price;

    MainMenu(String menuName, int price) {
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
