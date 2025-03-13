package kiosk.lv5;

import kiosk.lv5.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private String category;
    private List<MenuItem> menuItems;

    public Menu(String category) {
        this.category = category;
        this.menuItems = new ArrayList<>();
    }

    // Getter 추가
    public String getCategory() {
        return category;
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    // Setter 추가
    public void setCategory(String category) {
        this.category = category;
    }

    public void addMenuItem(MenuItem item) {
        menuItems.add(item);
    }

    public void printMenu() {
        System.out.println("[ " + category.toUpperCase() + " MENU ]");
        for (int i = 0; i < menuItems.size(); i++) {
            System.out.print((i + 1) + ". ");
            menuItems.get(i).printItem();
        }
        System.out.println("0. 뒤로가기");
    }
}