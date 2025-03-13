package kiosk.lv4;

import java.util.ArrayList;
import java.util.List;

class Menu {
    String category;
    List<MenuItem> menuItems;

    public Menu(String category) {
        this.category = category;
        this.menuItems = new ArrayList<>();
    }

    public void addMenuItem(MenuItem item) {
        menuItems.add(item);
    }

    public String getCategoryName() {
        return category;
    }

    public void printMenu() {
        System.out.println("[ " + category.toUpperCase() + " MENU ]");
        for (int i = 0; i < menuItems.size(); i++) {
            System.out.print((i + 1) + ". ");
            menuItems.get(i).printItem();
        }
        System.out.println("0. 뒤로가기");
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }
}