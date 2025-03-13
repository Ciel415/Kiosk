package kiosk.lv4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class MenuItem {
    String name;   // 메뉴 이름
    double price;  // 가격
    String description; // 설명

    public MenuItem(String name, double price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public void printItem() {
        System.out.println(name + " | W " + price + " | " + description);
    }
}