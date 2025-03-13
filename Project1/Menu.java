package kiosk.dojun1;

import java.util.ArrayList;
import java.util.List;

class Menu {
    private String category;
    private List<MenuItem> items;

    public Menu(String category) {
        this.category = category;
        this.items = new ArrayList<>();
    }

    public String getCategory() {
        return category;
    }

    public List<MenuItem> getItems() {
        return items;
    }

    public void addItem(MenuItem item) {
        items.add(item);
    }

    public void showMenu() {
        System.out.println("\n[ " + category + " MENU ]");

        for (int i = 0; i < items.size(); i++) {
            System.out.print((i + 1) + ". ");
            items.get(i).printItem();
        }

        System.out.println("0. 뒤로가기");
    }
}
